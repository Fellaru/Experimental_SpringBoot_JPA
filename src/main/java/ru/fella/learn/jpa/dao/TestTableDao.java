package ru.fella.learn.jpa.dao;

import ru.fella.learn.jpa.TestTable;

import java.util.List;

/**
 * Created by efischenko on 19.04.2018.
 */
public interface TestTableDao {
    TestTable getByValue(String value);

    void save(TestTable table);

    List<TestTable> findAll();
}
