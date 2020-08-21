package ui;

import java.time.LocalDate;
import java.util.Scanner;

import customException.CurrentDayException;
import customException.NotGiveAccessException;
import customException.RepeatPersonException;
import model.StoreControl;

public class Main {
	
	public static void main(String[] args) throws NotGiveAccessException, CurrentDayException {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("welcome to Store MI BARRIO");
		
		int option;
		do {
			System.out.println("Menu");
			System.out.println("1. Join to store");
			System.out.println("2. Exit to program");
			
			option = Integer.parseInt(sc.nextLine());
			
			
			String id;
			String type;
			int day=LocalDate.now().getDayOfMonth();
			int totalAccess=0;
			
			StoreControl storeControl = new StoreControl();
			
			switch(option) {
			
				case 1:
					System.out.print("Please enter your id: ");
					id = sc.nextLine();
					totalAccess++;
					
					System.out.print("Please enter your type id: ");
					System.out.println("TI :to tarjeta identidad");
					System.out.println("CC :to cedula de ciudadania");
					System.out.println("PP :to pasaporte");
					System.out.println("CE :to cedula extranjera");
					
					type = sc.nextLine();
					try {
						storeControl.addPerson(id, type);
						storeControl.joinToStore(id,type,day);
					}catch(RepeatPersonException r) {
						System.out.println("It was no possible to join store "+id);
						System.out.println(r.getMessage());
					}catch(CurrentDayException c) {
						System.out.println("It was no possible to join store ");
						System.out.println(c.getMessage());
					}catch(NotGiveAccessException n) {
						System.out.println("It was no possible to join store");
						System.out.println(n.getMessage());
					}
				break;
			}
		}while(option!=2);
	}

}
