package exercise.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QLCB {

    Scanner scanner = new Scanner(System.in);
    private List<CanBo> list;

    public QLCB() {
        this.list = new ArrayList<>();
    }

    void themCanBo() {

        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhap tuoi: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhap gioi tinh (nam, nu, khac): ");
        String gioiTinh = scanner.nextLine();

        System.out.print("Nhap dia chi: ");
        String diaChi = scanner.nextLine();

        int choice = nhapLoaiCanBo();
        switch (choice){
            case 1:{
                System.out.print("Nhap Bac (1-10): ");
                int bac = scanner.nextInt();
                scanner.nextLine();
                CongNhan congNhan = new CongNhan(hoTen,tuoi,gioiTinh,diaChi,bac);
                this.list.add(congNhan);
                break;
            }

            case 2:{
                System.out.print("Nhap Nganh Dao Tao: ");
                String nganhDT = scanner.nextLine();
                KySu kySu = new KySu(hoTen,tuoi,gioiTinh,diaChi,nganhDT);
                this.list.add(kySu);
                break;
            }

            case 3:{
                System.out.print("Nhap Cong Viec: ");
                String congViec = scanner.nextLine();
                NhanVien nhanVien = new NhanVien(hoTen,tuoi,gioiTinh,diaChi,congViec);
                this.list.add(nhanVien);
                break;
            }
        }

        System.out.println("Them thanh cong!");

    }

    void timKiemTheoTen() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        List<CanBo> listSearch = this.list.stream()
                .filter(c -> c.getHoTen().contains(name))
                .collect(Collectors.toList());
        if (listSearch == null || listSearch.isEmpty()){
            System.out.println("Danh sach trong!");
            return;
        }
        listSearch.stream().forEach(System.out::println);
    }

    void hienThiDSCB() {
        if (this.list.isEmpty()){
            System.out.println("Danh sach trong!");
            return;
        }
        this.list.stream().forEach(System.out::println);
    }

    int nhapLuaChon() {
        while (true) {
            hienThiLuaChon();
            System.out.print("Your choice (1->4): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 4) {
                    throw new Exception();
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }

    int nhapLoaiCanBo() {
        while (true) {
            hienThiLoaiCanBo();
            System.out.print("Your choice (1->3): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 3) {
                    throw new Exception();
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }

    void hienThiLuaChon(){
        System.out.println("\n------------ Quan ly can bo ------------");
        System.out.println("1. Them moi can bo.");
        System.out.println("2. Tim kiem theo ten.");
        System.out.println("3. Hien thi danh sach can bo.");
        System.out.println("4. Thoat chuong trinh.");
    }

    void hienThiLoaiCanBo(){
        System.out.println("\n------------ Loai Can Bo ------------");
        System.out.println("1. Cong Nhan.");
        System.out.println("2. Ky Su.");
        System.out.println("3. Nhan Vien.");
    }

}