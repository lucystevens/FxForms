package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;

import com.jfoenix.controls.JFXCheckBox;

import javafx.scene.Node;

public class FxFormCheckBox extends JFXCheckBox implements FxFormInput<Boolean> {
	
	String label;
	Field f;

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public Boolean getValue() {
		return isSelected();
	}

	@Override
	public Node getNode() {
		return this;
	}

	@Override
	public void setField(Field f) {
		this.f = f;
	}

	@Override
	public Field getField() {
		return f;
	}

}
