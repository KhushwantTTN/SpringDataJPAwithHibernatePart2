package com.example.jpql;

import com.example.jpql.componentMapping.Salary;
import com.example.jpql.componentMapping.CompEmployee;
import com.example.jpql.componentMapping.CompRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentMappingTest {

    @Autowired
    CompRepo compRepo;

    @Test
    void createCompEmploye(){
        Salary a1 = new Salary();
        a1.setBasicsalary(15000);
        a1.setBonussalary(5000);
        a1.setTaxAmount(500);
        a1.setSpecialAllowanceSalary(2000);

        CompEmployee ce1 = new CompEmployee();
        ce1.setId(1);
        ce1.setFirstname("Khushwant");
        ce1.setLastname("Prajapati");
        ce1.setAge(23);
        ce1.setSalary(a1);

        compRepo.save(ce1);

    }
}
