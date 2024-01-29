package controler;

import model.*;
import node.nodeMerk;
import node.nodeSepatu;

import static model.modelSepatu.listSepatu;

public class controlerSepatu {
    modelSepatu sepatuModel = new modelSepatu();

    public void addSepatu(String nama, String merk, int harga, int ukuran, String warna, int stok){
        sepatuModel.add(new nodeSepatu(nama, harga, ukuran, warna, stok), merk);
        sepatuModel.commitData();
    }

    public boolean editSepatu(String nama, String merk, int harga, int ukuran, String warna, int stok){
        return sepatuModel.edit(new nodeSepatu(nama, harga, ukuran, warna, stok), merk);
    }

    public boolean editStok(String nama, int stok){
        for (nodeMerk merk : listSepatu) {
            for (nodeSepatu sepatu : merk.getSepatuList()) {
                if (sepatu.getNama().equals(nama)) {
                    sepatu.setStok(stok);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteSepatu(String nama){
        return sepatuModel.delete(nama);
    }

    public void searchByMerk(String merk){
        nodeSepatu sepatu = sepatuModel.searchByMerk(merk);
        if (sepatu != null){
            System.out.println("Merk sepatu : "+merk);
            System.out.println("Nama sepatu : "+sepatu.getNama());
            System.out.println("Harga sepatu : "+sepatu.getHarga());
            System.out.println("Ukuran sepatu : "+sepatu.getUkuran());
            System.out.println("Warna sepatu : "+sepatu.getWarna());
            System.out.println("Stok sepatu : "+sepatu.getStok());
        }else {
            System.out.println("Sepatu tidak ditemukan");
        }
    }

    public void searchByNama(String nama){
        for (nodeMerk merk : listSepatu) {
            for (nodeSepatu sepatu : merk.getSepatuList()) {
                if (sepatu.getNama().equals(nama)) {
                    System.out.println("Nama sepatu: " + sepatu.getNama());
                    System.out.println("Merk sepatu: " + merk.getMerk());
                    System.out.println("Harga sepatu: " + sepatu.getHarga());
                    System.out.println("Ukuran sepatu: " + sepatu.getUkuran());
                    System.out.println("Warna sepatu: " + sepatu.getWarna());
                    System.out.println("Stok sepatu: " + sepatu.getStok());
                    System.out.println("------------------------");
                    return;
                }
            }
        }
    }

    public void viewAll(){
        if (listSepatu.isEmpty()) {
            System.out.println("Belum ada sepatu yang tersedia.");
        } else {
            System.out.println("Daftar semua sepatu:");
            for (nodeMerk merk : listSepatu) {
                System.out.println("Merk: " + merk.getMerk());
                for (nodeSepatu sepatu : merk.getSepatuList()) {
                    System.out.println("  Nama sepatu: " + sepatu.getNama());
                    System.out.println("  Harga sepatu: " + sepatu.getHarga());
                    System.out.println("  Ukuran sepatu: " + sepatu.getUkuran());
                    System.out.println("  Warna sepatu: " + sepatu.getWarna());
                    System.out.println("  Stok sepatu: " + sepatu.getStok());
                    System.out.println("  ------------------------");
                }
            }
        }
    }
}
