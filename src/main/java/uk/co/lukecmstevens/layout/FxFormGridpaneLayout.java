package uk.co.lukecmstevens.layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import uk.co.lukecmstevens.input.FxFormInput;
import uk.co.lukecmstevens.providers.FxFormLabelProvider;

public class FxFormGridpaneLayout extends GridPane implements FxFormLayout {
	
	FxFormLabelProvider labelProvider;
	int row=0;
	
	public FxFormGridpaneLayout() {
		this.setAlignment(Pos.TOP_CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25));
	}
	
	@Override
	public void setLabelProvider(FxFormLabelProvider labelProvider){
		this.labelProvider = labelProvider;
	}
	
	@Override
	public void addInputElement(FxFormInput<?> input){
		Node label = labelProvider.getLabel(input.getLabel());
		addRow(row++, label, input.getNode());
	}
	
	@Override
	public Node getNode(){
		return this;
	}

}
