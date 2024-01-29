package controler;

import model.*;
import node.nodeAdmin;

import java.util.ArrayList;

public class controlerAdmin {
    modelAdmin admin = new modelAdmin();

    public void addAdmin(){
        admin.addAdmin("admin", "admin");
        admin.commitData();
    }

    public boolean validasi(String username, String password) {
            ArrayList<nodeAdmin> adminList = modelAdmin.listAdmin;

            for (nodeAdmin user : adminList) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    System.out.println("Login berhasil untuk user : " + username);
                    return true;
                }
            }
            return false;

    }
}
