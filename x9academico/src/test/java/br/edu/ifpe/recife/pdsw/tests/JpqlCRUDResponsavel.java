/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.pdsw.tests;

import br.edu.ifpe.recife.pdsw.model.Endereco;
import br.edu.ifpe.recife.pdsw.model.Responsavel;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JpqlCRUDResponsavel {
    
      private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        emf = Persistence.createEntityManagerFactory("x9academicoPU");

    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }

    @After
    public void tearDown() {
        try {
            et.commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());

            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            em = null;
            et = null;
        }
    }

    
    @Test
    public void t01_criaResponsavel() {

        Endereco endereco = new Endereco();

        endereco.setCep("22.244-556");
        endereco.setCidade("Recife");
        endereco.setNumeroend(123);
        endereco.setRua("Rua Cinco");
        endereco.setUf("pe");

        Responsavel resp = new Responsavel();

        resp.setCpf("826.176.274-20");
        resp.setNomecompleto("Gilberto");
        resp.setEmail("aaa@bbb.com");
        resp.setEndereco(endereco);
        resp.setSenha("1234.Op");
        resp.setTelefone("8199898976");
       
        resp.setDataNascimento("08/07/1990");

        resp.setLogin("resp_123");

        em.persist(resp);
        
        em.flush();
        
        assertNotNull(resp.getIdusuario());
        
    }

    @Test
    public void t02_listarResponsaveis() {
        List<Responsavel> responsaveis;

        String jpql = "SELECT u FROM Responsavel u";
        Query query = em.createQuery(jpql);

       
            responsaveis = (List<Responsavel>) query.getResultList();
            
            
            assertEquals(1, query.getResultList().size());

    }

    @Test
    public void t03_buscaResponsavel() {
        Responsavel resp = new Responsavel();

        String jpql = "SELECT u FROM Usuario u Where u.nomecompleto = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "Gilberto");

       
            resp = (Responsavel) query.getSingleResult();
            

            
            assertEquals("Gilberto", resp.getNomecompleto());
    }

    @Test
    public void t04_atualizaResponsavel() {
        Responsavel resp;

        String jpql = "SELECT u FROM Usuario u Where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "resp_123");

        
            resp = (Responsavel) query.getSingleResult();

            resp.setNomecompleto("Josias");

            resp.setEmail("josias@hotmail.com");

            em.merge(resp);
            
            em.flush();
            
           assertEquals(0, query.getResultList().size());
            
    }

    @Test
    public void t05_removeResponsavel() {
        
        Long id = (long) 1;
        
        Responsavel resp;

        String jpql = "SELECT u FROM Usuario u Where u.idusuario = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, id);

        
            resp = (Responsavel) query.getSingleResult();

            em.remove(resp);
            
            em.flush();
            
            Responsavel apagado =  em.find(Responsavel.class, id);
            
            assertNull(apagado);

    }
}
