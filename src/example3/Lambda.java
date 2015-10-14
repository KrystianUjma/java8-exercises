package example3;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

/**
 * Created by Veezq on 2015-10-10.
 */
public class Lambda {

    public static void main(String[] args) {
        Comparator<String> stringComparator = (String x, String y) -> x.length() - y.length();

        Comparatorr<String> stringComparato2r = (String x, String y) -> x.length() - y.length();

        ToDoubleBiFunction<String, String> stringComparator1 = (String x, String y) -> x.length() - y.length();

List list;


        List<String> strings = Arrays.asList("jeden","dwa","trzy");

        Stream<Button> buttonStream = strings.stream()
                .map(new Function<String, Button>() {
                    @Override
                    public Button apply(String label) {
                        System.out.println("label is " + label);
                        return new Button(label);
                    }
                });

//        buttonStream.toArray(Button[]::new);
//
//        buttonStream.toArray((value) -> new Button[value]);


        Button[] buttons = buttonStream.toArray(Button[]::new );

        System.out.println(buttons.length);
        System.out.println(buttons[0].getLabel());

    }


    @FunctionalInterface
    public interface Comparatorr<T> {

        int compare(T o1, T o2);

    }

}
