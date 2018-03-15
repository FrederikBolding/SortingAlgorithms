import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class AlgorithmVisualization extends Application {

    private static final int APP_W = 800;
    private static final int APP_H = 600;
    private ImageView view;
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();

        this.stage = stage;

        Thread thread = new Thread(() -> {
            new Main().Run(this);
        });

        thread.start();
    }

    public void SetTitle(String title) {
        Platform.runLater(() -> {
            stage.setTitle(title);
        });
    }

    private Parent createContent() {
        HBox root = new HBox(25);
        root.setAlignment(Pos.CENTER);
        view = new ImageView();
        root.getChildren().addAll(view);
        root.setMinHeight(APP_H);
        root.setMinWidth(APP_W);
        return root;
    }

    public void Visualize(int[] numbers) {
        WritableImage image = new WritableImage(APP_W, APP_H);
        PixelWriter writer = image.getPixelWriter();
        int width = APP_W / numbers.length;
        int height = APP_H / Arrays.stream(numbers).max().getAsInt();
        for (int x = 0; x < APP_W; x++) {
            int numberIndex = (int) (Math.floor((x) / width));
            int h = height * numbers[numberIndex];
            int lastW = 0;
            //int lastH = 0;
            if (numberIndex > 0) {
                lastW = width * (numberIndex);
                //lastH = height * numbers[numberIndex-1];
            }
            int w = width * (numberIndex + 1);
            for (int y = 0; y < APP_H; y++) {
                if (y < h && x > lastW && x < w) {
                    writer.setColor(x, APP_H - 1 - y, Color.BLACK);
                } else {
                    break;
                }
            }
        }
        Platform.runLater(() -> {
            view.setImage(image);
        });
    }
}
