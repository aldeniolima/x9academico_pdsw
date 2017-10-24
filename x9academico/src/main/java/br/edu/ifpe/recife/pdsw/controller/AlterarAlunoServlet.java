package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Turma;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarAlunoServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        int turma_aluno = Integer.parseInt(request.getParameter("id_turma"));
        request.setAttribute("listaTurmas", listarTurmas());
        request.setAttribute("listaAluno", alunosTurma(turmaId(turma_aluno)));
        rd = request.getRequestDispatcher("WEB-INF/view/alterar_aluno.jsp");
        rd.forward(request, response);
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

    public List<Turma> listarTurmas() {
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

    public Turma turmaId(int id) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Turma u Where u.idturma = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, id);
        try {
            Turma turma = (Turma) query.getSingleResult();
            return turma;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Aluno> alunosTurma(Turma x) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Aluno u where u.turmaIdturma = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, x);

        try {
            List list = (List<Aluno>) query.getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }
    }
}
