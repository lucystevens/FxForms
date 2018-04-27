package uk.co.lukecmstevens.layout;

import javafx.scene.Node;
import uk.co.lukecmstevens.input.FxFormInput;
import uk.co.lukecmstevens.providers.FxFormLabelProvider;

public interface FxFormLayout {
	
	public void setLabelProvider(FxFormLabelProvider labelProvider);
	
	public void addInputElement(FxFormInput<?> input);
	
	public Node getNode();

}
