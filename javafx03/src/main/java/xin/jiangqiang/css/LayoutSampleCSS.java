package xin.jiangqiang.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jiangqiang
 * @date 2020/11/23 15:30
 */
public class LayoutSampleCSS extends Application {

    public static void main(String[] args) {
        launch(LayoutSampleCSS.class, args);
    }

    @Override
    public void start(Stage stage) {

        // 边框面板，作为最顶层布局
        BorderPane border = new BorderPane();

        HBox hbox = addHBox();
        border.setTop(hbox);//顶部放置一个水平盒子
        border.setLeft(addVBox());//左侧放置垂直盒子

        //添加一个堆栈面板到上方区域的水平盒子中，这个堆栈面板用来实现帮助图标
        addStackPane(hbox);

        border.setRight(addFlowPane());
//        border.setRight(addTilePane());

        //注意设置的顺序，在界面大小不够显示时，后设置的UI组件会遮住先设置的。
//        border.setCenter(addGridPane());
        border.setCenter(addAnchorPane(addGridPane()));

        Scene scene = new Scene(border);
        scene.getStylesheets().add(getClass().getResource("/css/layoutstyles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Layout Sample");
        stage.show();
    }

    /*
     * 顶部创建一个带两个按钮的水平盒子
     */
    private HBox addHBox() {

        HBox hbox = new HBox();
//        hbox.setPadding(new Insets(15, 12, 15, 12));//节点到边缘的距离
//        hbox.setSpacing(10);   //节点之间的间距
//        hbox.setStyle("-fx-background-color: #336699;");//背景颜色
        //使用css代替
        hbox.getStyleClass().add("hbox");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);

        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

    /*
     * 左侧创建一个垂直盒子，盒子内部是超链接列表
     */
    private VBox addVBox() {

        VBox vbox = new VBox();
//        vbox.setPadding(new Insets(10)); //内边距，节点到边缘的距离
//        vbox.setSpacing(8);//节点间距
        // 使用css代替
        vbox.getStyleClass().addAll("pane", "vbox");

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink[] options = {
                new Hyperlink("Sales"),
                new Hyperlink("Marketing"),
                new Hyperlink("Distribution"),
                new Hyperlink("Costs")};

        for (int i = 0; i < 4; i++) {
            //为每个节点设置外边距
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }

        return vbox;
    }

    /**
     * 用堆栈面板创建一个帮助图标，并将其添加到水平盒子的右侧
     *
     * @param hb
     */
    private void addStackPane(HBox hb) {

        StackPane stack = new StackPane();//创建堆栈面板
        Rectangle helpIcon = new Rectangle(30.0, 25.0);//创建一个矩形
        helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#4977A3")),
                new Stop(0.5, Color.web("#B0C6DA")),
                new Stop(1, Color.web("#9CB6CF"))));//设置矩形内的渐变颜色
        helpIcon.setStroke(Color.web("#D0E6FA"));//矩形边框线条颜色
        helpIcon.setArcHeight(3.5);//让矩形的角变圆
        helpIcon.setArcWidth(3.5);//让矩形的角变圆

