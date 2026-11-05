package designpatterns.decorator;

public class SMSDecorator implements Notifier {
    private Notifier wrappee;

    public SMSDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send() {
        wrappee.send();
        System.out.println("Sending SMS");
    }
}