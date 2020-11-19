package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class TestScrollBar extends Application {

    final ScrollBar scrollBar = new ScrollBar();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    DropShadow shadow = new DropShadow();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 180, 180);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
        root.getChildren().addAll(vb, scrollBar);

        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);

        vb.setLayoutX(5);
        vb.setSpacing(10);

        scrollBar.setLayoutX(scene.getWidth() - scrollBar.getWidth());
        scrollBar.setMin(0);
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setPrefHeight(180);
        scrollBar.setMax(360);

        for (int i = 0; i < 5; i++) {
            images[i] = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("fw" + (i + 1) + ".jpg")));
            final ImageView pic = pics[i] = new ImageView(images[i]);
            pic.setEffect(shadow);
            vb.getChildren().add(pics[i]);
        }

        scrollBar.valueProperty().addListener(
                //滚动时触发
                (ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) -> {
                    vb.setLayoutY(-new_val.doubleValue());
                });
        stage.setResizable(false);//不可修改窗口大小
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}