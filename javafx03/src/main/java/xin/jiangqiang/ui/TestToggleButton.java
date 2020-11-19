package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TestToggleButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Toggle Button Sample");
        stage.setWidth(250);
        stage.setHeight(180);

        Rectangle rect = new Rectangle();//矩形框
        rect.setHeight(50);//高度
        rect.setFill(Color.WHITE);//内部填充颜色
        rect.setStroke(Color.DARKGRAY);//边框颜色
        rect.setStrokeWidth(2);//边框宽度
        rect.setArcHeight(10);//边角变圆
        rect.setArcWidth(10);//边角变圆

        final ToggleGroup group = new ToggleGroup();

        //点击开关按钮时触发,每次点击都会触发
        group.selectedToggleProperty().addListener(
                //oldToggle之前被选中的,newToggle之后被选中的
                (observableValue, oldToggle, newToggle) -> {
                    if (newToggle == null) {
                        rect.setFill(Color.WHITE);
                    } else {
                        rect.setFill((Color) group.getSelectedToggle().getUserData());
                    }
                });

        ToggleButton tb1 = new ToggleButton("Minor");
        tb1.setToggleGroup(group);
        tb1.setUserData(Color.LIGHTGREEN);
        tb1.setSelected(true);
        tb1.getStyleClass().add("toggle-button1");

        ToggleButton tb2 = new ToggleButton("Major");
        tb2.setToggleGroup(group);
        tb2.setUserData(Color.LIGHTBLUE);
        tb2.getStyleClass().add("toggle-button2");

        ToggleButton tb3 = new ToggleButton("Critical");
        tb3.setToggleGroup(group);
        tb3.setUserData(Color.SALMON);
        tb3.getStyleClass().add("toggle-button3");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(tb1, tb2, tb3);
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Priority:"));
        vbox.getChildren().add(hbox);
        vbox.getChildren().add(rect);
        vbox.setPadding(new Insets(20, 10, 10, 20));

        Scene scene = new Scene(new Group(vbox));
        stage.setScene(scene);
        scene.getStylesheets().add("/ToggleButton.css");
        stage.show();
        rect.setWidth(hbox.getWidth());
    }
}
