module xin.jiangqiang {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports xin.jiangqiang.ui;
    exports xin.jiangqiang.layout;
    exports xin.jiangqiang.css;

    opens xin.jiangqiang.fxml to javafx.fxml;
    exports xin.jiangqiang.fxml;
    exports xin.jiangqiang.event;
    exports xin.jiangqiang.scene;
    exports xin.jiangqiang.property;
    exports xin.jiangqiang.collection;
}
