package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.User;

public class UserSystem {

    public ArrayList<User> list = new ArrayList<>();

    public UserSystem(ArrayList<User> list) {
        this.list = list;
    }

    public UserSystem() {
        this.list = new ArrayList<User>();
    }
//-----------------------------------------------------
    //Read text file to load data

    public void readFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(" ");
                User u = new User(arr[0], arr[1]);
                list.add(u);
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
        }
    }

    //-------------------------------------------------------
    //Add new customer 
    public void addAccount(User u) {
        this.list.add(u);
    }

//-----------------------------------------------------------
    //Login Account

    public boolean login(User u) {
        for (User user : list) {
            if (user.getName().equals(u.getName())) {
                if (user.getPass().equals(u.getPass())) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

//------------------------------------------------------------
    //Write file
    public boolean saveFile(String path) {
        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            OutputStreamWriter osw = new OutputStreamWriter(fos);
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            User t = this.list.get(this.list.size() - 1);
            String line = t.getName() + " " + t.getPass();
            bw.write(line);
            bw.newLine();
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
