package com.frederikbolding;

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
        Image image = makeMockImage();
        byte[] imageData = imageToData(image);

        byte[] modifiedImageData = modify(imageData);
        Image modifiedImage = dataToImage(modifiedImageData);

        HBox root = new HBox(25);
        root.setAlignment(Pos.CENTER);
        view = new ImageView(modifiedImage);
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

    private Image makeMockImage() {
        WritableImage image = new WritableImage(APP_W, APP_H);
        PixelWriter writer = image.getPixelWriter();

        for (int y = 0; y < APP_H; y++) {
            for (int x = 0; x < APP_W; x++) {
                writer.setColor(x, y, Color.WHITE);
            }
        }

        writer.setColor(399, 599, Color.BLACK);

        return image;
    }

    /**
     * Modifies the pixel data.
     *
     * @param data original image data
     * @return modified image data
     */
    private byte[] modify(byte[] data) {
        // this is where changes happen
        return data;
    }

    private byte[] imageToData(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        byte[] data = new byte[width * height * 4];

        int i = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = image.getPixelReader().getArgb(x, y);

                byte[] pixelData = ByteBuffer.allocate(4).putInt(argb).array();

                data[i++] = pixelData[0];
                data[i++] = pixelData[1];
                data[i++] = pixelData[2];
                data[i++] = pixelData[3];
            }
        }

        return data;
    }

    private Image dataToImage(byte[] data) {
        // if we don't know the image size beforehand we can encode width and height
        // into image data too
        WritableImage image = new WritableImage(APP_W / 2, APP_H);
        PixelWriter writer = image.getPixelWriter();

        int i = 0;
        for (int y = 0; y < APP_H; y++) {
            for (int x = 0; x < APP_W / 2; x++) {
                int argb = ByteBuffer.wrap(Arrays.copyOfRange(data, i, i + 4)).getInt();

                writer.setArgb(x, y, argb);

                i += 4;
            }
        }

        return image;
    }

}
