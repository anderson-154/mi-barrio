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
		StoreControl storeControl = new StoreControl();

		String id;
		String type;
		int day=LocalDate.now().getDayOfMonth();
		int totalAccess=0;
		
		int option;
		do {
			System.out.println("Menu");
			System.out.println("1. Join to store");
			System.out.println("2. Exit to program");
			System.out.println("");
			System.out.println("Total access to store: "+totalAccess);
			
			option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
			
				case 1:
					System.out.print("Please enter your id: ");
					id = sc.nextLine();
					totalAccess++;
					
					System.out.println("Please enter your type id:");
					System.out.println("");
					System.out.println("TI :to tarjeta identidad");
					System.out.println("CC :to cedula de ciudadania");
					System.out.println("PP :to pasaporte");
					System.out.println("CE :to cedula extranjera");
					
					type = sc.nextLine();
					try {
						storeControl.joinToStore(id, type, day);
						storeControl.addPerson(id, type);
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
	sc.close();
	}
}
