package application.models;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Stage mainStage = null;
	
	public static BorderPane dynamicScene;
	
	public static void changeScene(String FXMLLink) {
	    Main.dynamicScene.setCenter(null);
	    try {
	        AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource(FXMLLink));
	        Main.dynamicScene.setCenter(root);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/views/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/views/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			mainStage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		Database db = Database.getDatabase();		
	}
}


