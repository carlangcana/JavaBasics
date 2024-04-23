package app;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class GameTimer extends AnimationTimer {

	private Text message;
	private Scene scene;
	private Group root;
	private Circle circle;
	private double sceneWidth;
	private double sceneHeight;
	private long now;

	public GameTimer(String msg, Scene scene, Group root, Circle circle) {
		this.scene = scene;
		this.circle = circle;
		this.root = root;

		// Set scene dimensions
		this.sceneWidth = scene.getWidth();
		this.sceneHeight = scene.getHeight();

		this.handleKeyPressEvent();

	}

	public void handleKeyPressEvent() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent e) {
				KeyCode code = e.getCode();
				move(code);			
			}

		});
	}

	public void move(KeyCode code) {
		double circleX = this.circle.getTranslateX();
		double circleY = this.circle.getTranslateY();
		double circleRadius = this.circle.getRadius();
		double moveAmount = 10.0; 

		double newX = circleX;
		double newY = circleY;

		switch (code) {
		case UP:
			newY = Math.max(circleY - moveAmount, 0); 
			break;
		case DOWN:
			newY = Math.min(circleY + moveAmount, sceneHeight - (circleRadius * 2)); 
			break;
		case LEFT:
			newX = Math.max(circleX - moveAmount, 0);
			break;
		case RIGHT:
			newX = Math.min(circleX + moveAmount, sceneWidth - (circleRadius * 2)); 
			break;
		default:
			return; 
		}

		this.circle.setTranslateX(newX);
		this.circle.setTranslateY(newY);
	}

	public void start() {
		System.out.println("Start Game");
	}

	@Override
	public void handle(long now) {
		
	}

}
