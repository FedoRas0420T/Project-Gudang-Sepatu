package view;

import java.util.Scanner;

public class viewLogin {

    viewSepatu viewSepatu = new viewSepatu();
    Scanner in = new Scanner(System.in);

    public void Login() {
        System.out.println("LOGIN ANYING");
        System.out.print("Masukkan Username :");
        String username = in.nextLine();
        System.out.print("Masukkan Password :");
        String password = in.nextLine();
        if (username.equals("admin") && password.equals("admin")) {
            viewSepatu.mainView();
        }
    }

}
