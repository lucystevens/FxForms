package uk.co.lukecmstevens.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import uk.co.lukecmstevens.input.DefaultFxFormInput;
import uk.co.lukecmstevens.input.FxFormInput;
import uk.co.lukecmstevens.validation.FxFormInputValidator;
import uk.co.lukecmstevens.validation.NoInputValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
@SuppressWarnings("rawtypes")
public @interface FxFormElement {
	
	public static final String DEFAULT_LABEL = "g78dTea6PfAW7dYNX$99";

	public String label() default DEFAULT_LABEL;
	
	public Class<? extends FxFormInput> input() default DefaultFxFormInput.class;
	
	public Class<? extends FxFormInputValidator> validator() default NoInputValidation.class;
}
