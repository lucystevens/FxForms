package uk.co.lukecmstevens.validation;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -6541690200975513134L;
	
	private String message;
	
	public ValidationException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
