package new_window_demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	private int count;
	// Setting the ImageView
	protected ImageView imgView = new ImageView(); // This is a node used for painting images loaded with Image class.
//	protected Image img; 
	protected final static Image BG_IMAGE = new Image("/img/bg.jpeg");

	@Override
	public void start(Stage primaryStage) throws Exception {

		Text title = new Text(50, 50, "Hit the count!");
		title.setTranslateY(-100);

		Text count_text = new Text(50, 50, String.valueOf(count));
		count_text.setTranslateY(-50);

		Button btn = new Button("Count!");
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				count++;
				count_text.setText(String.valueOf(count));
				System.out.println("Clicked!");
			}
		});

		Button nav = new Button("Move!");
		nav.setTranslateX(50);
		btn.setTranslateX(-50);

		nav.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				NewWindow newWindow = new NewWindow("Hey buddy!");
				try {
					newWindow.start(new Stage());
					primaryStage.close();
//					or primaryStage.hide();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		imgView.setImage(BG_IMAGE);
		imgView.setFitHeight(400);
		imgView.setFitWidth(400);
		imgView.setSmooth(true);
		imgView.setCache(true);

		StackPane root = new StackPane(imgView, btn, nav, title, count_text);

		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main Window");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
