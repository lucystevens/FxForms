package uk.co.lukecmstevens.providers;

import java.lang.reflect.Field;
import java.time.LocalDate;

import uk.co.lukecmstevens.annotations.FxFormElement;
import uk.co.lukecmstevens.input.DefaultFxFormInput;
import uk.co.lukecmstevens.input.DoubleTextField;
import uk.co.lukecmstevens.input.EnumListView;
import uk.co.lukecmstevens.input.FXFormDatePicker;
import uk.co.lukecmstevens.input.FxFormCheckBox;
import uk.co.lukecmstevens.input.FxFormInput;
import uk.co.lukecmstevens.input.IntegerTextField;
import uk.co.lukecmstevens.input.StringTextField;

public class DefaultInputProvider implements FxFormInputProvider {

	
	@SuppressWarnings("rawtypes")
	@Override
	public <T> Class<? extends FxFormInput> getInputClass(Field f) {
		Class<?> c = f.getType();
		Class<? extends FxFormInput> input = f.getAnnotation(FxFormElement.class).input(); 
		
		if(!input.equals(DefaultFxFormInput.class)) return input;
		else if(c.equals(double.class) || c.equals(Double.class)) return DoubleTextField.class;
		else if(c.equals(int.class) || c.equals(Integer.class)) return IntegerTextField.class;
		else if(c.equals(String.class)) return StringTextField.class;
		else if(c.isEnum()) return EnumListView.class;
		else if(c.equals(boolean.class) || c.equals(Boolean.class)) return FxFormCheckBox.class;
		else if(c.equals(LocalDate.class)) return FXFormDatePicker.class;
		
		else throw new ProviderException(this.getClass(), "No declared input for " + c.getName());
	}

}
