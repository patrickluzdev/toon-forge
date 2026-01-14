package dev.patrickluz;

import dev.patrickluz.character.Character;
import dev.patrickluz.core.Renderer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Renderer renderer = new Renderer(920, 920);
        WritableImage preview = SwingFXUtils.toFXImage(renderer.getFrame(), null);
        ImageView imageView = new ImageView(preview);

        var screens = Screen.getScreens();
        Screen targetScreen = screens.size() > 1 ? screens.get(1) : screens.get(0);
        Rectangle2D bounds = targetScreen.getVisualBounds();

        int windowWidth = renderer.getFrameWidth();
        int padding = 30;
        stage.setX(bounds.getMaxX() - windowWidth - padding);
        stage.setY(bounds.getMinY() + padding);

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, renderer.getFrameWidth(), renderer.getFrameHeight());
        stage.setScene(scene);
        stage.show();
        Character character = new Character(100, 100);
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                renderer.clear();
                character.draw(renderer.getG2d());
                WritableImage preview = SwingFXUtils.toFXImage(renderer.getFrame(), null);
                imageView.setImage(preview);
            }
        };


        timer.start();
    }
}
