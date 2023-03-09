package exercise.q6;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();

        while (true){

            //Get user choice
            int choice = studentManagement.getChoice();
            switch (choice){

                // Add new student
                case 1:{
                    studentManagement.addStudent();
                    break;
                }

                //Show students with 20 years old
                case 2:{
                    studentManagement.show20AgeStudents();
                    break;
                }

                //Show number of the student has 23 years old and live in DN
                case 3: {
                    studentManagement.showNumOfStudents();
                    break;
                }

                //Exit the program
                default:{
                    System.out.println("End the program!");
                    return;
                }
            }
        }

    }
}
