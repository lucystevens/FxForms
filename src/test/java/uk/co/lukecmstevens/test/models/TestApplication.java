package uk.co.lukecmstevens.test.models;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.co.lukecmstevens.forms.FxForm;

public class TestApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		FxForm<TestModel> form = new FxForm<>(TestModel.class);
		form.setOnComplete(System.out::println);
		form.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(form, 1000, 1000);
		stage.setScene(scene);
		stage.setTitle("Test FxForms");
		stage.show();
	}

}
