package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;

import javafx.scene.Node;

public interface FxFormInput<T> {
	
	public String getLabel();
	
	public void setLabel(String label);
	
	public T getValue();
	
	public Node getNode();
	
	public void setField(Field f);
	
	public Field getField();

}
