package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Turma;
import java.io.IOException;
import java.util.ArrayList;
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

public class AlterarTurmaServlet extends HttpServlet {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("x9academicoPU");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;

        Object confir_editar = request.getSession().getAttribute("mensagens");
        request.setAttribute("mensagens", confir_editar);

        request.setAttribute("listaTurma", listar());
        rd = request.getRequestDispatcher("WEB-INF/view/alterar_turma.jsp");
        rd.forward(request, response);
        request.getSession().setAttribute("mensagens", null);

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

    public List<Turma> listar() {
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
}
