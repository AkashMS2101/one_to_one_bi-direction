package one_to_one_bi1.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import one_to_one_bi1.dto.AadharCard;

public class AadharDAO {
	public EntityManager getEntitymanager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}
	public void saveAadhar(AadharCard aadhar) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(aadhar);
		entityTransaction.commit();
	}
	public void updateAadhar(int id,String name) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard aadhar = entityManager.find(AadharCard.class, id);
		aadhar.setName(name);
		entityTransaction.begin();
		entityManager.merge(aadhar);
		entityTransaction.commit();
	}
	public void deleteAadhar(int id) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		AadharCard aadharCard = entityManager.find(AadharCard.class, id);
		entityTransaction.begin();
		entityManager.remove(aadharCard);
		entityTransaction.commit();
	}
	public void getAadharById(int id) {
		EntityManager entityManager = getEntitymanager();
		AadharCard aadharCard = entityManager.find(AadharCard.class, id);
		System.out.println(aadharCard);
	}
	public void getAllAadharcard() {
		EntityManager entityManager = getEntitymanager();
		javax.persistence.Query query=entityManager.createQuery("select p from AadharCard p");
		java.util.List<AadharCard> list = query.getResultList();
		System.out.println(list);
	}
}
