package foo;

import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

/**
 * Created by Veezq on 2015-10-05.
 */
public class Currying {

    public static void main(String[] args) {
        DoubleUnaryOperator operator = convert(1.8, 32);
        System.out.println(operator.applyAsDouble(10));
    }

    public static DoubleUnaryOperator convert(double factor, double base){
        return new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double amount) {
                return amount * factor + base;
            }
        };
    }


    public void currying() {
        // Create a function that adds 2 integers
        BiFunction<Integer,Integer,Integer> adder = ( a, b ) -> a + b ;

        // And a function that takes an integer and returns a function
//        Function<Integer,Function<Integer,Integer>> currier = a -> b -> adder.apply(a, b ) ;
        Function<Integer,Function<Integer,Integer>> currier = new Function<Integer, Function<Integer, Integer>>() {
            @Override
            public Function<Integer, Integer> apply(Integer a) {
                return b -> adder.apply(a, b);
            }
        };

        // Call apply 4 to currier (to get a function back)
        Function<Integer,Integer> curried = currier.apply( 4 ) ;

        // Results
        System.out.printf( "Curry : %d\n", curried.apply( 3 ) ) ; // ( 4 + 3 )
    }

}
