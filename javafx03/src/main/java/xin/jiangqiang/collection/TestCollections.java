package xin.jiangqiang.collection;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangqiang
 * @date 2020/11/24 17:10
 */
public class TestCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("d");
        list.add("b");
        list.add("a");
        list.add("c");

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
                while (change.next()) {
                    System.out.println("Was added? " + change.wasAdded());
                    System.out.println("Was removed? " + change.wasRemoved());
                    System.out.println("Was replaced? " + change.wasReplaced());
                    System.out.println("Was permutated? " + change.wasPermutated());//顺序变化
                }
            }
        });
        FXCollections.sort(observableList);
    }
}