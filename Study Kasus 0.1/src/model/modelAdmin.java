package model;

import com.google.gson.reflect.TypeToken;
import modelJSON.modelJSON;
import node.nodeAdmin;

import java.util.ArrayList;

public class modelAdmin implements CRUD<nodeAdmin> {
    public static ArrayList<nodeAdmin> listAdmin;
    modelJSON<nodeAdmin> modelJSONAdmin;

    @Override
    public void add(nodeAdmin Admin, String gg) {
        nodeAdmin admin = new nodeAdmin(Admin.username, Admin.password);
        listAdmin.add(admin);
        commitData();
    }
    @Override
    public nodeAdmin searchByNama(String username){
        for (nodeAdmin admin : listAdmin){
            return admin;
        }
        return null;
    }
    public boolean edit(nodeAdmin Admin, String gg){
        return false;
    }
    @Override
    public boolean delete(String username){
        return false;
    }
    @Override
    public nodeAdmin searchByMerk(String username){
        return null;
    }
    public modelAdmin() {
        listAdmin = new ArrayList<>();
        modelJSONAdmin = new modelJSON<nodeAdmin>("src/Database/Admin.json");
        loadData();
    }

    public void addAdmin(String username, String password) {
        nodeAdmin admin = new nodeAdmin(username, password);
        listAdmin.add(admin);
    }


    private void loadData() {
        listAdmin = modelJSONAdmin. readFromFile(new TypeToken<ArrayList<nodeAdmin>>() {}.getType());
    }

    public void commitData() {
        modelJSONAdmin.writeToFile(listAdmin);
    }

}
