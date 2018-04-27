package uk.co.lukecmstevens.providers;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class DefaultLabelProvider implements FxFormLabelProvider {

	@Override
	public Node getLabel(String text) {
		return new Label(text);
	}

}
