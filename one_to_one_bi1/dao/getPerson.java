package one_to_one_bi1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_bi1.dto.AadharCard;
import one_to_one_bi1.dto.Person;

public class getPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = entityManager.find(Person.class, 1);
		System.out.println(person);
		
		AadharCard aadharCard = entityManager.find(AadharCard.class, 1001);
		System.out.println(aadharCard);
		}
}
