package node;

import java.util.ArrayList;

public class nodeSepatu {
    public String nama;
    public int harga;
    public int ukuran;
    public String warna;
    public int stok;

    public nodeSepatu(String nama, int harga, int ukuran, String warna, int stok) {
        this.nama = nama;
        this.stok = stok;
        this.ukuran = ukuran;
        this.warna = warna;
        this.harga = harga;
    }

    public String getNama(){
        return this.nama;
    }

    public int getStok(){
        return this.stok;
    }

    public int getUkuran(){
        return this.ukuran;
    }

    public String getWarna(){
        return this.warna;
    }

    public int getHarga(){
        return this.harga;
    }

    public void setHarga(int harga){
        this.harga = harga;
    }

    public void setUkuran(int ukuran){
        this.ukuran = ukuran;
    }

    public void setWarna(String warna){
        this.warna = warna;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
}