        Text helpText = new Text("?");//创建一个文本
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(helpIcon, helpText);//文本会重叠在矩形上
        stack.setAlignment(Pos.CENTER_RIGHT);//靠右对齐，内部的矩形（帮助图标）会右对齐
        //设置问号居中显示
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));

        hb.getChildren().add(stack);// 将堆栈面板添加到水平盒子中
        HBox.setHgrow(stack, Priority.ALWAYS);// 将HBox水平多余的所有空间都给StackPane，这样前面设置的右对齐就能保证问号按钮在最右边
    }

    /*
     * 中间区域创建一个四列三行的网格布局
     */
    private GridPane addGridPane() {

        GridPane grid = new GridPane();
//        grid.setHgap(10);//列间隔
//        grid.setVgap(10);//行间隔
//        grid.setPadding(new Insets(0, 10, 0, 10));//节点到表格边框的距离
        //使用css代替
        grid.getStyleClass().add("grid");

        // 将category节点放在第1行,第2列
        Text category = new Text("Sales:");
        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(category, 1, 0);

        // 将chartTitle节点放在第1行,第3列
        Text chartTitle = new Text("Current Year");
        chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(chartTitle, 2, 0);

        // 将chartSubtitle节点放在第2行,占第2和第3列
        Text chartSubtitle = new Text("Goods and Services");
        grid.add(chartSubtitle, 1, 1, 2, 1);

        // 将House图标放在第1列，占第1和第2行
        ImageView imageHouse = new ImageView(
                new Image(LayoutSampleCSS.class.getResourceAsStream("/graphics/house.png")));
        grid.add(imageHouse, 0, 0, 1, 2);

        // 将左边的标签goodsPercent放在第3行，第1列，靠下对齐
        Text goodsPercent = new Text("Goods\n80%");
        GridPane.setValignment(goodsPercent, VPos.BOTTOM);
        grid.add(goodsPercent, 0, 2);

        // 将饼图放在第3行，占第2和第3列
        ImageView imageChart = new ImageView(
                new Image(LayoutSampleCSS.class.getResourceAsStream("/graphics/piechart.png")));
        grid.add(imageChart, 1, 2, 2, 1);

        // 将右边的标签servicesPercent放在第3行，第4列，靠上对齐
        Text servicesPercent = new Text("Services\n20%");
        GridPane.setValignment(servicesPercent, VPos.TOP);
        grid.add(servicesPercent, 3, 2);

//        grid.setGridLinesVisible(true);//显示网格线
        return grid;
    }

    /**
     * 创建一个流动布局，四行总共八个图标
     */
    private FlowPane addFlowPane() {

        FlowPane flow = new FlowPane();
//        flow.setPadding(new Insets(5, 0, 5, 0));//内部组件到面板边框的距离
//        flow.setVgap(4);//行间距 垂直间距
//        flow.setHgap(4);//列间距 水平间距
//        flow.setStyle("-fx-background-color: DAE6F3;");
        //使用css代替
        flow.getStyleClass().addAll("pane", "flow-tile");

        flow.setPrefWrapLength(170); // 预设FlowPane的宽度，使其能够显示两列

        ImageView[] pages = new ImageView[8];
        for (int i = 0; i < 8; i++) {
            pages[i] = new ImageView(
                    new Image(LayoutSampleCSS.class.getResourceAsStream("/graphics/chart_" + (i + 1) + ".png")));
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }

    /**
     * 创建磁贴面板布局，总共四行八个图标。
     */
    private TilePane addTilePane() {

        TilePane tile = new TilePane();
//        tile.setPadding(new Insets(5, 0, 5, 0));
//        tile.setVgap(4);
//        tile.setHgap(4);
//        tile.setStyle("-fx-background-color: DAE6F3;");
        //使用css代替
        tile.getStyleClass().addAll("pane", "flow-tile");

        tile.setPrefColumns(2);

        ImageView[] pages = new ImageView[8];
        for (int i = 0; i < 8; i++) {
            pages[i] = new ImageView(
                    new Image(LayoutSampleCSS.class.getResourceAsStream("/graphics/chart_" + (i + 1) + ".png")));
            tile.getChildren().add(pages[i]);
        }

        return tile;
    }

    /**
     * 使用网格面板和带按钮的水平盒子创建锚面板
     */
    private AnchorPane addAnchorPane(GridPane grid) {

        AnchorPane anchorpane = new AnchorPane();
        anchorpane.getStyleClass().add("pane");

        //创建按钮
        Button buttonSave = new Button("Save");
        buttonSave.setId("button-custom");

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setId("button-custom");

        HBox hb = new HBox();
//        hb.setPadding(new Insets(0, 10, 10, 10));
//        hb.setSpacing(10);
        //使用css代替
        hb.getStyleClass().add("hbox");
        hb.setId("hbox-custom");

        //按钮放在水平盒子内
        hb.getChildren().addAll(buttonSave, buttonCancel);

        //网格面板和水平盒子放在锚面板内
        anchorpane.getChildren().addAll(grid, hb);

        //将按钮定位到右下角，将网格定位到顶部
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
}