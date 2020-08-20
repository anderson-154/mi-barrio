package model;

import java.util.ArrayList;

public class StoreControl {

	private int cont;
	private ArrayList<Person> people;
	
	public StoreControl() {
		super();
	}

	public int getCont() {
		return cont;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
	
	public void addPerson(String id, String type) throws Exception{
		for(int i=0;i<people.size();i++ ) {
			Person current = people.get(i);
			if(current.getId().equals(id) || current.getType().equals(type)) {
				throw new Exception();
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
	public void joinToStore(String id, String type, int currentDay){
		Person current=searchPerson(id);
		
	}
}