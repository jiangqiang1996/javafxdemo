package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestScrollPane extends Application {

    final ScrollPane scrollPane = new ScrollPane();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    final Label fileName = new Label();
    final String[] imageNames = new String[]{"fw1.jpg", "fw2.jpg", "fw3.jpg", "fw4.jpg", "fw5.jpg"};

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 180, 180);
        stage.setScene(scene);
        stage.setTitle("ScrollPaneSample");
        box.getChildren().addAll(scrollPane, fileName);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        fileName.setLayoutX(30);
        fileName.setLayoutY(160);

        Image roses = new Image(getClass().getResourceAsStream("/roses.jpg"));
        scrollPane.setContent(new ImageView(roses));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);//禁止横向滚动
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);//允许纵向滚动
        for (int i = 0; i < 5; i++) {
            images[i] = new Image(getClass().getResourceAsStream("/" + imageNames[i]));
            pics[i] = new ImageView(images[i]);
            pics[i].setFitWidth(100);
            pics[i].setPreserveRatio(true);
            vb.getChildren().add(pics[i]);
        }

        scrollPane.setVmax(440);
        scrollPane.setPrefSize(115, 150);
        scrollPane.setContent(vb);
        scrollPane.vvalueProperty().addListener((ObservableValue<? extends Number> ov,
                                                 Number old_val, Number new_val) -> {
            fileName.setText(imageNames[(new_val.intValue() - 1) / 100]);
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}