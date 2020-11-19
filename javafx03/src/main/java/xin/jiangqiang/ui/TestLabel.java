package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author jiangqiang
 * @date 2020/11/19 9:27
 */
public class TestLabel extends Application {
    Label label3 = new Label("A label that needs to be wrapped");

    @Override
    public void start(Stage stage) {
        stage.setTitle("Label Sample");
        stage.setWidth(420);
        stage.setHeight(180);

        Image image = new Image(getClass().getResourceAsStream("/labels.jpg"));

        Label label1 = new Label("Search");//参数为文字内容
        label1.setGraphic(new ImageView(image));//显示图片
        label1.setFont(new Font("Arial", 30));//设置字体
        label1.setTextFill(Color.web("#0076a3"));//文字颜色
        label1.setTextAlignment(TextAlignment.JUSTIFY);//对齐方向

        Label label2 = new Label("Values");
        label2.setFont(Font.font("Cambria", 32));
        label2.setRotate(270);//顺时针旋转270度
        label2.setTranslateY(50);//Y轴移动

        label3.setWrapText(true);//启用文本折叠换行
        label3.setTranslateY(50);
        label3.setPrefWidth(100);

        label3.setOnMouseEntered((MouseEvent e) -> {//鼠标移入事件
            label3.setScaleX(1.5);//X方向缩放倍数
            label3.setScaleY(1.5);//Y方向缩放倍数
        });

        label3.setOnMouseExited((MouseEvent e) -> {//鼠标移出事件
            label3.setScaleX(1);
            label3.setScaleY(1);
        });

        HBox hbox = new HBox();
        hbox.setSpacing(10);//内部组件之间的距离
        hbox.getChildren().add((label1));
        hbox.getChildren().add(label2);
        hbox.getChildren().add(label3);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
