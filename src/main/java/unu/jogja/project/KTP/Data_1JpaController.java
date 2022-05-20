/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unu.jogja.project.KTP;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import unu.jogja.project.KTP.exceptions.NonexistentEntityException;
import unu.jogja.project.KTP.exceptions.PreexistingEntityException;

/**
 *
 * @author Asus
 */
public class Data_1JpaController implements Serializable {

    public Data_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("unu.jogja_project.KTP_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Data_1JpaController() {
    }

    public void create(Data_1 data_1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(data_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findData_1(data_1.getDataPK()) != null) {
                throw new PreexistingEntityException("Data_1 " + data_1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Data_1 data_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            data_1 = em.merge(data_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DataPK id = data_1.getDataPK();
                if (findData_1(id) == null) {
                    throw new NonexistentEntityException("The data_1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DataPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Data_1 data_1;
            try {
                data_1 = em.getReference(Data_1.class, id);
                data_1.getDataPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The data_1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(data_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Data_1> findData_1Entities() {
        return findData_1Entities(true, -1, -1);
    }

    public List<Data_1> findData_1Entities(int maxResults, int firstResult) {
        return findData_1Entities(false, maxResults, firstResult);
    }

    private List<Data_1> findData_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Data_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Data_1 findData_1(DataPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Data_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getData_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Data_1> rt = cq.from(Data_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
