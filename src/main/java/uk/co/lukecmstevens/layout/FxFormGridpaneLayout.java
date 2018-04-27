package uk.co.lukecmstevens.layout;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import uk.co.lukecmstevens.input.FxFormInput;
import uk.co.lukecmstevens.providers.FxFormLabelProvider;

public class FxFormGridpaneLayout extends GridPane implements FxFormLayout {
	
	FxFormLabelProvider labelProvider;
	List<FxFormInput<?>> elements = new ArrayList<>();
	int row = 0;
	
	public FxFormGridpaneLayout() {
		this.setAlignment(Pos.TOP_CENTER);
		this.setHgap(25);
		this.setVgap(25);
		this.setPadding(new Insets(50));
	}
	
	@Override
	public void setLabelProvider(FxFormLabelProvider labelProvider){
		this.labelProvider = labelProvider;
	}
	
	@Override
	public void addInputElement(FxFormInput<?> input){
		FxFormPosition position = input.getField().getAnnotation(FxFormPosition.class);
		
		// If no position, add to list to populate later
		if(position == null) elements.add(input);
		
		// Otherwise add at specified position
		else{
			Node label = labelProvider.getLabel(input.getLabel());
			int col = position.column() * 2;
			int row = position.row();
			this.row = Math.max(this.row, row);
			
			add(label, col, row);
			add(input.getNode(), col + 1, row);
		}

	}
	
	void addInputElement(int row, FxFormInput<?> input){

	}
	
	@Override
	public Node getNode(){
		for(FxFormInput<?> input : elements){
			Node label = labelProvider.getLabel(input.getLabel());
			addRow(++row, label, input.getNode());
		}
		elements.clear();
		
		return this;
	}

}
