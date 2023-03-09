package exception;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] a = new int[3];
//        System.out.println(tryCatch(a));
//        System.out.println(thowNewKeyword(3,0));
        System.out.println(thowsKeyword(a));
    }

    // use throw new keyword
    public static double thowNewKeyword(double a, double b) {
        if (b == 0){
            // Ném ra lỗi với message
            throw new ArithmeticException("Catch exception with thow new keyword!");
        }

        else
            return a / b;
    }

    //use throws keyword
    public static int thowsKeyword(int[] a) throws ArrayIndexOutOfBoundsException {
        return a[a.length];
    }

    //use try-catch (-finally)
    public static int[] tryCatch(int[] a) {
        try {
            a[a.length] = 4;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catch exception with try-catch!");
        }
        return a;
    }

}

