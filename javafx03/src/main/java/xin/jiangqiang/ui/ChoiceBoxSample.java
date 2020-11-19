package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChoiceBoxSample extends Application {

    Rectangle rect = new Rectangle(150, 30);
    final Label label = new Label("Hello");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.setFill(Color.ALICEBLUE);
        stage.setScene(scene);
        stage.show();

        stage.setTitle("ChoiceBox Sample");
        stage.setWidth(300);
        stage.setHeight(200);

        label.setFont(Font.font("Arial", 25));
        label.setLayoutX(40);

        final String[] greetings = new String[]{"Hello", "Hola", "Привет", "你好",
                "こんにちは"};
        final ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(
                "English", "Español", "Русский", "简体中文", "日本語")
        );

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(//选择的内容变化时触发
                (ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) -> {
                    label.setText(greetings[new_val.intValue()]);
                });

        choiceBox.setTooltip(new Tooltip("Select the language"));//鼠标移动到下拉框上会显示该提示
        choiceBox.setValue("English");//设置初始值
        HBox hb = new HBox();
        hb.getChildren().addAll(choiceBox, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene.getRoot()).getChildren().add(hb);
    }
}
