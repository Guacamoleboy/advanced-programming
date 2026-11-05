package designpatterns.proxy;

public class RealService implements Service {
    public void perform() {
        System.out.println("Real service is performing work.");
    }
}