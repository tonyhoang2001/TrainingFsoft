package exception;

import java.io.IOException;

public class DifferentThrowsAndThrow {
    public static void main(String[] args) throws ClassNotFoundException, ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }
}
