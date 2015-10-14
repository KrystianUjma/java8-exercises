package bar;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Veezq on 2015-10-07.
 */
public class FindDoubleOfEvenNumber {

    public static boolean isGreaterThan3(int number){
        return number > 3;
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        //find the double of the first even number greater than 3
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = 0;

        for(int e : values){
            if(e > 3 && e % 2 ==0){
                result = e * 2;
                break;
            }
        }

        System.out.println(result);

        // kind of iterator
        // Optional - we could find nothing
        System.out.println(values.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .get());


        // static methods
// method reference
        System.out.println(values.stream()
//                .filter(FindDoubleOfEvenNumber::isGreaterThan3)
                .filter(e -> isGreaterThan3(e))
                .filter(e -> isGreaterThan3(e * 2)) // method reference can't be used
                .filter(FindDoubleOfEvenNumber::isEven)
                .map(e -> e * 2)
                .findFirst()
                .get());
    }


}
