package one_to_one_bi1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_bi1.dto.Person;

public class PersonDAO {
	public EntityManager getEntitymanager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}
	public void savePerson(Person person) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	public void updatePerson(int id,String name) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		person.setName(name);
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}
	public void deletePerson(int id) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
	}
	public void getPersonById(int id) {
		EntityManager entityManager = getEntitymanager();
		Person person = entityManager.find(Person.class, id);
		System.out.println(person);
	}
	public void getAllPerson() {
		EntityManager entityManager = getEntitymanager();
		Query query=entityManager.createQuery("select p from person p");
		java.util.List<Person> list = query.getResultList();
		System.out.println(list);
	}
}
