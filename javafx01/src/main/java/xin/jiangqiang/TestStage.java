package xin.jiangqiang;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestStage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("HelloWorld");
        stage.getIcons().add(new Image("ico/ico.jpg"));
        stage.show();
        Stage stage1 = new Stage();
        stage1.show();
        Stage stage2 = new Stage();
        stage2.show();
        Stage stage3 = new Stage();
        stage3.initModality(Modality.APPLICATION_MODAL);//禁止点击同一个应用的其他窗口
        stage3.show();
//        Platform.exit();//关闭所有窗口
    }

    public static void main(String[] args) {
        launch(args);
    }
}

