package uk.co.lukecmstevens.validation;

public class NoInputValidation<T> implements FxFormInputValidator<T> {

	@Override
	public void validate(T input) throws ValidationException {}

}
