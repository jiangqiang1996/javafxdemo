package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class TestRadioButton extends Application {

    final ImageView icon = new ImageView();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Radio Button Sample");
        stage.setWidth(250);
        stage.setHeight(150);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Home");//创建一个文字内容为Home的单选按钮
        rb1.setToggleGroup(group);//放入同一个group中的单选按钮不能同时选中
        rb1.setUserData("Home");//设置该单选按钮绑定的值，值可以和显示内容不一样

        RadioButton rb2 = new RadioButton("Calendar");
        rb2.setToggleGroup(group);
        rb2.setUserData("Calendar");

        RadioButton rb3 = new RadioButton("Contacts");
        rb3.setToggleGroup(group);
        rb3.setUserData("Contacts");

        group.selectedToggleProperty().addListener(//单选按钮选择之后触发
            (ObservableValue<? extends Toggle> ov, Toggle old_toggle, 
            Toggle new_toggle) -> {
                if (group.getSelectedToggle() != null) {
                    final Image image = new Image(//根据选择的不同按钮获取对应的值，计算出不同图片路径，用以展示。
                            Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(
                                    group.getSelectedToggle().getUserData().toString() +
                                            ".jpg"
                            ))
                        );
                icon.setImage(image);
            }
        });
        
        HBox hbox = new HBox();
        VBox vbox = new VBox();

        vbox.getChildren().add(rb1);
        vbox.getChildren().add(rb2);
        vbox.getChildren().add(rb3);
        vbox.setSpacing(10);

        hbox.getChildren().add(vbox);
        hbox.getChildren().add(icon);
        hbox.setSpacing(50);
        hbox.setPadding(new Insets(20, 10, 10, 20));

        ((Group) scene.getRoot()).getChildren().add(hbox);
        stage.setScene(scene);
        stage.show(); 
    }
}