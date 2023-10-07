package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class Library {

    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }

    public String getAccount(String promt, int a, int cs, ArrayList<User> list) {
        String temp;
        while (true) {
            temp = getString(promt + ": ").trim();
            int min = (a == 1) ? 5 : 6;
            if (temp == null || temp.length() < min) {
                temp = null;
            } else {
                for (int i = 0; i < temp.length(); i++) {
                    if ((temp.charAt(i)) == ' ') {
                        temp = null;
                        break;
                    }
                }
            }
            if (temp != null) {
                if (cs == 1 && a==1) {
                    for (User u : list) {
                        if (temp.equals(u.getName())) {
                            System.out.println("This username already exists. Please try another name.");
                            temp = "1";
                            continue;
                        }
                    }
                    if (temp != null && temp!="1") break;
                }else break;
            } 
            if (temp==null) System.out.println("You must enter least at " + min + " character and no space!");
        }
        return temp;
    }
    public boolean checkExist(String name, ArrayList<User >list){ 
           for(User s : list) { 
                if(s.getName()==(name)){ 
                    return true;
                }
           }
           return false;
    }
}
    
