package ru.fella.learn.jpa;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by efischenko on 19.04.2018.
 */
public class TestTableRepositoryCustomImpl implements TestTableRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void saveHellowithName(String name) {
        TestTable testTable = new TestTable();
        testTable.setId(2);
        testTable.setValue("Hello, " + name + "!");
        em.persist(testTable);

    }
}
