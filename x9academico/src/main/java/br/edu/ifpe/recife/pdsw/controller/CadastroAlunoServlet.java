package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Endereco;
import br.edu.ifpe.recife.pdsw.model.FormataData;
import br.edu.ifpe.recife.pdsw.model.RelatorioParental;
import br.edu.ifpe.recife.pdsw.model.Responsavel;
import br.edu.ifpe.recife.pdsw.model.Turma;
import br.edu.ifpe.recife.pdsw.model.Usuario;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroAlunoServlet extends HttpServlet {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("x9academicoPU");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        String nascimento = request.getParameter("data_nascimento");
        int turma_aluno = Integer.parseInt(request.getParameter("id_turma"));
        String deficiencia = request.getParameter("deficiencia_aluno");

        String nome_resp = request.getParameter("nome_resp");
        String nascimento_resp = request.getParameter("data_nascimento_resp");
        String endereco_resp = request.getParameter("endereco_resp");
        String telefone_resp = request.getParameter("telefone_resp");
        String email_resp = request.getParameter("email_resp");
        String cpf_resp = request.getParameter("cpf_resp");
        String rg_resp = request.getParameter("rg_resp");
        String login_resp = request.getParameter("login_resp");
        String senha_resp = request.getParameter("senha_resp");
        String confirma_senha_resp = request.getParameter("confirma_senha_resp");
        String cep_resp = request.getParameter("cep_resp");
        String cidade_resp = request.getParameter("cidade_resp");
        int numero_resp = Integer.parseInt(request.getParameter("numero_resp"));
        String UF_resp = request.getParameter("UF_resp");
        String parentesco = request.getParameter("grau_parentesco_resp");

        Usuario user = getSingleUsuario(login_resp);
        if (user != null) {
            // erros.add("Login já cadastrado");
        } else {
            if (senha_resp.equals(confirma_senha_resp)) {

                Aluno aluno = new Aluno();
                Responsavel responsavel = new Responsavel();
                Endereco end = new Endereco();
                RelatorioParental relatorio = new RelatorioParental();

                end.setCep(cep_resp);
                end.setCidade(cidade_resp);
                end.setNumeroEndereco(numero_resp);
                end.setRua(endereco_resp);
                end.setUf(UF_resp);

                responsavel.setCpf(cpf_resp);
                responsavel.setEmail(email_resp);
                responsavel.setEndereco(inserirEnd(end));
                responsavel.setNome(nome_resp);
                responsavel.setTelefone(telefone_resp);
                // responsavel.set(parentesco);

                responsavel.setLogin(login_resp);
                responsavel.setSenha(senha_resp);
                //responsavel.setTi(3);

                FormataData formataData = new FormataData();

                /* Datas formatadas */
                Date data_resp_formatada = formataData.formata(nascimento_resp);
                Date data_aln_formatada = formataData.formata(nascimento);

                /* FIM */
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(data_resp_formatada);
                responsavel.setDataNascimento(calendar.getTime());

                //responsavel.set(rg_resp);

                aluno.setMatricula(matricula);
                aluno.setDeficiencia(deficiencia);
                aluno.setNome(nome);
                calendar.setTime(data_aln_formatada);
                aluno.setDataNascimento(calendar.getTime());
                aluno.setTurma(getSingleTurma(turma_aluno));
                aluno.setResponsavel(inserirResp(responsavel));
                aluno.setRelatorioParental(inserirRel(relatorio));
                inserirAln(aluno);

            } else {
                // erros.add("Senha errada");
            }

        }
        response.sendRedirect("Menu?acao=cadastrar_aluno");

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

    public Usuario getSingleUsuario(String login) {
        EntityManager em = EMF.createEntityManager();

        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, login);
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Turma getSingleTurma(int id) {
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

    public Endereco inserirEnd(Endereco entity) {
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

    public Responsavel inserirResp(Responsavel entity) {
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

    public Aluno inserirAln(Aluno entity) {
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

    public RelatorioParental inserirRel(RelatorioParental entity) {
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
