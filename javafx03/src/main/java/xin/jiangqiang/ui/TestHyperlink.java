package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class TestHyperlink extends Application {

    final static String[] imageFiles = new String[]{
            "product.png",
            "education.png",
            "partners.png",
            "support.png"
    };
    final static String[] captions = new String[]{
            "Products",
            "Education",
            "Partners",
            "Support"
    };
    final ImageView selectedImage = new ImageView();
    final Hyperlink[] hpls = new Hyperlink[captions.length];
    final Image[] images = new Image[imageFiles.length];

    public static void main(String[] args) {
        launch(TestHyperlink.class, args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Hyperlink Sample");
        stage.setWidth(300);
        stage.setHeight(200);

        selectedImage.setLayoutX(100);
        selectedImage.setLayoutY(10);

        for (int i = 0; i < captions.length; i++) {
            final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
            final Image image = images[i] = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imageFiles[i])));
            hpl.setOnAction((ActionEvent e) -> {//链接点击之后触发
                selectedImage.setImage(image);
            });
        }

        final Button button = new Button("Refresh links");
        button.setOnAction((ActionEvent e) -> {
            for (int i = 0; i < captions.length; i++) {
                hpls[i].setVisited(false);
                selectedImage.setImage(null);
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hpls);
        vbox.getChildren().add(button);
        vbox.setSpacing(5);

        ((Group) scene.getRoot()).getChildren().addAll(vbox, selectedImage);
        stage.setScene(scene);
        stage.show();
    }
}