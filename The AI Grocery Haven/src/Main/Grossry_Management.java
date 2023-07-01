package Main;

import GUI.Welcome_Screen;
import Users.Admin;
import Users.DateOfBirth;
import Users.Person;
import Users.UserWriter;

import java.util.ArrayList;

public class Grossry_Management {
    public static void main(String[] args) {
//        Admin admin=new Admin("Muhammad","Muzzammil","admin","muzzammil@gmail.com","admin","Faisalabad",new DateOfBirth("20","October","2003"));
//        UserWriter userWriter = new UserWriter(admin);
//        ArrayList<Person> arrayList = new ArrayList<>();
//        arrayList.add(admin);
//        UserWriter.WriteToFile(arrayList,"admin");
        new Welcome_Screen();
    }
}