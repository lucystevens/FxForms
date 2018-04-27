package uk.co.lukecmstevens.validation;

public interface FxFormInputValidator<T> {
	
	public void validate(T input) throws ValidationException;

}
