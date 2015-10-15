package example1;

import java.util.stream.IntStream;

/**
 * Created by Veezq on 2015-10-07.
 */
public class PrimeGenerator {
    public static void main(String[] args) {
//        System.out.println(isPrime(1));
//        System.out.println(isPrime(2));
//        System.out.println(isPrime(3));
        System.out.println(isPrime(7));
    }

    private static boolean isPrime(final int number) {
        //imparative - saying how
        //muttability
        //skupiamy sie na zmiennych, muttability prowadzi do bledow
//        for (int i = 2; i < number; i++){
//            if(number % i == 0) return false;
//        }
//
//        return number >1;

        //declarative - what
        return number > 1 && IntStream.range(2, number)
                                      .noneMatch(index -> number % index == 0);
    }


    /*
    - focus on implementation, not what to do but how
    - imperative vs declarative
    - for is static, streams can be made parrarel very easy
     */
}
