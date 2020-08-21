package customException;

@SuppressWarnings("serial")
public class CurrentDayException extends Exception {

	public CurrentDayException() {
		super();
	}

	@Override
	public String getMessage() {
		return "You can't enter because today is not your peak day and ID";
	}

	
}
