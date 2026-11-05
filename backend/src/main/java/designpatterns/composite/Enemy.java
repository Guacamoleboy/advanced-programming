package designpatterns.composite;

public class Enemy implements GameObject {
    private String name;

    public Enemy(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println("Enemy [" + name + "] tager sin tur...");
    }
}
