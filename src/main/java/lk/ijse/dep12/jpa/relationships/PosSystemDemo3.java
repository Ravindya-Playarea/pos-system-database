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

public class PosSystemDemo3 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();


                Item i001 = em.find(Item.class,"I001");
                Item i002 = em.find(Item.class,"I002");
                Item i003 = em.find(Item.class,"I003");
                Item i004 = em.find(Item.class,"I004");


                Order od001 = em.find(Order.class,"OD001");
                Order od002 = em.find(Order.class,"OD002");
                Order od003 = em.find(Order.class,"OD003");
                Order od005 = em.find(Order.class,"OD005");

                OrderItem orderItem1 = new OrderItem(od001, i003, 10, new BigDecimal("67500.00"));
                OrderItem orderItem2 = new OrderItem(od001, i002, 5, new BigDecimal("1187.50"));
                OrderItem orderItem3 = new OrderItem(od002, i004, 3, new BigDecimal("3880.00"));
                OrderItem orderItem4 = new OrderItem(od003, i004, 3, new BigDecimal("3880.00"));
                OrderItem orderItem5 = new OrderItem(od003, i001, 5, new BigDecimal("1425.00"));
                OrderItem orderItem6 = new OrderItem(od005, i004, 3, new BigDecimal("3880.00"));
                OrderItem orderItem7 = new OrderItem(od005, i003, 10, new BigDecimal("67500.00"));
                OrderItem orderItem8 = new OrderItem(od005, i002, 5, new BigDecimal("1187.50"));

                List.of(orderItem1,orderItem2,orderItem3, orderItem4,orderItem5,orderItem6,orderItem7,orderItem8).forEach(em::persist);



                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }
}
