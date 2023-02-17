package one_to_one_bi1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_bi1.dto.AadharCard;
import one_to_one_bi1.dto.Person;

public class SavePerson {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Akash");
		person.setId(1);
		person.setPhone(98452363);
		person.setAddress("hassan");
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setId(1001);
		aadharCard.setName("Akash M S");
		aadharCard.setAddress("Hassan");
		
		person.setAadharCard(aadharCard);
		aadharCard.setPerson(person);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(person);
		entityManager.persist(aadharCard);
		
		entityTransaction.commit();
	}
}
