package com.example.jpql.inheritanceMapping.joinedTable;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction,Integer> {
}
