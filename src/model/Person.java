package model;

public class Person {

	public static final String TI="tarjeta identidad";
	public static final String CC="cedula de ciudadania";
	public static final String PP="pasaporte";
	public static final String CE="ceula de extranjeria";
	
	private String id;
	private String type;
	
	public Person(String id, String type) {
		super();
		this.id=id;
		this.type=type;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public void addPerson() {
		
	}
	
	
}
