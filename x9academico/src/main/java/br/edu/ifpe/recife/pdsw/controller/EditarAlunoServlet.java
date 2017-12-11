/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.pdsw.controller;

import br.edu.ifpe.recife.pdsw.model.Aluno;
import br.edu.ifpe.recife.pdsw.model.FormataData;
import br.edu.ifpe.recife.pdsw.util.Erro;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joselima
 */
public class EditarAlunoServlet extends HttpServlet {

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

        RequestDispatcher rd = null;
        Erro erros = new Erro();

        Aluno aluno = (Aluno) request.getSession(false).getAttribute("aluno_editado");

        Aluno alunoEditado = new Aluno();

        String nome = request.getParameter("nome");
        String nascimento = request.getParameter("data_nascimento");

        String deficiencia = request.getParameter("deficiencia_aluno");

        alunoEditado.setIdAluno(aluno.getIdAluno());
        alunoEditado.setNome(nome);
        FormataData formataData = new FormataData();

        /* Datas formatadas */
        Date data_aln_formatada = formataData.formata(nascimento);
        /* FIM */

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data_aln_formatada);
        alunoEditado.setDataNascimento(calendar.getTime());
        alunoEditado.setDeficiencia(deficiencia);
        alunoEditado.setMatricula(aluno.getMatricula());
        alunoEditado.setTurma(aluno.getTurma());
        alunoEditado.setRelatorioParental(aluno.getRelatorioParental());
        alunoEditado.setResponsavel(aluno.getResponsavel());

        
        Aluno alunoVerifica = atualizar(alunoEditado);
        if (alunoVerifica != null) {
            erros.add("Dados atualizados");
        } else {
            erros.add("Os dados não foram atualizados");
        }
        request.getSession().setAttribute("mensagens", erros);

        response.sendRedirect("Menu?acao=alterar_aluno");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Aluno atualizar(Aluno entity) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.merge(entity);
            et.commit();
            return entity;
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
