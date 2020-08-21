package customException;

@SuppressWarnings("serial")
public class NotGiveAccessException extends Exception{

	private String type;

	public NotGiveAccessException(String type) {
		super();
		this.type = type;
	}
	
	@Override
	public String getMessage() {
		return "Person with type: " + type + ", can't enter";
	}

	public String getType() {
		return type;
	}

	
}
