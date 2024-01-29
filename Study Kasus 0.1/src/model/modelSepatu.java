package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.*;

import java.util.ArrayList;

public class modelSepatu implements CRUD<nodeSepatu> {
    public static ArrayList<nodeMerk> listSepatu;
    modelJSON<nodeMerk> modelJSONSepatu;
    @Override
    public void add(nodeSepatu Sepatu, String merk) {
        nodeMerk merkUmum = new nodeMerk(merk, new ArrayList<>());

        for (nodeMerk merk1 : listSepatu) {
            if (merk1.getMerk().equals(merk)) {
                merk1.getSepatuList().add(Sepatu);
                return;
            }
        }
        merkUmum.getSepatuList().add(Sepatu);
        listSepatu.add(merkUmum);
    }
    @Override
    public boolean delete(String nama){
        nodeSepatu sepatu = searchByNama(nama);
        if (sepatu != null){
            for (nodeMerk merk : listSepatu) {
                for (nodeSepatu sepatu1 : merk.getSepatuList()) {
                    if (sepatu1.getNama().equals(nama)) {
                        merk.getSepatuList().remove(sepatu1);
                        commitData();
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public nodeSepatu searchByNama(String nama){
        for (nodeMerk merk : listSepatu) {
            for (nodeSepatu sepatu : merk.getSepatuList()) {
                if (sepatu.getNama().equals(nama)) {
                    return sepatu;
                }
            }
        }
        return null;
    }
    @Override
    public boolean edit(nodeSepatu Sepatu, String merk){
        nodeSepatu sepatu = searchByMerk(merk);

        if (sepatu != null ){
            for (nodeMerk merk1 : listSepatu) {
                for (nodeSepatu existingSepatu : merk1.getSepatuList()) {
                    if (existingSepatu.getNama().equals(sepatu.getNama())) {
                        existingSepatu.setNama(sepatu.getNama());
                        merk1.setMerk(merk);
                        existingSepatu.setHarga(sepatu.getHarga());
                        existingSepatu.setUkuran(sepatu.getUkuran());
                        existingSepatu.setWarna(sepatu.getWarna());
                        existingSepatu.setStok(sepatu.getStok());
                        commitData();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public nodeSepatu searchByMerk(String merk){
        for (nodeMerk sepatu : listSepatu){
            if (sepatu.getMerk().equals(merk)) {
                if (!sepatu.getSepatuList().isEmpty()) {
                    return sepatu.getSepatuList().getFirst();
                }
            }
        }
        return null;
    }
    public modelSepatu() {
        listSepatu = new ArrayList<>();
        modelJSONSepatu = new modelJSON<nodeMerk>("src/Database/Sepatu.json");
        loadData();
    }

    private void loadData() {
        listSepatu = modelJSONSepatu.readFromFile(new TypeToken<ArrayList<nodeMerk>>() {
        }.getType());

    }

    public void commitData() {
        modelJSONSepatu.writeToFile(listSepatu);
    }
}