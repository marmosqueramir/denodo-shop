package com.denodo.challenge.jpa;

import com.denodo.challenge.exceptions.ModelException;
import com.denodo.challenge.exceptions.UtilExceptionMethods;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceNotFoundException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class JPADaoImpl<T, P extends Serializable> implements GenericEntityDao<T, P> {

    protected Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    private Logger log = Logger.getLogger(JPADaoImpl.class);

    public JPADaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T findOne(P id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T create(T t) throws ModelException {
        try {
            getEntityManager().persist(t);
            return t;
        } catch (PersistenceException e) {
            throw new ModelException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void flush() {
        getEntityManager().flush();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void clear() {
        getEntityManager().clear();
    }

    @Override
    public void detach(T obj) {
        getEntityManager().detach(obj);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T update(T t) {
        return getEntityManager().merge(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(T t) {
        try {
            EntityManager em = getEntityManager();
            t = em.merge(t);
            em.remove(t);
            em.flush();
            em.clear();
        } catch (Exception e) {
            UtilExceptionMethods.evaluateAndLogRecursiveError(log, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteNoMerge(T t) {
        try {
            EntityManager em = getEntityManager();
            em.remove(t);
            em.flush();
            em.clear();
        } catch (Exception e) {
            UtilExceptionMethods.evaluateAndLogRecursiveError(log, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(P id) throws InstanceNotFoundException {
        EntityManager em = getEntityManager();
        try {
            T t = em.find(entityClass, id);
            if (em.contains(t)) {
                t = em.merge(t);
                em.remove(t);
                em.flush();
                em.clear();
            } else {
                throw new InstanceNotFoundException("Not found element " + id);
            }
        } catch (PersistenceException pe) {
            throw new InstanceNotFoundException(pe.getCause() != null ? pe.getCause().getMessage() : pe.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + entityClass.getName()).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}