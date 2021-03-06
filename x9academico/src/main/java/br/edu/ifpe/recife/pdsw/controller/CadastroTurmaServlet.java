package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Professor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.recife.pdsw.model.Turma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author aldo_neto
 */
public class CadastroTurmaServlet extends HttpServlet {

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
        String serie = request.getParameter("serie");
        int sala = Integer.parseInt(request.getParameter("sala"));
        int qtdAluno = Integer.parseInt(request.getParameter("quantidade_alunos"));
        Integer idProf = Integer.parseInt(request.getParameter("id_prof"));
        String turno = request.getParameter("turno");

        Turma turma = new Turma();

        turma.setSerie(serie);
        turma.setNumeroSala(sala);
        turma.setQtdAluno(qtdAluno);
        turma.setTurno(turno);
        turma.setProfessor(RecuperaProfId(idProf));

        Turma turmaVerifica = inserir(turma);
        if (turmaVerifica != null) {
            // erros.add("Turma cadastrada");
        } else {
            // erros.add("Turma não cadastrada");
        }
        response.sendRedirect("Menu?acao=cadastrar_turma");
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

    public Turma inserir(Turma entity) {
        EntityManager em = null;
        EntityTransaction et = null;
        Turma turma;
        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
            et.commit();
            turma = entity;
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            turma = null;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return turma;

    }

    public Professor RecuperaProfId(int id) {
        EntityManager em = EMF.createEntityManager();

        String jpa = "SELECT u FROM Professor u Where u.idUsuario = ?1";
        Query query = em.createQuery(jpa);
        query.setParameter(1, id);
        try {
            Professor prof = (Professor) query.getSingleResult();
            return prof;
        } catch (NoResultException e) {
            return null;
        }
    }

}
