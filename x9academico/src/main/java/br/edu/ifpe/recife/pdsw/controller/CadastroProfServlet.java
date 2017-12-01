package br.edu.ifpe.recife.pdsw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpe.recife.pdsw.model.Endereco;
import br.edu.ifpe.recife.pdsw.model.FormataData;
import br.edu.ifpe.recife.pdsw.model.Professor;
import br.edu.ifpe.recife.pdsw.model.Turma;
import br.edu.ifpe.recife.pdsw.model.Usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CadastroProfServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("x9academicoPU");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nome = request.getParameter("nome");
        String nascimento = request.getParameter("data_nascimento");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String confirma_senha = request.getParameter("confirma_senha");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String UF = request.getParameter("UF");

        Usuario user = getSingle(login);
        if (user != null) {
            //erros.add("Login já cadastrado");
        } else {
            if (senha.equals(confirma_senha)) {
                Professor profCadastrado = new Professor();
                Endereco end = new Endereco();

                end.setCep(cep);
                end.setCidade(cidade);
                end.setNumeroEndereco(numero);
                end.setRua(endereco);
                end.setUf(UF);

                profCadastrado.setCpf(cpf);
               // profCadastrado.setRg(rg);
                profCadastrado.setEmail(email);
                profCadastrado.setEndereco(inserirEndereco(end));
                profCadastrado.setNome(nome);
                profCadastrado.setTelefone(telefone);

                profCadastrado.setLogin(login);
                profCadastrado.setSenha(senha);
                //profCadastrado.setTipousuarios(2);
               // profCadastrado.setTurmas(getSingleIDTurma(id_turma));
                
                FormataData formataData = new FormataData();

                /* Datas formatadas */
                Date data_prof_formatada = formataData.formata(nascimento);
                /* FIM */
                
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(data_prof_formatada); 
                profCadastrado.setDataNascimento(calendar.getTime());

                inserirProf(profCadastrado);
            } else {

            }

        }

        // RequestDispatcher rd = request.getRequestDispatcher("ListarProfServlet");
        // rd.forward(request, response);
        // request.getSession().setAttribute("mensagens", erros);
        response.sendRedirect("Menu?acao=cadastrar_prof");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Usuario getSingle(String login) {
        EntityManager em = EMF.createEntityManager();

        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, login);

        try {
            Usuario professor = (Usuario) query.getSingleResult();
            return professor;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Endereco inserirEndereco(Endereco entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return entity;

    }

    public Turma getSingleIDTurma(int id) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Turma u Where u.idTurma = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, id);
        try {
            Turma turma = (Turma) query.getSingleResult();
            return turma;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Professor inserirProf(Professor entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return entity;

    }

}
