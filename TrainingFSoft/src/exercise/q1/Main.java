package exercise.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLCB qlcb = new QLCB();

        while (true){
            int choice = qlcb.nhapLuaChon();
            switch (choice){

                case 1:{
                    qlcb.themCanBo();
                    break;
                }

                case 2:{
                    qlcb.timKiemTheoTen();
                    break;
                }

                case 3:{
                    qlcb.hienThiDSCB();
                    break;
                }

                default:{
                    System.out.println("The program is ended!");
                    return;
                }

            }
        }

    }
}
