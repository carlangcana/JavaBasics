package color_a;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Arc[] colorArcs = new Arc[12];

            // Create color arcs with their respective angles and colors
            String[] colors = {"yellow", "yellowOrange", "orange", "redOrange", "red", "redViolet",
                               "violet", "blueViolet", "blue", "blueGreen", "green", "yellowGreen"};

            for (int i = 0; i < 12; i++) {
                Arc arc = new Arc(300, 300, 200, 200, i * 30, 30);
                arc.setType(ArcType.ROUND);
                arc.getStyleClass().add(colors[i]);
                colorArcs[i] = arc;

                // Add event handler to each arc
                int finalI = i;
                arc.setOnMouseClicked(event -> {
                    String selectedColor = colors[finalI];
                    String colorText = "Selected Color: " + selectedColor;
                    System.out.println(colorText);
                });
            }

            Text title = new Text(50, 50, "Color Wheel");
            title.getStyleClass().add("textTitle");

            Group root = new Group(colorArcs);
            root.getChildren().add(title);

            Scene scene = new Scene(root, 600, 600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Color Wheel");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
