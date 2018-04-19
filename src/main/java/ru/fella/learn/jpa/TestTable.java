package ru.fella.learn.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by efischenko on 19.04.2018.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TestTable {
    @Id
    @GeneratedValue
    private Integer id;
    private String value;
}
