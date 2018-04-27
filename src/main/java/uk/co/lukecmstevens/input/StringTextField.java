package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;

import com.jfoenix.controls.JFXTextField;

import javafx.scene.Node;

public class StringTextField extends JFXTextField implements FxFormInput<String> {
	
	String label;
	Field f;
	
    @Override
    public String getValue(){
    	return getText();
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

	@Override
	public void setField(Field f) {
		this.f = f;
	}

	@Override
	public Field getField() {
		return f;
	}

}
