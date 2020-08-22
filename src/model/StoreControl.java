package model;

import java.util.ArrayList;


import customException.CurrentDayException;
import customException.NotGiveAccessException;
import customException.RepeatPersonException;

public class StoreControl {

	private ArrayList<Person> people;
	
	public StoreControl() {
		super();
		people = new ArrayList<Person>();
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
	
	public void addPerson(String id, String type) throws RepeatPersonException{
		for(int i=0;i<people.size();i++ ) {
			String currentId = people.get(i).getId();
			if(currentId.equals(id)) {
				throw new RepeatPersonException(id);
			}
		}		
			Person newPerson = new Person(id,type);
			people.add(newPerson);
	}
	
	public void joinToStore(String id, String type, int currentDay)throws NotGiveAccessException, CurrentDayException{
		int penultimo=Integer.parseInt(id.charAt(id.length()-2)+"");
		
		if(penultimo%2!=0 && currentDay%2==0) {
			throw new CurrentDayException();
		}else if(penultimo%2==0 && currentDay%2!=0) {
			throw new CurrentDayException();
		}else if(type.equals("TI")) {
			throw new NotGiveAccessException(type);
		}
	}
}