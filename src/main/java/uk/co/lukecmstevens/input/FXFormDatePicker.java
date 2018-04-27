package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;
import java.time.LocalDate;

import com.jfoenix.controls.JFXDatePicker;

import javafx.scene.Node;

public class FXFormDatePicker implements FxFormInput<LocalDate> {
	
	String label;
	Field f;
	JFXDatePicker picker;
	
	public FXFormDatePicker() {
		picker = new JFXDatePicker();
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public Node getNode() {
		return picker;
	}

	@Override
	public void setField(Field f) {
		this.f = f;
	}

	@Override
	public Field getField() {
		return f;
	}

	@Override
	public LocalDate getValue() {
		return picker.getValue();
	}
}
