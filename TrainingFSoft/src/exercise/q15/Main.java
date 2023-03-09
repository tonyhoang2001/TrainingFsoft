package exercise.q15;

import exercise.q15.service.DepartmentManagement;
import exercise.q15.service.StudentManagement;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        DepartmentManagement departmentManagement = new DepartmentManagement();

        while (true) {

            //Get user's choice (from 1 -> 12)
            int choice = studentManagement.getChoice();
            switch (choice) {

                //Add new department.
                case 1: {
                    departmentManagement.addDepartment();
                    break;
                }

                //Add new employee.
                case 2: {
                    studentManagement.addStudent();
                    break;
                }

                //Determine student is regular student or not? (by ID).
                case 3: {
                    studentManagement.determineRegular();
                    break;
                }

                //Get average semester of a student by given semester.
                case 4: {
                    studentManagement.getAverageSemester();
                    break;
                }

                //Get total of regular student.
                case 5: {
                    studentManagement.getTotalOfRegular();
                    break;
                }

                //Find students have highest income grade in each department.
                case 6: {
                    studentManagement.findHighestIncomeGradeStudents();
                    break;
                }

                //Get list of in-service students by given training address in each department.
                case 7: {
                    studentManagement.getInServiceStudentsByTrainingAddress();
                    break;
                }

                //Get list of students have average semester >= 8.0 in the latest semester in each department.
                case 8: {
                    studentManagement.getGoodStudents();
                    break;
                }

                //Get students have highest average semester in any semester in each department.
                case 9: {
                    studentManagement.getHighestAvgSemesterStudents();
                    break;
                }

                //Sort students by type in ascending and in descending order by start year in each department.
                case 10: {
                    studentManagement.sortByTypeAndStartYear();
                    break;
                }

                //Statistic the number of students by start year in each department.
                case 11: {
                    studentManagement.statisticStudents();
                    break;
                }

                //Exit the program
                default: {
                    System.out.println("End the program!");
                    return;
                }

            }
        }
    }
}
