package color_c;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{

	protected Group root = new Group(); 
	protected static double screenHeight = Screen.getPrimary().getBounds().getHeight();
	protected static double screenWidth = Screen.getPrimary().getBounds().getWidth();
	protected Scene scene = new Scene(root, screenWidth, screenHeight);
	

	// Setting the ImageView
	protected ImageView imgView = new ImageView(); // This is a node used for painting images loaded with Image class.
	protected Image img; 

	protected final static Image BG_IMAGE = new Image("style/bg.jpeg");
	protected static StackPane stack = new StackPane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		scene.getStylesheets().add(getClass().getResource("/style/application.css").toExternalForm());
		imgView.setImage(BG_IMAGE);
		imgView.setFitHeight(screenHeight);
		imgView.setFitWidth(screenWidth);
		imgView.setSmooth(true);
		imgView.setCache(true);
		root.getChildren().add(imgView);
		
		Rectangle yellow_rect = new Rectangle(50, 50);
		Rectangle red_rect = new Rectangle(50, 50);
		Rectangle blue_rect = new Rectangle(50, 50);
		Text text = new Text(50, 50, "Monochromatic");		

		red_rect.getStyleClass().addAll("rect", "red");
		yellow_rect.getStyleClass().addAll("rect", "yellow");
		blue_rect.getStyleClass().addAll("rect", "blue");
		
		Rectangle[] other_rects = { red_rect, blue_rect, yellow_rect};
		
		yellow_rect.setOnMouseClicked((MouseEvent event) -> {
			handleRectangleClick(yellow_rect, other_rects); // or red_rect
		});

		red_rect.setOnMouseClicked((MouseEvent event) -> {
			handleRectangleClick(red_rect, other_rects); // or yellow_rect
		});
		
		blue_rect.setOnMouseClicked((MouseEvent event) -> {
			handleRectangleClick(blue_rect, other_rects);
		});

		Button exit = new Button("Exit");
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handleButtonClick("clickme");
			}
		});
//		
//		stack.getChildren().addAll(text);
//		stack.getStyleClass().add("stackBg");

		root.getChildren().addAll(red_rect, yellow_rect, blue_rect, stack);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Test Application");
		primaryStage.show();
	}

//	private void handleRectangleClick(Rectangle currentRect, Rectangle otherRect) {
//		System.out.println(currentRect.getStyleClass().get(1) + " is selected!");
//		if (currentRect.getStyleClass().contains("rect-selected")) {
//			currentRect.getStyleClass().remove("rect-selected");
//		} else {
//			currentRect.getStyleClass().add("rect-selected");
//			otherRect.getStyleClass().remove("rect-selected");
//		}
//	}
//	
	private void handleRectangleClick(Rectangle currentRect, Rectangle[] otherRects) {
		String currentColor = currentRect.getStyleClass().get(1);
		
		System.out.println(currentRect.getStyleClass().get(1) + " is selected!");
		if (currentRect.getStyleClass().contains("rect-selected")) {
			currentRect.getStyleClass().remove("rect-selected");
		} else {
			currentRect.getStyleClass().add("rect-selected");
			for (Rectangle otherRect : otherRects) {
	            String otherColor = otherRect.getStyleClass().get(1);
	            if (!currentColor.equals(otherColor)) {
	                otherRect.getStyleClass().remove("rect-selected");
	            }
	        }
		}
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
