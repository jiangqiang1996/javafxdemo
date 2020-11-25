package xin.jiangqiang.thread;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author jiangqiang
 * @date 2020/11/25 15:21
 */
public class ProgressSample3 extends Application {

    final Service<Integer> service = new ProgressService<Integer>();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.setTitle("下载文件进度条同步更新");

        Label label = new Label("下载进度：");
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0);
        progressBar.setPrefWidth(200);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPrefHeight(60);
        hBox.getChildren().addAll(label, progressBar);

        Button button = new Button("开始下载");
        button.setOnMouseClicked((e) -> {
            progressBar.progressProperty().bind(service.progressProperty());
            //JavaFX Application Thread
            service.restart();
        });

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox, button);
        scene.setRoot(vBox);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class ProgressService<Integer> extends Service<Integer> {
    @Override
    protected Task<Integer> createTask() {
        //JavaFX Application Thread
        return new ProgressTask<Integer>();
    }
}

class ProgressTask<Integer> extends Task<Integer> {
    @Override
    protected Integer call() throws Exception {
        System.out.println("新创建的线程: " + Thread.currentThread().getName());
        int i = 0;
        while (i++ < 100) {
            updateProgress(i, 100);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        return null;
    }
}