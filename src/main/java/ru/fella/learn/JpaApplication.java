package ru.fella.learn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.fella.learn.jpa.TestTable;
import ru.fella.learn.jpa.dao.TestTableDao;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    @Autowired
    TestTableDao repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        TestTable testTable = new TestTable();
        testTable.setValue("Ella");
        repository.save(testTable);

        TestTable testTable2 = new TestTable();
        testTable2.setValue("Denis");
        repository.save(testTable2);
        //Должно быть 2
        System.out.println(repository.findAll().size());
        //Должно быть 1
        System.out.println(repository.getByValue("Ella").getId());
    }
}
