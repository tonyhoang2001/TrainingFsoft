package exercise.q3;

public class Main {
    public static void main(String[] args) {
        Examination examination = new Examination();

        while (true) {
            int choice = examination.getChoice();
            switch (choice) {

                case 1: {
                    examination.addCandidate();
                    break;
                }

                case 2: {
                    examination.showCandidates();
                    break;
                }

                case 3: {
                    examination.searchByID();
                    break;
                }

                default: {
                    System.out.println("The program is ended!");
                    return;
                }

            }
        }
    }
}
