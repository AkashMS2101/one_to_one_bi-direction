package one_to_one_bi1.controller;

import java.util.Scanner;

import one_to_one_bi1.dao.PersonDAO;
import one_to_one_bi1.dto.AadharCard;
import one_to_one_bi1.dto.Person;

public class PersonMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person  person = new  Person();
		AadharCard aadharCard = new AadharCard();
		PersonDAO dao= new PersonDAO();
		boolean exit=true;
		do {
			System.out.println("Enter the choice");
			System.out.println("1.to insert \n2.to update name");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("enter id");
				int id=scanner.nextInt();
				System.out.println("enter name");
				String name = scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();
				System.out.println("enter phone number");
				long phone = scanner.nextLong();
				person.setAddress(address);
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				System.out.println("enter aadhar card details");
				System.out.println("enter id");
				int aid=scanner.nextInt();
				System.out.println("enter name");
				String a_name = scanner.next();
				System.out.println("enter the address");
				String a_address=scanner.next();
				aadharCard.setAddress(a_address);
				aadharCard.setId(aid);
				aadharCard.setName(a_name);
				
				aadharCard.setPerson(person);
				person.setAadharCard(aadharCard);
				
				dao.savePerson(person);
				
				break;
			}
			case 2:{
				System.out.println("enter id");
				int id=scanner.nextInt();
				System.out.println("enter new name");
				String name = scanner.next();
				dao.updatePerson(id, name);
				
				break;
			}
			
			
			
			
			}
		}while(exit);
	}
}
