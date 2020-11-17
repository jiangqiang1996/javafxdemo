package xin.jiangqiang;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author jiangqiang
 * @date 2020/11/17 10:15
 */

public class TestLife extends Application {
    public static void main(String[] args) {
        System.out.println("main() = " + Thread.currentThread().getName());
        System.out.println("launch() = " + Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start() = " + Thread.currentThread().getName());
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init()开始执行");
        Thread.sleep(5000);
        super.init();
        System.out.println("init() = " + Thread.currentThread().getName());
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop() = " + Thread.currentThread().getName());
    }

}