package bar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Veezq on 2015-10-07.
 */
public class LazyExample {

    public static boolean isGreaterThan3(int number){
        System.out.println("isGreaterThan3 " +number);
        return number > 3;
    }

    public static boolean isEven(int number){
        System.out.println("isEven " +number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number){
        System.out.println("doubleIt " +number);
        return number * 2;
    }

    public static void main(String[] args) {
        //find the double of the first even number greater than 3
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        //Higher-order functions, lazy evalution
        //lazy + composition
        //for loop - eager
        //filter - lazy

        //for : 10 + 7 + 4 = 21
        // lazy for free


        System.out.println(values.stream()
                                .filter(LazyExample::isGreaterThan3)
                                .filter(LazyExample::isEven)
                                .map(LazyExample::doubleIt)
                                .findFirst()
                                .get());

        // intermidiate operations - filter, map
        // terminal operations - findFirst, reduce, collect


        // lazy, no terminal operation
        // compiler can make
        // mutability - compiler leaves it poorly optimized
        // with streams it can make more optimizations
        Stream<Integer> temp = values.stream()
                .filter(LazyExample::isGreaterThan3)
                .filter(LazyExample::isEven)
                .map(LazyExample::doubleIt);
    }

}
