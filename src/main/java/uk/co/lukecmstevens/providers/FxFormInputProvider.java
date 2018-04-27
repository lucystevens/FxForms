package uk.co.lukecmstevens.providers;

import java.lang.reflect.Field;

import uk.co.lukecmstevens.input.FxFormInput;

public interface FxFormInputProvider {
	
	@SuppressWarnings("rawtypes")
	public <T> Class<? extends FxFormInput> getInputClass(Field f);

}
