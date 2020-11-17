package xin.jiangqiang;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class Test1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        var label = new Label("Hello, JavaFX");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();

        stage.setTitle("HelloWorld");
//        stage.getIcons().add(new Image("file:ico/ico.jpg"));
        stage.getIcons().add(new Image("/ico.jpg"));

//        stage.setIconified(true);//设置最小化
//        stage.setMaximized(true);//设置最大化
        stage.setWidth(500);
        stage.setHeight(500);
//        stage.setResizable(false);//不可以拖动窗口调整窗口大小
//        stage.setMaxHeight(800);//可以拖动调整的最大高度
        //获取高度，如果没有设置宽和高，那么这个方法只能在设置显示之后才能获取宽和高。
        System.out.println(stage.getHeight());
//        stage.setFullScreen(true);//设置全屏
        stage.setScene(new Scene(new Group()));
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            /**&
             *
             * @param observable 包括了改变后的状态信息
             * @param oldValue 改变尺寸前的值
             * @param newValue 改变后的值
             */
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("之前的高度" + oldValue + "当前的高度" + newValue);
//                System.out.println(observable);//封装了改变之后的数据信息
                System.out.println(Thread.currentThread().getName());
            }
        });
        stage.show();
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("之前的宽度" + oldValue + "当前的宽度" + newValue);
                System.out.println(Thread.currentThread().getName());

            }
        });
//        stage.close();//关闭
    }

    public static void main(String[] args) {
        launch(args);
    }
}

