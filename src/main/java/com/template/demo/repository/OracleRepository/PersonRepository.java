package com.template.demo.repository.OracleRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.demo.model.OracleModel.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findTop1ById(Integer id);

    Person findTop1ByName(String name);
}
