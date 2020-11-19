package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TestListView extends Application {

    ListView<String> listView = new ListView<>();
    ObservableList<String> data = FXCollections.observableArrayList(
            "chocolate", "salmon", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown");
    final Label label = new Label();

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 200, 200);
        stage.setScene(scene);
        stage.setTitle("ListViewSample");
        box.getChildren().addAll(listView, label);
        VBox.setVgrow(listView, Priority.ALWAYS);

        label.setLayoutX(10);
        label.setLayoutY(115);
        label.setFont(Font.font("Verdana", 20));

        listView.setItems(data);

        //自定义列表单元的实现类
        listView.setCellFactory(stringListView -> new ColorRectCell());

        listView.getSelectionModel().selectedItemProperty().addListener(//选项改变时触发
                (ObservableValue<? extends String> observableValue, String old_val, String new_val) -> {
                    label.setText(new_val);
                    label.setTextFill(Color.web(new_val));
                });
        stage.show();
    }

    static class ColorRectCell extends ListCell<String> {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                rect.setFill(Color.web(item));
                //Cell Factory产生ListCell对象。每个Cell与一个单独的数据项（Data Item）关联，
                // 并且会展示List View中的一行。通过setGraphic方法展现的Cell内容可以是其它的控件，文本、形状或图片。
                // 在本例中，List Cell展现了矩形。
                setGraphic(rect);
            } else {
                setGraphic(null);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
