package com.example.jpql;

import com.example.jpql.inheritanceMapping.joinedTable.JoinCreditCard;
import com.example.jpql.inheritanceMapping.joinedTable.JoinDebitCard;
import com.example.jpql.inheritanceMapping.joinedTable.TransactionRepo;
import com.example.jpql.inheritanceMapping.singleTable.Check;
import com.example.jpql.inheritanceMapping.singleTable.CreditCard;
import com.example.jpql.inheritanceMapping.singleTable.PaymentRepo;
import com.example.jpql.inheritanceMapping.tablePerClass.BankCheck;
import com.example.jpql.inheritanceMapping.tablePerClass.DebitCard;
import com.example.jpql.inheritanceMapping.tablePerClass.PayRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InheritanceTests {
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    PayRepo payRepo;
    
    @Autowired
    TransactionRepo transactionRepo;


    @Test
    void createCreditCardPayment(){
        CreditCard c1 = new CreditCard();
        c1.setId(1);
        c1.setAmount(15000);
        c1.setCardNumber("1234567890");

        paymentRepo.save(c1);
    }

    @Test
    void createCheckPayment(){
        Check c2 = new Check();
        c2.setId(2);
        c2.setAmount(25000);
        c2.setCheckNumber("0987654321");

        paymentRepo.save(c2);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test
    void createCardPayment(){
        DebitCard d1 = new DebitCard();
        d1.setId(1);
        d1.setAmount(15000);
        d1.setCardNumber("1234567890");

        payRepo.save(d1);
    }

    @Test
    void createBankCheckPayment(){
        BankCheck b2 = new BankCheck();
        b2.setId(2);
        b2.setAmount(25000);
        b2.setCheckNumber("0987654321");

        payRepo.save(b2);
    }
    
    //.................................................
    
    @Test
    void createCreditCardTransaction(){
        JoinCreditCard cc1 = new JoinCreditCard();
        cc1.setId(1);
        cc1.setAmount(23000);
        cc1.setCardNumber("619342");
        transactionRepo.save(cc1);
    }

    @Test
    void createDebitCardTransaction(){
        JoinDebitCard dc1 = new JoinDebitCard();
        dc1.setId(2);
        dc1.setAmount(213132);
        dc1.setCheckNumber("23536689");
    }
}
