package designpatterns.exercises.command;

public class Main {

    public static void main(String[] args) {
        CardReader terminal = new CardReader();

        Button green = new Button(new AcceptCommand(terminal));

        green.press();


    }
}
