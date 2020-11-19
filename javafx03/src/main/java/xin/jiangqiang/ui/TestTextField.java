package xin.jiangqiang.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestTextField extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 300, 150);
        stage.setScene(scene);
        stage.setTitle("Text Field Sample");
        //创建GridPane容器
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        scene.setRoot(grid);

        //定义Name Text Field
        final TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);

        //定义Last Name Text Field
        final TextField lastName = new TextField();
        lastName.setPromptText("Enter your last name.");
        GridPane.setConstraints(lastName, 0, 1);
        grid.getChildren().add(lastName);

        //定义Comment Text Field
        final TextField comment = new TextField();
        comment.setPromptText("Enter your comment.");
        GridPane.setConstraints(comment, 0, 2);
        grid.getChildren().add(comment);

        //定义Submit Button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);

        //定义Reset Button
        Button clear = new Button("Reset");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        submit.setOnAction((ActionEvent e) -> {
            if ((comment.getText() != null && !comment.getText().isEmpty())) {
                label.setText(name.getText() + " " +
                        lastName.getText() + ", "
                        + "thank you for your comment!");
            } else {
                label.setText("You have not left a comment.");
            }
        });

        clear.setOnAction((ActionEvent e) -> {
            name.clear();
            lastName.clear();
            comment.clear();
            label.setText(null);
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
