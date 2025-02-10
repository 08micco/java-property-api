package com.mikkel.property;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class PropertyRepository {

    public void addProperty(Property property) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(property);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Property getPropertyById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Property property = entityManager.find(Property.class, id);
        entityManager.close();
        return property;
    }

    public List<Property> getAllProperties() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Property> properties = entityManager.createQuery("SELECT p from Property p", Property.class).getResultList();
        entityManager.close();
        return properties;

    }

    public void updateProperty(Long id, Property newPropertyData) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
    
        try {
            transaction.begin();
            Property existingProperty = entityManager.find(Property.class, id);
            if (existingProperty != null) {
                existingProperty.setAddress(newPropertyData.getAddress());
                existingProperty.setOwner(newPropertyData.getOwner());
                existingProperty.setPropertyAssessment(newPropertyData.getPropertyAssessment());
    
                entityManager.merge(existingProperty); // Update existing property
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    

    public void removeProperty(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Property property = entityManager.find(Property.class, id);
            if (property != null) {
                entityManager.remove(property);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
}
