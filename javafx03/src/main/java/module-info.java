module xin.jiangqiang {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

//    opens xin.jiangqiang.ui to javafx.fxml;
    exports xin.jiangqiang.ui;
    exports xin.jiangqiang.layout;
    exports xin.jiangqiang.css;
}
