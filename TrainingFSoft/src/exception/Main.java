package exception;

public class Main {
    public static void main(String[] args) throws CustomException {
        try{
            throw new CustomException("My custom exception!");
        }catch (CustomException e){
            System.out.println("Catch");
            System.out.println(e.getMessage());
        }
    }
}
