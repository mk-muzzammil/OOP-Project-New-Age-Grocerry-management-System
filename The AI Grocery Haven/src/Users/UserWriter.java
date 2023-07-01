package Users;

import Stores.MyStore;

import javax.swing.*;
import java.io.Serializable;
import java.util.*;
import java.io.*;

public class UserWriter implements Serializable {

    private static String path="Database/";
    private static ArrayList<Person> arrayList;

    public UserWriter() {

    }

    public UserWriter(Person person) {

        arrayList = (ArrayList<Person>) ArraylistAccToType(person);
    }

    public static ArrayList<Person> getArrayList() {

        return arrayList;
    }

    //======================Returning loaded data Arraylist According to the type of object we passed in constructor====================
    public static ArrayList<?> ArraylistAccToType(Person person) {
        if (person instanceof Admin) {
            ArrayList<Admin> admins = new ArrayList<>();
            return admins;
        } else if (person instanceof Customer) {
            ArrayList<Customer> customer = new ArrayList<>();
            return customer;
        } else if (person instanceof Manager) {
            ArrayList<Manager> manager = new ArrayList<>();
            return manager;
        }
        return null;
    }

    //=================================Loading file data into the ArrayList====================================
    public static ArrayList<Person> LoadArrayList(ArrayList<Person> users, String type) {
        File f = new File(path + type + "Data.ser");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            else {
                try {
                    FileInputStream fin = new FileInputStream(path + type + "Data.ser");
                    ObjectInputStream oin = new ObjectInputStream(fin);

                    users = (ArrayList<Person>) oin.readObject();

                    fin.close();
                    oin.close();
                    return users;
                } catch (EOFException e) {

                } catch (Exception ex) {
                    System.out.println(type);
                    JOptionPane.showMessageDialog(null, "System under Maintenance");
                }

            }
        } catch (Exception e) {
            System.out.println("File Not Created");
        }
        return null;
    }

    public static ArrayList<Customer> LoadArrayList1(ArrayList<Customer> users) {
        File f = new File(path + "customer" + "Data.ser");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            else {
                try {
                    FileInputStream fin = new FileInputStream(path + "customer" + "Data.ser");
                    ObjectInputStream oin = new ObjectInputStream(fin);

                    users = (ArrayList<Customer>) oin.readObject();

                    fin.close();
                    oin.close();
                    return users;
                } catch (EOFException e) {


                }
                catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "System under maintenance");
                }

            }
        } catch (Exception e) {
            System.out.println("File Not Created");
        }
        return null;
    }


    public static ArrayList<MyStore> LoadStoresList(ArrayList<MyStore> stores) {
        File f = new File(path + "Stores.ser");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            else {
                try {
                    FileInputStream fin = new FileInputStream(path + "Stores.ser");
                    ObjectInputStream oin = new ObjectInputStream(fin);

                    stores = (ArrayList<MyStore>) oin.readObject();

                    fin.close();
                    oin.close();
                    return stores;
                }
                catch (EOFException e) {

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No user found exception in UserWriter");
                }

            }
        } catch (Exception e) {
            System.out.println("File Not Created");
        }
        return null;
    }

    //================================Writing Person type data into File of any type of person ============================
    public static void WriteToFile(ArrayList<Person> person, String personType) {
        try {
            FileOutputStream fout = new FileOutputStream(path + personType + "Data.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

            objectOutputStream.writeObject(person);
            System.out.println("==========Objects Written Succesfully =========");
            fout.close();
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WriteCustomerToFile(ArrayList<Customer> customer) {
        try {
            FileOutputStream fout = new FileOutputStream(path + "customer" + "Data.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

            objectOutputStream.writeObject(customer);
            fout.close();

            objectOutputStream.flush();

            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WriteToFile(ArrayList<Manager> managers) {
        try {
            FileOutputStream fout = new FileOutputStream(path + "managerData.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

            objectOutputStream.writeObject(managers);
            fout.close();

            objectOutputStream.flush();

            objectOutputStream.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WriteToFileStores(ArrayList<MyStore> stores) {
        try {
            FileOutputStream fout = new FileOutputStream(path + "Stores.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

            objectOutputStream.writeObject(stores);
            System.out.println("==========Objects Written Succesfully =========");
            fout.close();

            objectOutputStream.flush();

            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Manager> LoadArrayList(ArrayList<Manager> managers) {
        File f = new File(path +  "manager" + "Data.ser");
        try {
            if (!f.exists()) {
                f.createNewFile();
            } else {

                try {
                    FileInputStream fin = new FileInputStream(f);
                    ObjectInputStream oin = new ObjectInputStream(fin);

                    managers = (ArrayList<Manager>) oin.readObject();

                    fin.close();
                    oin.close();

                    return managers;
                }
                catch (EOFException ex) {

                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "System goes under maintainance");
                }

            }
        } catch (Exception e) {
            System.out.println("File Not Created");
        }
        return null;
    }


    //==================================== Main Function just for checking ============================================
//    public static void main(String[] args) {
////    //    Admin admin=new Admin("Muhamad","Muzzammil","admin","muzzammil@gmail.com","admin","Faisalabad",new DateOfBirth("20","October","2003"),"123456790123");
////   //    Admin admin1=new Admin("Muhamad","Muzzammil","muzzammil2","muzzammil@712.gmail.com","sndajda","Faisalabad",new DateOfBirth("20","October","2003"));
////   //    Customer customer=new Customer("Muhamad","Muzzammil","customer","muzzammil@712.gmail.com","1234","Faisalabad",new DateOfBirth("20","October","2003"),"98765");
////    //   Customer customer1=new Customer("Muhamad","Muzzammil","customer1","muzzammil@gmail.com","1234","Faisalabad",new DateOfBirth("20","October","2003"),"12345678");
////     //  Admin admin=new Admin("Muhamad","Muzzammil","admin","muzzammil@gmail.com","admin","Faisalabad",new DateOfBirth("20","October","2003"),"123456789");
//       Manager manager=new Manager("Muhamad","Ali","manager","Ali@712.gmail.com","manager","islamabad",new DateOfBirth("19","October","2005"),"2","200","123456789");
//        Manager manager2 = new Manager("Muhamad", "Sohail", "m1", "Sohail@712.gmail.com", "1", "November", new DateOfBirth("22", "October", "2006"), "3", "500", "123456789");
////
//
//        arrayList = LoadArrayList(arrayList,"manager");
////
//        if (arrayList == null) {
//            arrayList = new ArrayList<>();
//        }
////
//        arrayList.add(manager);
//        WriteToFile(arrayList, "manager");
//        readFromFile("manager");


//        MyStore st=new MyStore(new Manager("2","Sohail","asdf","asdww","wwedwe","adwed","Kharian"),"Kharian");
//
//        ArrayList<MyStore> sto=new ArrayList<>();
//        sto.add(st);
//
//        UserWriter.WriteToFileStores(sto);
//    }
}




