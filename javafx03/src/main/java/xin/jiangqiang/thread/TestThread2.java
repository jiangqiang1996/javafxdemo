package xin.jiangqiang.thread;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 传递参数
 *
 * @author jiangqiang
 * @date 2020/11/24 17:34
 */
public class TestThread2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);
        Button button = new Button("按钮");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task<Object> task = new MyTask(1000);
                Thread th = new Thread(task);
                th.setDaemon(true);
                //启动线程
                th.start();
                System.out.println("新创建的线程: " + th.getName());
            }
        });
        HBox hBox = new HBox(button);
        hBox.setPadding(new Insets(15, 12, 15, 12));//节点到边缘的距离
        hBox.setSpacing(10);   //节点之间的间距
        hBox.setStyle("-fx-background-color: #336699;");//背景颜色
        hBox.setPrefWidth(400);
        hBox.setPrefHeight(200);
        hBox.setAlignment(Pos.CENTER);
        group.getChildren().add(hBox);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MyTask extends Task<Object> {
    private final Integer time;

    public MyTask(Integer time) {
        this.time = time;
    }

    @Override
    protected Void call() throws Exception {
        Thread.sleep(time);
        System.out.println(Thread.currentThread().getName());
        return null;
    }
}