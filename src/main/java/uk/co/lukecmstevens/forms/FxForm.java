package uk.co.lukecmstevens.forms;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import uk.co.lukecmstevens.annotations.FxFormElement;
import uk.co.lukecmstevens.annotations.FxFormModel;
import uk.co.lukecmstevens.input.FxFormInput;
import uk.co.lukecmstevens.layout.FxFormLayout;
import uk.co.lukecmstevens.providers.FxFormInputProvider;
import uk.co.lukecmstevens.providers.FxFormLabelProvider;
import uk.co.lukecmstevens.tools.ReflectionTools;

public class FxForm<T> extends VBox{
	
	FxFormModel annotation;
	Class<T> model;
	T obj;
	ReflectionTools tools = new ReflectionTools();
	
	FxFormLayout layout;
	FxFormInputProvider inputProvider;
	List<FxFormInput<?>> inputs;
	
	Consumer<T> callback;
	
	public FxForm(Class<T> model){
		this.model = model;
		this.obj = createModel();
		init();
	}
	
	@SuppressWarnings("unchecked")
	public FxForm(T obj){
		this.model = (Class<T>) obj.getClass();
		this.obj = obj;
		init();
	}
	
	void init(){
		this.annotation = model.getAnnotation(FxFormModel.class);
		
		this.layout = createLayout();
		layout.setLabelProvider(createLabelProvider());
		
		this.inputProvider = createInputProvider();
		this.inputs = createInputs();
		
		for(FxFormInput<?> input : inputs){
			layout.addInputElement(input);
		}
		getChildren().add(layout.getNode());
		
		JFXButton submit = new JFXButton("Submit");
		submit.setButtonType(ButtonType.RAISED);
		submit.setStyle("-fx-background-color:#6c0da8;-fx-font-size:24px;-fx-text-fill:WHITE");
		submit.setOnAction(this::onSubmit);
		getChildren().add(submit);
	}
	
	T createModel(){
		try {
			return tools.newInstance(model);
		} catch (Exception e) {
			throw new ModelException(model, "Failed to create model. Root Cause: " + e.getMessage());
		}		
	}
	
	FxFormLayout createLayout(){
		Class<?> c = annotation.layout();
		try {
			return (FxFormLayout) tools.newInstance(c);
		} catch (Exception e) {
			throw new ModelException(model, "Failed to create layout" + c.getName() + ". Root Cause: " + e.getMessage());
		}	
	}
	
	FxFormInputProvider createInputProvider(){
		Class<?> c = annotation.inputProvider();
		try {
			return (FxFormInputProvider) tools.newInstance(c);
		} catch (Exception e) {
			throw new ModelException(model, "Failed to create input provider " + c.getName() + ". Root Cause: " + e.getMessage());
		}
	}
	
	FxFormLabelProvider createLabelProvider(){
		Class<?> c = annotation.labelProvider();
		try {
			return (FxFormLabelProvider) tools.newInstance(c);
		} catch (Exception e) {
			throw new ModelException(model, "Failed to create label provider " + c.getName() + ". Root Cause: " + e.getMessage());
		}
	}
	
	List<FxFormInput<?>> createInputs(){
		List<FxFormInput<?>> inputs = new ArrayList<>();
		for(Field f : model.getDeclaredFields()){
			if(f.getAnnotation(FxFormElement.class) != null) inputs.add(createInput(f));
		}
		
		return inputs;
	}
	
	@SuppressWarnings("rawtypes")
	FxFormInput<?> createInput(Field f){
		Class<? extends FxFormInput> c = inputProvider.getInputClass(f);
		try {
			FxFormInput<?> input = (FxFormInput<?>) tools.newInstance(c);
			input.setField(f);
			input.setLabel(getLabelName(f));
			return input;
		} catch (Exception e) {
			throw new ModelException(model, "Failed to create input " + c.getName() + ". Root Cause: " + e.getMessage());
		}
	}
	
	String getLabelName(Field f){
		String fieldName = f.getName();
		String annoName = f.getAnnotation(FxFormElement.class).label();
		
		if(annoName.equals(FxFormElement.DEFAULT_LABEL)){
			annoName = fieldName.replaceAll("(?=[A-Z][a-z])", " ");
			annoName = annoName.substring(0, 1).toUpperCase() + annoName.substring(1);
		}
		
		return annoName;
	}
	
	void onSubmit(ActionEvent ae){
		inputs.forEach(this::setInputValue);
		callback.accept(obj);
	}
	
	void setInputValue(FxFormInput<?> input){
		Field f = input.getField();
		try {
			f.setAccessible(true);
			f.set(obj, input.getValue());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ModelException(model, "Failed to set field " + f.getName() + ". Root Cause: " + e.getMessage());
		}
	}
	
	public void setOnComplete(Consumer<T> callback){
		this.callback = callback;
	}

}
