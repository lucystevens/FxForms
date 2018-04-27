package uk.co.lukecmstevens.providers;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class DefaultLabelProvider implements FxFormLabelProvider {

	@Override
	public Node getLabel(String text) {
		Label label = new Label(text);
		label.setFont(Font.font("Roboto", 24));
		return label;
	}

}
