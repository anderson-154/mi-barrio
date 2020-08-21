package customException;

@SuppressWarnings("serial")
public class RepeatPersonException extends Exception {

	private String repeatedId;
	
	public RepeatPersonException(String repeatedId) {
		super();
		this.repeatedId=repeatedId;
	}
	
	@Override
	public String getMessage() {
		return "Person with id: " + repeatedId + ", is already registered in list";
	}

	public String getRepeatedId() {
		return repeatedId;
	}
	
}
