package lk.ijse.dep12.jpa.relationships.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private final static EntityManagerFactory emf = buildEntityManagerFactory();
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("dep-12");
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
