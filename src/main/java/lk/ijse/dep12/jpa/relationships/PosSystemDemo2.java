package lk.ijse.dep12.jpa.relationships;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationships.entity.*;
import lk.ijse.dep12.jpa.relationships.util.JpaUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class PosSystemDemo2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                User kasun = em.find(User.class,"Kasun");
                User ruwan = em.find(User.class,"Ruwan");
                User nuwan = em.find(User.class,"Nuwan");

                Customer c001 = em.find(Customer.class,"C001");
                Customer c002 = em.find(Customer.class,"C002");
                Customer c003 = em.find(Customer.class,"C003");
                Customer c004 = em.find(Customer.class,"C004");
                Customer c005 = em.find(Customer.class,"C005");

                Contact c001_1 = new Contact("1",c001, "077-1234567");
                Contact c001_2 = new Contact("2",c001, "078-1234567");
                Contact c002_1 = new Contact("3",c002, "088-1234567");
                Contact c002_2 = new Contact("4",c002, "098-1234567");
                Contact c003_1 = new Contact("5",c003, "099-1234567");
                Contact c004_1 = new Contact("6",c004, "055-1234567");
                Contact c004_2 = new Contact("7",c004, "022-1234567");
                Contact c004_3 = new Contact("8",c004, "044-1234567");

//                Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), kasun, c005);
//                Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()), kasun, c005);
//                Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()), ruwan, c003);
//                Order od004 = new Order("OD004", Date.valueOf(LocalDate.now()), nuwan, c001);
//                Order od005 = new Order("OD005", Date.valueOf(LocalDate.now()), nuwan, c004);


//                List.of(od001,od002,od003,od004,od005).forEach(em::persist);
                List.of(c001_1,c001_2,c002_1,c002_2,c003_1,c004_1,c004_2,c004_3).forEach(em::persist);



                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }
}
