package br.edu.ifpe.recife.pdsw.tests;

import br.edu.ifpe.recife.pdsw.model.Usuario;

import br.edu.ifpe.recife.pdsw.model.Administrador;
import br.edu.ifpe.recife.pdsw.model.Endereco;

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
public class JpqlCRUDAdmin {

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
        endereco.setCidade("olinda");
        endereco.setNumeroend(123);
        endereco.setRua("abc");
        endereco.setUf("pe");

        return endereco;
    }

    @Test
    public void t01_criaAdmin() {
        logger.info("Executando t01: CriarAdmin");
        Administrador admin = new Administrador();

        admin.setCpf("075.335.464-07");
        admin.setNomecompleto("Gilbertojpql");
        admin.setEmail("aaa@bbb.com");
        admin.setSenha("1234.Qu");
        admin.setTelefone("1199898932");
        admin.setEndereco(insereEndereco());
        admin.setDataNascimento("10/10/1990");
        admin.setCargo("Coordenador");
        admin.setLogin("administrador");

        em.persist(admin);
        em.flush();
        assertNotNull(admin.getIdusuario());

    }

    @Test
    public void t02_buscaAdmin() {

        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "administrador");

        Usuario usuario = (Usuario) query.getSingleResult();

        assertEquals("administrador", usuario.getLogin());

    }

    @Test
    public void t03_atualizaAdmin() {
        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "administrador");

        Usuario usuario = (Usuario) query.getSingleResult();
        usuario.setEmail("apsn@a.recife");
        usuario.setSenha("yT.765432");
        em.merge(usuario);
        //Perguntar ao professor
        em.flush();
        //em.clear();
        usuario = (Usuario) query.getSingleResult();
        assertEquals("yT.765432", usuario.getSenha());
        assertEquals("apsn@a.recife", usuario.getEmail());
    }

    @Test
    public void t04_removeAdmin() {

        String jpql = "SELECT u FROM Usuario u where u.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "administrador");

        Usuario usuario = (Usuario) query.getSingleResult();

        em.remove(usuario);

        em.flush();

        em.clear();

        assertEquals(0, query.getResultList().size());

    }

}
