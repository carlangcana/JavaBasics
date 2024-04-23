package color_b;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application{

	protected Group root = new Group(); 
	protected static double screenHeight = Screen.getPrimary().getBounds().getHeight();
	protected static double screenWidth = Screen.getPrimary().getBounds().getWidth();
	// Setting the ImageView
	protected ImageView imgView = new ImageView(); // This is a node used for painting images loaded with Image class.
	protected Image img; 
	
	protected final static Image BG_IMAGE = new Image("style/bg.jpeg");
	protected Scene scene = new Scene(root, screenWidth, screenHeight);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		scene.getStylesheets().add(getClass().getResource("/style/application.css").toExternalForm());
		
		imgView.setImage(BG_IMAGE);
		imgView.setFitHeight(screenHeight);
		imgView.setFitWidth(screenWidth);
		imgView.setSmooth(true);
		imgView.setCache(true);
		root.getChildren().add(imgView);

		Text text = new Text(50, 50, "Monochromatic");		
		text.getStyleClass().add("textFill");

		Rectangle red_rect = new Rectangle(50, 50);
		Rectangle yellow_rect = new Rectangle(50, 50);
		//		rectangle.setTranslateX(50);
		//		rectangle.setTranslateY(50);
		red_rect.getStyleClass().addAll("rect", "red");
		yellow_rect.getStyleClass().addAll("rect", "yellow");

		red_rect.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Red is selected!");
			if (red_rect.getStyleClass().contains("rect-selected")) {
				red_rect.getStyleClass().remove("rect-selected");
			} else {
				red_rect.getStyleClass().add("rect-selected");
				yellow_rect.getStyleClass().remove("rect-selected");
			}
		});

		yellow_rect.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Yellow is selected!");
			if (yellow_rect.getStyleClass().contains("rect-selected")) {
				yellow_rect.getStyleClass().remove("rect-selected");
			} else {
				yellow_rect.getStyleClass().add("rect-selected");
				red_rect.getStyleClass().remove("rect-selected");
			}
		});

		Button exit = new Button("Exit");
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				handleButtonClick("clickme");

			}

		});

		root.getChildren().addAll(yellow_rect, red_rect, text);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Test Application");
		primaryStage.show();

	}

	private void handleButtonClick(String btnName) {
		if(btnName.contentEquals("clickme")){
			System.out.println("End of Program! Bye!");
			System.exit(0);
		} else {
			System.out.println("Hello World!");
		}
	}
}
