package co.com.claro.otpParameters.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class AbstractDao<T> {

    private final boolean IS_DEBUG = false;
    private Class<T> entityClass;

    /**
     *
     * @param entityClass
     */
    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractDao() {
    }

    /**
     *
     * @return EntityManager
     */
    protected abstract EntityManager getEntityManager();

    /**
     *
     * @param entity
     * @throws Exception
     */
    public void create(T entity) throws Exception {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
        } catch (PersistenceException ex) {
            showErrorJpa(ex, entity);
        } catch (ConstraintViolationException ce) {
            for (ConstraintViolation violation : ce.getConstraintViolations()) {
                System.err.println("Violation" + violation.toString());
            }
            throw new Exception(ce.getMessage());
        }
    }

    /**
     *
     * @param entity
     * @throws Exception
     */
    public void edit(T entity) throws Exception {
        try {
            getEntityManager().merge(entity);
            getEntityManager().flush();
        } catch (PersistenceException ex) {
            showErrorJpa(ex, entity);
        } catch (ConstraintViolationException ce) {
            for (ConstraintViolation violation : ce.getConstraintViolations()) {
                System.err.println("Violation" + violation.toString());
            }
            throw new Exception(ce.getMessage());
        }
    }

    /**
     *
     * @param entity
     * @throws Exception
     */
    public void remove(T entity) throws Exception {
        try {
            getEntityManager().remove(entity);
            getEntityManager().flush();
        } catch (PersistenceException ex) {
            showErrorJpa(ex, entity);
        }
    }

    /**
     *
     * @param id
     * @return T
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     *
     * @return List
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     *
     * @param range
     * @return List
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     *
     * @return int
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     *
     * @param entity
     * @return boolean
     */
    public boolean isConstraintValidationsViolated(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(
                entity);

        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator
                    = constraintViolations.iterator();

            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName() + "."
                        + cv.getPropertyPath() + " " + cv.getMessage());
                System.err.println(cv.getRootBeanClass().getSimpleName() + "."
                        + cv.getPropertyPath() + " " + cv.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param e
     * @param entity
     * @throws Exception
     */
    private void showErrorJpa(PersistenceException e, T entity) throws Exception {
    }
}
