package xin.jiangqiang;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.geometry.HPos.RIGHT;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("登录页面");
        GridPane grid = new GridPane();//网格布局
        grid.setAlignment(Pos.CENTER);//对齐方式
        grid.setHgap(10);//列之间水平间隙的宽度。
        grid.setVgap(10);//行之间水平间隙的宽度。
        grid.setPadding(new Insets(25, 25, 25, 25));//四个方向的内边距，就是文字内容到四个方向边框的距离

        Text scenetitle = new Text("Hi");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));//设置字体，粗细大小
        //后面四个参数分别代表组件的位置放在网格中第几列，第几行开始，占几列，占几行的一个区域。
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("用户名：");//显示文字信息的标签
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();//文本输入框
        grid.add(userTextField, 1, 1);

        Label pw = new Label("密码：");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();//密码输入框
        grid.add(pwBox, 1, 2);

        Button btn = new Button("登录");//按钮
        HBox hbBtn = new HBox(10);//将内部的组件按水平方向依次排列，此处只有一个按钮；VBox表示从上往下排列
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);//对齐方向
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        GridPane.setColumnSpan(actiontarget, 2);//设置网格内组件默认跨几列
        GridPane.setHalignment(actiontarget, RIGHT);//设置网格内组件的水平对齐方式
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                //按钮被点击
                actiontarget.setText("登录失败");
            }
        });
        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}