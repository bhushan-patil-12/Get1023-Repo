package exception;

public class AgeException extends RuntimeException{		// unchecked
	public AgeException(String message) {
		super(message);
	}
}
