package uk.co.lukecmstevens.forms;

public class ModelException extends RuntimeException {

	private static final long serialVersionUID = 6626617977219964871L;
	
	public ModelException(Class<?> model, String message){
		super(message + " for model class " + model.getName());
	}

}
