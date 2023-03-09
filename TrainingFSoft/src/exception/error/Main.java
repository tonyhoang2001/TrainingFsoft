package exception.error;

public class Main {
    public static void check(int i)
    {
        if (i == 0)
            return;
        else {
            check(i++);
        }
    }

    public static void main(String[] args) {
        check(5);
    }
}
