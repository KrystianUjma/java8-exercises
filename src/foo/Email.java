package foo;

/**
 * Created by Veezq on 2015-10-05.
 */
public class Email {

    private final String message;


    public Email(String message) {
        this.message = message;
    }

    public Email addHeader(){
        return new Email("Dear sir\n"+message);
    }

    public Email checkSpelling(){
        return new Email(message.replaceAll("FTW","for the win"));
    }

    public Email addGreetings(){
        return new Email(message+"\ngreetings");
    }

    @Override
    public String toString() {
        return "Email{" +
                "message='" + message + '\'' +
                '}';
    }
}
