package ru.fella.learn.jpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fella.learn.jpa.TestTable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * Created by efischenko on 19.04.2018.
 */
@Repository
@Transactional
public class TestTableDaoImpl implements TestTableDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public TestTable getByValue(String value) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TestTable> criteria = builder.createQuery(TestTable.class);
        Root<TestTable> from = criteria.from(TestTable.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("value"), value));
        TypedQuery<TestTable> typed = em.createQuery(criteria);
        TestTable testTable;
        try {
            testTable = typed.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return testTable;
    }

    @Override
    public void save(TestTable table) {
        em.persist(table);
    }

    @Override
    public List<TestTable> findAll() {
        return em.createQuery("Select t from " + TestTable.class.getSimpleName() + " t").getResultList();
    }
}
