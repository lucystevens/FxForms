package uk.co.lukecmstevens.input;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

abstract class RegexLimitedTextField<T> extends JFXTextField implements FxFormInput<T> {
	
	Pattern regex;
	String label;
	Field f;
	
	public RegexLimitedTextField(String regex) {
		this.regex = Pattern.compile(regex);
		this.textProperty().addListener(this::listener);
	}
	
    private void listener(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if (!regex.matcher(newValue).matches()) {
            this.setText(oldValue);
        }
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
	public abstract T getValue();

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
