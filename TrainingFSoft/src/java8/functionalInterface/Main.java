package java8.functionalInterface;

public class Main {
    public static void main(String[] args) {
        new SAM() {
            @Override
            public void show() {

            }
        };
    }
}

@FunctionalInterface
interface SAM{
    void show();
    default void a(){}
    static void b(){}
}
