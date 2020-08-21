package model;

import java.util.ArrayList;

import customException.CurrentDayException;
import customException.NotGiveAccessException;
import customException.RepeatPersonException;

public class StoreControl {

	private int cont;
	private ArrayList<Person> people;
	
	public StoreControl() {
		super();
		people = new ArrayList<Person>();
	}

	public int getCont() {
		return cont;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
	
	public void addPerson(String id, String type) throws RepeatPersonException{
		for(int i=0;i<people.size();i++ ) {
			Person current = people.get(i);
			if(current.getId().equals(id)) {
				throw new RepeatPersonException(id);
			}else {
				Person newPerson = new Person(id,type);
				people.add(newPerson);
			}
		}
	}
	
	public Person searchPerson(String id) {
		Person seached=null;
		for(int i=0;i<people.size() && seached==null;i++ ) {
			Person current = people.get(i);
			if(current.getId().equals(id)) {
				seached=people.get(i);
			}
		}
		return seached;
	}
	public void joinToStore(String id, String type, int currentDay)throws NotGiveAccessException, CurrentDayException{
		Person current=searchPerson(id);
		int penultimo=Integer.parseInt(current.getId().charAt(current.getId().length()-2)+"");
		
		if(penultimo%2!=0 && currentDay%2==0) {
			throw new CurrentDayException();
		}else if(penultimo%2==0 && currentDay%2!=0) {
			throw new CurrentDayException();
		}else if(type=="TI") {
			throw new NotGiveAccessException(type);
		}
	}
}