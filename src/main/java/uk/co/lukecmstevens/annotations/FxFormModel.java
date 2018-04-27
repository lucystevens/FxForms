package uk.co.lukecmstevens.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import uk.co.lukecmstevens.layout.FxFormGridpaneLayout;
import uk.co.lukecmstevens.layout.FxFormLayout;
import uk.co.lukecmstevens.providers.DefaultInputProvider;
import uk.co.lukecmstevens.providers.DefaultLabelProvider;
import uk.co.lukecmstevens.providers.FxFormInputProvider;
import uk.co.lukecmstevens.providers.FxFormLabelProvider;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface FxFormModel {
	
	public Class<? extends FxFormLayout> layout() default FxFormGridpaneLayout.class;
	
	public Class<? extends FxFormInputProvider> inputProvider() default DefaultInputProvider.class;
	
	public Class<? extends FxFormLabelProvider> labelProvider() default DefaultLabelProvider.class;

}
