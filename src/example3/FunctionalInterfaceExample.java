package example3;



/**
 * Created by Veezq on 2015-10-10.
 */
public class FunctionalInterfaceExample {

    public static void main(String[] args) {


        new Thread(uncheck(() ->{
            System.out.println("sleeping ...");
            Thread.sleep(2000);
            System.out.println("hello");
        })).start();



    }


    public static Runnable uncheck(RunnableEx runnableEx){
        return () -> {
            try{
                runnableEx.run();
            }catch(Exception e){

            }
        };
    }

    @FunctionalInterface
    public interface RunnableEx {

        void run() throws Exception;

    }

}
