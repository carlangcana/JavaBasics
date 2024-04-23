package app;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStage{
    
	private Text text = new Text("Ball Practice");
    private Scene scene;
    private Stage stage;
    private Group root;
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;
    private GameTimer gametimer;
    private Circle circle;
    private String imagePath = "img/red.png"; // Example file path
    private Image image = new Image(imagePath);
    
    public GameStage() {
        this.circle = new Circle(30, 30, 30);
        // Set the image as a texture pattern to fill the circle
//        ImagePattern imagePattern = new ImagePattern(image);
//        this.circle.setFill(imagePattern);
        
        this.circle.setFill(Color.YELLOW);
        
        this.root = new Group(circle);
        this.root.getChildren().add(text);
        this.text.setX(50);
        this.text.setY(50);
        this.scene = new Scene(root, this.WINDOW_HEIGHT, this.WINDOW_WIDTH);
        this.gametimer = new GameTimer("Test", this.scene, this.root, this.circle);
    }
    
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.setTitle("Ball");
        this.stage.setScene(this.scene);
        this.gametimer.start();
        this.stage.show();
        this.stage.setResizable(false);

    }
    
}
