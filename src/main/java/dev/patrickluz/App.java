package dev.patrickluz;

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

import java.awt.Color;

import javafx.embed.swing.SwingFXUtils;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Renderer renderer = new Renderer(600, 400);
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

        AnimationTimer timer = new AnimationTimer() {
            int circleX = 0;
            final int circleY = renderer.getFrameHeight() / 2;

            @Override
            public void handle(long now) {
                renderer.clear();
                if (circleX < renderer.getFrameWidth()) {
                    circleX = circleX + 1;
                } else {
                    circleX = 0;
                }

                renderer.drawOval(circleX, circleY, 50, 50, Color.RED);
                WritableImage preview = SwingFXUtils.toFXImage(renderer.getFrame(), null);
                imageView.setImage(preview);
            }
        };


        timer.start();
    }
}
