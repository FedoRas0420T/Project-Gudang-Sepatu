package view;

import controler.*;

import java.util.Scanner;


public class viewSepatu {
    controlerSepatu sepatu = new controlerSepatu();
    Scanner in = new Scanner(System.in);
    public void mainView(){
        while (true){
            System.out.println("HALLO TEMAN");
            System.out.println("1. Tambah sepatu");
            System.out.println("2. Edit sepatu");
            System.out.println("3. Edit stok");
            System.out.println("4. Hapus sepatu");
            System.out.println("5. Cari sepatu berdasarkan merk");
            System.out.println("6. Cari sepatu berdasarkan nama");
            System.out.println("7. Lihat semua sepatu");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan : ");
            int pilihan = in.nextInt();
            switch (pilihan){
                case 1 -> tambahSepatu();
                case 2 -> editSepatu();
                case 3 -> editStok();
                case 4 -> hapusSepatu();
                case 5 -> searchByMerk();
                case 6 -> searchByNama();
                case 7 -> lihatSemuaSepatu();
                case 0 -> System.exit(0);
            }
        }

    }

    public void tambahSepatu(){
        in.nextLine();
        System.out.print("Masukkan nama sepatu : ");
        String nama = in.nextLine();
        System.out.print("Masukkan merk sepatu : ");
        String merk = in.nextLine();
        System.out.print("Masukkan harga sepatu : ");
        int harga = in.nextInt();
        System.out.print("Masukkan ukuran sepatu : ");
        int ukuran = in.nextInt();
        in.nextLine();
        System.out.print("Masukkan warna sepatu : ");
        String warna = in.nextLine();
        System.out.print("Masukkan stok sepatu : ");
        int stok = in.nextInt();
        sepatu.addSepatu(nama, merk, harga, ukuran, warna, stok);
    }

    public void editSepatu(){
        in.nextLine();
        System.out.println("Masukkan nama sepatu yang igin di edit : ");
        String nama = in.nextLine();
        System.out.println("Masukkan merk sepatu : ");
        String merk = in.nextLine();
        System.out.println("Masukkan harga sepatu : ");
        int harga = in.nextInt();
        System.out.println("Masukkan ukuran sepatu : ");
        int ukuran = in.nextInt();
        System.out.println("Masukkan warna sepatu : ");
        in.nextLine();
        String warna = in.toString();
        System.out.println("Masukkan stok sepatu : ");
        int stok = in.nextInt();
        sepatu.editSepatu(nama, merk, harga, ukuran, warna, stok);
    }

    public void editStok(){
        in.nextLine();
        System.out.println("Masukkan nama sepatu yang ingin di edit : ");
        String nama = in.nextLine();
        System.out.println("Masukkan stok sepatu : ");
        int stok = in.nextInt();
        sepatu.editStok(nama, stok);
    }

    public void hapusSepatu(){
        System.out.println("Masukkan nama sepatu yang ingin di hapus : ");
        String nama = in.nextLine();
        sepatu.deleteSepatu(nama);
    }

    public void searchByMerk(){
        System.out.println("Masukkan merk sepatu yang ingin dicari : ");
        String merk = in.nextLine();
        sepatu.searchByMerk(merk);
    }

    public void searchByNama(){
        System.out.println("Masukkan nama sepatu yang ingin dicari : ");
        String nama = in.nextLine();
        sepatu.searchByNama(nama);
    }

    public void lihatSemuaSepatu(){
        sepatu.viewAll();
    }
}

