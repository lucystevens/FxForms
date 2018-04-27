package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;

import com.jfoenix.controls.JFXListView;

import javafx.scene.Node;
import uk.co.lukecmstevens.tools.ReflectionTools;

public class EnumListView<T> extends JFXListView<T> implements FxFormInput<T>{
	
	String label;
	Field f;

	@Override
	public T getValue() {
		return getSelectionModel().getSelectedItem();
	}

	@Override
	public Node getNode() {
		return this;
	}

	@Override
	public String getLabel() {
		return label;
	}
	
	@Override
	public void setLabel(String label){
		this.label = label;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setField(Field f) {
		this.f = f;
		
		Class<T> c = (Class<T>) f.getType();
		ReflectionTools tools = new ReflectionTools();
		for(T value : tools.getEnumValues(c)){
			getItems().add(value);
		}
	}

	@Override
	public Field getField() {
		return f;
	}

}
