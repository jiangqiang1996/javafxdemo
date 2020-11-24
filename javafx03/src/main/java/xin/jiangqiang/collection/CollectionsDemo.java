package xin.jiangqiang.collection;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javafx.collections.*;

/**
 * @author jiangqiang
 * @date 2020/11/24 16:52
 */
public class CollectionsDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });
        observableList.add("item one");
        list.add("item two");
        System.out.println("Size: " + observableList.size());
//      下面是map
        Map<String, String> map = new HashMap<String, String>();

        ObservableMap<String, String> observableMap = FXCollections.observableMap(map);
        observableMap.addListener(new MapChangeListener() {
            @Override
            public void onChanged(MapChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });

        observableMap.put("key 1", "value 1");
        System.out.println("Size: " + observableMap.size());

        map.put("key 2", "value 2");
        System.out.println("Size: " + observableMap.size());
    }
}
