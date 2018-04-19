package ru.fella.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.fella.learn.jpa.TestTable;
import ru.fella.learn.jpa.TestTableRepository;

import java.util.Optional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	@Autowired
	TestTableRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new TestTable(1, "Hello"));
		Optional<TestTable> testTable = repository.findById(1);
		System.out.println("Вывод");
		System.out.println(testTable.get().getValue());
	}
}
