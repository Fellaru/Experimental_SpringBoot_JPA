package ru.fella.learn.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by efischenko on 19.04.2018.
 */
@NoArgsConstructor
@Data
@Entity
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String value;
}
