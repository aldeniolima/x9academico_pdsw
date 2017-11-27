package br.edu.ifpe.recife.pdsw.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.edu.ifpe.recife.pdsw.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EntityManagerFactory EMF = Persistence.createEntityManagerFactory("x9academicoPU");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        //Erro erros = new Erro();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        RequestDispatcher rd = null;

        Usuario usuario = null;

        EntityManager em = EMF.createEntityManager();
        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, login);
        try {
            usuario = (Usuario) query.getSingleResult();

        } catch (NoResultException e) {
            usuario = null;
            System.out.println("ERRO: " + e);
        }

        if (usuario != null) {

            if (usuario.getSenha().equals(senha)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario);
                response.sendRedirect("Menu?acao=Home");

            } else {
                //   erros.add("Login ou senha incorretos");
                //   request.setAttribute("mensagens", erros);
                rd = request.getRequestDispatcher("WEB-INF/index.jsp");
                rd.forward(request, response);
                //  response.sendRedirect("MainServlet");
            }
        } else {
            //   erros.add("Login ou senha incorretos");
            //   request.setAttribute("mensagens", erros);
            rd = request.getRequestDispatcher("WEB-INF/index.jsp");
            rd.forward(request, response);
            //  response.sendRedirect("MainServlet");
        }
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

}
