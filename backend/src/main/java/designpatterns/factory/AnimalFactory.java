package designpatterns.factory;

public class AnimalFactory {
    public static Animal createAnimal(String type) {
        if ("dog".equalsIgnoreCase(type)) return new Dog();
        if ("cat".equalsIgnoreCase(type)) return new Cat();
        if ("cow".equalsIgnoreCase(type)) return new Cow();
        return null;
    }
}