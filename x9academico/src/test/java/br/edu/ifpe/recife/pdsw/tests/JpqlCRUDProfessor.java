/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.pdsw.tests;

import br.edu.ifpe.recife.pdsw.model.Endereco;
import br.edu.ifpe.recife.pdsw.model.Professor;

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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JpqlCRUDProfessor {

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

    public static Endereco insereEndereco() {
        Endereco endereco = new Endereco();

       
        endereco.setCep("68.765-874");
        endereco.setCidade("Jaboatao");
        endereco.setNumeroend(456);
        endereco.setRua("rua 4");
        endereco.setUf("pe");

        return endereco;

    }

    @Test
    public void t01_criarProfessor() {
        Professor prof = new Professor();

        prof.setNomecompleto("Alberto");
        prof.setEmail("aaa@bbb.com");
        prof.setTelefone("8398988989");
        prof.setCpf("096.328.124-09");
        prof.setEndereco(insereEndereco());
        prof.setLogin("prof");
        prof.setSenha(".Ae345676");

        prof.setDataNascimento("09/09/0991");

        em.persist(prof);

        em.flush();

        assertNotNull(prof.getIdusuario());
    }

    @Test
    public void t02_listarProfessores() {
        List<Professor> professores;

        String jpql = "SELECT u FROM Professor u";
        Query query = em.createQuery(jpql);

        professores = query.getResultList();
        System.out.println(professores);

        assertEquals(2, query.getResultList().size());
    }

    @Test
    public void t03_buscaProfessor() {
        Professor prof;

        String jpql = "SELECT u FROM Usuario u Where u.idUsuario = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, 3);

        prof = (Professor) query.getSingleResult();

        Long id = (long) 3;

        assertEquals(id, prof.getIdusuario());

    }

    @Test
    public void t04_atualizaProfessor() {
        Professor prof;
        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);

        query.setParameter(1, "professor");

        prof = (Professor) query.getSingleResult();

        prof.setNomecompleto("Valdemar");
        prof.setLogin("prof123");

        em.merge(prof);

        em.flush();

        assertEquals(0, query.getResultList().size());

    }

    @Test
    public void t05_removeProfessor() {

        Long id = (long) 3;
        Professor prof;
        String jpql = "SELECT u FROM Usuario u where u.idUsuario = ?1";
        Query query = em.createQuery(jpql);

        query.setParameter(1, id);

        prof = (Professor) query.getSingleResult();

        em.remove(prof);

        em.flush();

        Professor apagado = em.find(Professor.class, id);

        assertNull(apagado);

    }

}
