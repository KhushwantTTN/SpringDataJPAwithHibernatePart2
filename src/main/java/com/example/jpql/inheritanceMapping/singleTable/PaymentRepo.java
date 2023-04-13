package com.example.jpql.inheritanceMapping.singleTable;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment,Integer> {
}
