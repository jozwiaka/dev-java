package mypackage.rest;

public class ExceptionStudentNotFound extends RuntimeException {

	public ExceptionStudentNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionStudentNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionStudentNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
