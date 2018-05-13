import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KeyEventTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        Duration firingInterval = Duration.millis(500);
        Timeline firing = new Timeline(
                new KeyFrame(Duration.ZERO, event -> fire()),
                new KeyFrame(firingInterval));
        firing.setCycleCount(Animation.INDEFINITE);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F && firing.getStatus() != Animation.Status.RUNNING) {
                firing.playFromStart();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.F) {
                firing.stop();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fire() {
        // dummy implementation:
        System.out.println("Fire!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}