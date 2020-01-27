package es.mfortea.fp2020.user.exceptions;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 584714381080086717L;

	public UserException(String errorMessage) {
		super(errorMessage);
	}
}
