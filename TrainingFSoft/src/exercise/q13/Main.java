package exercise.q13;

import exercise.q13.service.EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();

        while (true){

            //Get user's choice (from 1 -> 4)
            int choice = employeeManagement.getChoice();
            switch (choice){

                //Add new employee
                case 1:{
                    employeeManagement.addEmployee();
                    break;
                }

                //Update employee
                case 2:{
                    employeeManagement.updateEmployee();
                    break;
                }

                //Delete employee
                case 3:{
                    employeeManagement.deleteEmployee();
                    break;
                }

                //Show experience employee
                case 4:{
                    employeeManagement.showExperience();
                    break;
                }

                //Show Fresher
                case 5:{
                    employeeManagement.showFresher();
                    break;
                }

                //Show Intern
                case 6:{
                    employeeManagement.showIntern();
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
