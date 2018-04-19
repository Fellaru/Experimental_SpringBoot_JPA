package ru.fella.learn.jpa;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by efischenko on 19.04.2018.
 */
public interface TestTableRepository extends CrudRepository<TestTable, Integer>, TestTableRepositoryCustom {
}
