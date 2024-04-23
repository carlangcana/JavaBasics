package new_window_demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewWindow extends Application{
	
	private String message;

	public NewWindow(String message) {
        this.message = message;
    }

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Text txt = new Text(50, 50, message);
		StackPane root = new StackPane(txt);
		Scene scene = new Scene(root, 400, 400);
		
//		System.out.println("Value from the first window: " + message);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("2nd Window");
		primaryStage.show();
	}


}
