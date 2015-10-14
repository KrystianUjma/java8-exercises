package example4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Veezq on 2015-10-11.
 */
public class EffectivelyFinal {

    public static void main(String[] args) {


        new EffectivelyFinal().thisExample();
//        repeatMessage("foo", 1);
        badExampleMutability();


    }

    public void thisExample(){
        Runnable runner = () -> { System.out.println(this.toString()); };
        new Thread(runner).start();
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }

//    public static void repeatMessage2(String text, int count) {
//        Runnable r = () -> {
//            while (count > 0) {
//                count--; // Error: Can’t mutate captured variable
//                System.out.println(text);
//                Thread.yield();
//            }
//        };
//        new Thread(r).start();
//    }

    public static void badExampleMutability() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);


        System.out.println("before"+list.toString());
        Runnable r = () -> {
            list.add(0);
        };
        Thread t1 = new Thread(r);
                t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("after"+list.toString());


    }


}

