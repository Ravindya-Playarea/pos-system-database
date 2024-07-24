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

public class PosSystemDemo1 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                User kasun = new User("Kasun", "kasun123", "Kasun Sampath");
                User ruwan = new User("Ruwan", "ruwan123", "Ruwan Prabath");
                User nuwan = new User("Nuwan", "nuwan123", "Nuwan Ramindu");

                Item i001 = new Item("I001", "Keyboard", 25, new BigDecimal("1500.00"));
                Item i002 = new Item("I002", "Mouse", 50, new BigDecimal("1250.00"));
                Item i003 = new Item("I003", "Monitor", 10, new BigDecimal("75000.00"));
                Item i004 = new Item("I004", "Headset", 30, new BigDecimal("4000.00"));

                Customer c001 = new Customer("C001", "Tharindu", "Galle");
                Customer c002 = new Customer("C002", "Imantha", "Halawatha");
                Customer c003 = new Customer("C003", "Buddika", "Bandarawela");
                Customer c004 = new Customer("C004", "Waruna", "Matara");
                Customer c005 = new Customer("C005", "Yasiya", "Colombo");


                List.of(kasun,ruwan,nuwan,i001,i002,i003,i004,c001,c002,c003,c004,c005).forEach(em::persist);



                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }
}
