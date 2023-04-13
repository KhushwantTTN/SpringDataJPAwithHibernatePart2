package com.example.jpql.inheritanceMapping.tablePerClass;

import org.springframework.data.repository.CrudRepository;

public interface PayRepo extends CrudRepository<Pay,Integer> {
}
