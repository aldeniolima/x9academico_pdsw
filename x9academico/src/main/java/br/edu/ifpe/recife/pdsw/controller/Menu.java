package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Professor;
import br.edu.ifpe.recife.pdsw.model.Responsavel;
import br.edu.ifpe.recife.pdsw.model.Turma;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpe.recife.pdsw.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Menu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

        String acao = request.getParameter("acao");

        RequestDispatcher rd = null;
        switch (usuario.getDtype()) {
            case "A":
                switch (acao) {
                    case "Home":
                        rd = request.getRequestDispatcher("WEB-INF/view/menu.jsp");
                        rd.forward(request, response);
                        break;
                    case "cadastrar_turma":
                        request.setAttribute("listaProf", listarProf());
                        rd = request.getRequestDispatcher("WEB-INF/view/cadastrar_turma.jsp");
                        rd.forward(request, response);
                        break;
                    case "alterar_turmas":
                        rd = request.getRequestDispatcher("AlterarTurmaServlet");
                        rd.forward(request, response);
                        break;
                    case "editar_turma":
                        Integer codigo_turma = Integer.parseInt(request.getParameter("codigo"));
                        Turma editaTurma = getSingleID(codigo_turma);
                        if (editaTurma != null) {
                            request.getSession().setAttribute("turma_editada", editaTurma);
                            request.setAttribute("turmaEditar", editaTurma);
                            request.setAttribute("listaprof", listarProf());
                            rd = request.getRequestDispatcher("WEB-INF/view/editar_turma.jsp");

                        } else {
                            rd = request.getRequestDispatcher("WEB-INF/view/alterar_turma.jsp");
                        }
                        rd.forward(request, response);
                        break;
                    case "listar_turmas":
                        request.setAttribute("listaTurma", listarTurma());
                        rd = request.getRequestDispatcher("WEB-INF/view/listar_turmas.jsp");
                        rd.forward(request, response);
                        break;
                    case "cadastrar_prof":
                        request.setAttribute("listaTurmas", listarTurma());
                        rd = request.getRequestDispatcher("WEB-INF/view/cadastrar_professor.jsp");
                        rd.forward(request, response);
                        break;
                    case "alterar_prof":
                        rd = request.getRequestDispatcher("AlterarProfServlet");
                        rd.forward(request, response);
                        break;

                    case "editar_prof":
                        Integer id_prof = Integer.parseInt(request.getParameter("codigo"));
                        Professor editaProf = buscarProf(id_prof);
                        request.getSession().setAttribute("professor_editado", editaProf);
                        request.setAttribute("profEditar", editaProf);
                        rd = request.getRequestDispatcher("WEB-INF/view/editar_professor.jsp");
                        rd.forward(request, response);
                        break;
                    case "listar_prof":
                        request.setAttribute("listaProf", listarProf());
                        rd = request.getRequestDispatcher("WEB-INF/view/listar_professores.jsp");
                        rd.forward(request, response);
                        break;
                    case "cadastrar_aluno":
                        request.setAttribute("listaTurmas", listarTurma());
                        rd = request.getRequestDispatcher("WEB-INF/view/cadastrar_aluno.jsp");
                        rd.forward(request, response);
                        break;
                    case "editar_aluno":
                        Integer id_aluno = Integer.parseInt(request.getParameter("aln"));
                        Aluno editaAln = buscarAln(id_aluno);
                        request.setAttribute("aluno", editaAln);
                        request.getSession(false).setAttribute("aluno_editado", editaAln);
                        rd = request.getRequestDispatcher("WEB-INF/view/editar_aluno.jsp");
                        rd.forward(request, response);
                        break;
                    case "alterar_aluno":
                        Object confir_editar = request.getSession().getAttribute("mensagens");
                        request.setAttribute("mensagens", confir_editar);
                        request.setAttribute("listaTurmas", listarTurma());
                        rd = request.getRequestDispatcher("WEB-INF/view/alterar_aluno.jsp");
                        rd.forward(request, response);
                        request.getSession().setAttribute("mensagens", null);
                        break;
                    case "listar_aluno":
                        request.setAttribute("listaTurmas", listarTurma());
                        rd = request.getRequestDispatcher("WEB-INF/view/listar_alunos.jsp");
                        rd.forward(request, response);
                        break;
                    case "dados_pessoais":
                        rd = request.getRequestDispatcher("WEB-INF/view/dados_pessoais.jsp");
                        rd.forward(request, response);
                        break;
                    case "construindo":

                        rd = request.getRequestDispatcher("WEB-INF/view/construindo.jsp");
                        rd.forward(request, response);
                        break;
                }
                break;
            case "P":
                switch (acao) {
                    case "Home":
                        rd = request.getRequestDispatcher("WEB-INF/view/menu_prof.jsp");
                        rd.forward(request, response);
                        break;
                    case "listar_turmas":
                        rd = request.getRequestDispatcher("WEB-INF/view/listar_turmas_prof.jsp");
                        rd.forward(request, response);
                        break;

                    case "listar_alunos":
                        String idString = request.getParameter("T");
                        if (idString.isEmpty()) {

                        } else {
                            Integer id = Integer.parseInt(idString);
                            List alunos = listarAlunosProf(getSingleID(id));
                            request.setAttribute("listaAlunos", alunos);
                        }

                        rd = request.getRequestDispatcher("WEB-INF/view/listar_alunos_prof.jsp");
                        rd.forward(request, response);
                        break;
                    case "notas":
                        String idStringAln = request.getParameter("A");
                        if (idStringAln.isEmpty()) {
                            rd = request.getRequestDispatcher("WEB-INF/view/menu_prof.jsp");
                        } else {
                            Integer idAln = Integer.parseInt(idStringAln);
                            Aluno aluno = buscarAln(idAln);
                            if (aluno.getTurma().getProfessor().getNome().equals(usuario.getNome())) {
                                request.setAttribute("A", idAln);
                                request.setAttribute("notas", aluno.getRelatorioParental());
                                rd = request.getRequestDispatcher("WEB-INF/view/notas.jsp");
                            } else {
                                rd = request.getRequestDispatcher("WEB-INF/view/menu_prof.jsp");
                            }
                        }

                        rd.forward(request, response);
                        break;
                    case "dados_pessoais":
                        rd = request.getRequestDispatcher("WEB-INF/view/dados_pessoais.jsp");
                        rd.forward(request, response);
                        break;
                }
                break;
            case "R":
                switch (acao) {
                    case "Home":
                        rd = request.getRequestDispatcher("WEB-INF/view/menu_resp.jsp");
                        rd.forward(request, response);
                        break;
                    case "listar_alunos":
                        Responsavel responsavel = (Responsavel) usuario;
                        request.setAttribute("listaAlunos", responsavel.getAlunos());
                        rd = request.getRequestDispatcher("WEB-INF/view/listar_alunos_resp.jsp");
                        rd.forward(request, response);
                        break;
                    case "notas":
                        String idStringAln = request.getParameter("A");
                        if (idStringAln.isEmpty()) {
                            rd = request.getRequestDispatcher("WEB-INF/view/menu_resp.jsp");
                        } else {
                            Integer idAln = Integer.parseInt(idStringAln);
                            Aluno aluno = buscarAln(idAln);
                            if (aluno != null) {
                                request.setAttribute("notas", aluno.getRelatorioParental());
                                rd = request.getRequestDispatcher("WEB-INF/view/notas_resp.jsp");
                            } else {
                                rd = request.getRequestDispatcher("WEB-INF/view/menu_resp.jsp");
                            }
                        }

                        rd.forward(request, response);
                        break;
                    case "dados_pessoais":
                        rd = request.getRequestDispatcher("WEB-INF/view/dados_pessoais.jsp");
                        rd.forward(request, response);
                        break;
                }
                break;
        }

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

    public List<Turma> getSingleList(int id) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Turma u Where u.idTurma = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, id);
        try {
            List list = (List<Turma>) query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Turma getSingleID(int id) {
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

    public List<Turma> listarTurma() {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Turma u";
        Query query = em.createQuery(jpa);

        try {
            List list = (List<Turma>) query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Professor> listarProf() {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Professor u";
        Query query = em.createQuery(jpa);
        try {
            List list = (List<Professor>) query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Professor buscarProf(int id) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Professor u Where u.idUsuario = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, id);

        try {
            Professor professor = (Professor) query.getSingleResult();
            return professor;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Aluno buscarAln(int id) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Aluno u where u.idAluno = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, id);

        try {
            Aluno aluno = (Aluno) query.getSingleResult();
            return aluno;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Aluno> listarAlunosProf(Turma turma) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Aluno u Where u.turma = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, turma);
        try {
            List list = (List<Aluno>) query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
    }
}
