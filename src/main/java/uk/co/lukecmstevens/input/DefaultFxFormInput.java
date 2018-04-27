package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;

import javafx.scene.Node;

public class DefaultFxFormInput<T> implements FxFormInput<T> {

	private DefaultFxFormInput() {}
	
	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public T getValue() {
		return null;
	}

	@Override
	public Node getNode() {
		return null;
	}

	@Override
	public void setLabel(String label) {}

	@Override
	public void setField(Field f) {}

	@Override
	public Field getField() {
		return null;
	}

}
