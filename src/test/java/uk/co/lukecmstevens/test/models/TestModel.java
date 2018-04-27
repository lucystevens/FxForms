package uk.co.lukecmstevens.test.models;

import java.lang.annotation.RetentionPolicy;
import java.time.LocalDate;

import uk.co.lukecmstevens.annotations.FxFormElement;
import uk.co.lukecmstevens.annotations.FxFormModel;

@FxFormModel
public class TestModel {
	
	@FxFormElement
	private String string;
	
	@FxFormElement
	private double doub;
	
	@FxFormElement
	private int i;
	
	@FxFormElement
	private LocalDate date;
	
	@FxFormElement
	private boolean bool;
	
	@FxFormElement(label = "Enum")
	private RetentionPolicy retention;
	
	@Override
	public String toString() {
		return String.format("String: %s\nDouble: %.2f\nInt: %d\nDate: %s\nBoolean: %s\nEnum: %s", string, doub, i, date.toString(), String.valueOf(bool), retention.name());
	}

}
