package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.Relatorioparental;
import java.io.IOException;
import java.io.PrintWriter;
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

public class EditarNotas extends HttpServlet {

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
        String lideranca = request.getParameter("lideranca");
        String trabalhoEmEquipe = request.getParameter("trabalhoEmEquipe");
        String participacaoEmSala = request.getParameter("participacaoEmSala");
        String motivacao = request.getParameter("motivacao");
        String criatividade = request.getParameter("criatividade");
        String observacoes = request.getParameter("observacoes");
        String idAln = request.getParameter("A");

        Integer idInteger = Integer.parseInt(idAln);
        Double liderancaDouble = Double.parseDouble(lideranca);
        Double trabalhoDouble = Double.parseDouble(trabalhoEmEquipe);
        Double participacaoDouble = Double.parseDouble(participacaoEmSala);
        Double motivacaoDouble = Double.parseDouble(motivacao);
        Double criatividadeDouble = Double.parseDouble(criatividade);

        Aluno aluno = buscarAln(idInteger);
        Relatorioparental relatorio = aluno.getRelatorioParental();
        relatorio.setLideranca(liderancaDouble);
        relatorio.setCriatividade(criatividadeDouble);
        relatorio.setMotivacao(motivacaoDouble);
        relatorio.setObservacoes(observacoes);
        relatorio.setParticipacaoEmSala(participacaoDouble);
        relatorio.setTrabalhoEmEquipe(trabalhoDouble);
        relatorio.setIdRelatorioParental(relatorio.getIdRelatorioParental());
        atualizar(relatorio);
        
        response.sendRedirect("Menu?acao=notas&A="+idInteger);
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

    public Relatorioparental atualizar(Relatorioparental entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(entity);
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
