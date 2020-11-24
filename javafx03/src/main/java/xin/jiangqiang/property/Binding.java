package xin.jiangqiang.property;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.NumberBinding;

/**
 * @author jiangqiang
 * @date 2020/11/24 16:30
 */
public class Binding {
    //    public static void main(String[] args) {
//        IntegerProperty num1 = new SimpleIntegerProperty(1);
//        IntegerProperty num2 = new SimpleIntegerProperty(2);
////        NumberBinding sum = num1.add(num2);
////        System.out.println(sum.getValue());
////        num1.set(2);
////        System.out.println(sum.getValue());
//
////        NumberBinding sum = Bindings.add(num1, num2);
////        System.out.println(sum.getValue());
////        num1.setValue(2);
////        System.err.println(sum.getValue());
//
//
//        IntegerProperty num3 = new SimpleIntegerProperty(3);
//        IntegerProperty num4 = new SimpleIntegerProperty(4);
//        //multiply乘法
//        NumberBinding total = Bindings.add(num1.multiply(num2), num3.multiply(num4));
//        System.out.println(total.getValue());
//        num1.setValue(2);
//        System.err.println(total.getValue());
//    }
    public static void main(String[] args) {
        final DoubleProperty a = new SimpleDoubleProperty(1);
        final DoubleProperty b = new SimpleDoubleProperty(2);
        final DoubleProperty c = new SimpleDoubleProperty(3);
        final DoubleProperty d = new SimpleDoubleProperty(4);

        DoubleBinding db = new DoubleBinding() {
            {
                super.bind(a, b, c, d);
            }

            @Override
            protected double computeValue() {
                return (a.get() * b.get()) + (c.get() * d.get());
            }
        };

        System.out.println(db.get());
        b.set(3);
        System.out.println(db.get());
    }
}
