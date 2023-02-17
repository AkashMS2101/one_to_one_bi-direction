package one_to_one_bi1.controller;

import java.util.Scanner;

import org.hibernate.boot.archive.scan.spi.ScanEnvironment;

import one_to_one_bi1.dao.AadharDAO;
import one_to_one_bi1.dao.PersonDAO;
import one_to_one_bi1.dto.AadharCard;
import one_to_one_bi1.dto.Person;

public class PersonMain {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		//1.to insert data
		Person person = new Person();
		person.setName("Suhas");
		person.setId(2);
		person.setPhone(98452363);
		person.setAddress("hassan");
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setId(1002);
		aadharCard.setName("Suhas M S");
		aadharCard.setAddress("Hassan");
		
		person.setAadharCard(aadharCard);
		aadharCard.setPerson(person);
		PersonDAO dao = new PersonDAO();
		//dao.savePerson(person);
		//2.to update person
		//dao.updatePerson(2, "Suhas M S");
		//3.to get person
		dao.getPersonById(1);
		AadharDAO aadharDAO = new AadharDAO();
		aadharDAO.getAadharById(1001);
	}
}
