/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas2;

/**
 *
 * @author AJENG
 */
// Memanggil library yang digunakan
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// Membuat class khusus Menu
class Menu{
    // Mendeklarasikan variabel yang ada pada Menu
    String name;
    double price;
    String category;
    
    // Konstruktor Menu
    public Menu(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    //fungsi getter dan setter
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    public void setName (String name){
        this.name = name;
    } 
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory (String category){
        this.category = category;
    }
    
}



public class Main {
    public static void main (String[] args){
        // Menginisiasi scanner
        Scanner scanner = new Scanner(System.in);
        
        // Mendeklarasikan array menu
        Menu[] menu = new Menu[]{
          new Menu("Bebek Goreng", 30000, "Makanan"),
          new Menu ("Ikan Bakar", 65000, "Makanan"),
          new Menu ("Gurame Asap", 30000, "Makanan"),
          new Menu ("Penyet Tempe", 7000, "Makanan"),
          new Menu ("Lele Goreng", 10000, "Makanan"),
          new Menu ("Lemonade", 5000, "Minuman"),
          new Menu ("Iced Tea", 5000, "Minuman"),
          new Menu ("Strawberry Juice", 22000, "Minuman"),
          new Menu ("Es Buah", 17000, "Minuman"),
          new Menu ("Air Mineral", 3000, "Minuman")
        };
        
        
        
        // Mendklarasikan program awal, akan diberikan pilihan masuk sebagai Admin atau pengguna dan opsi keluar.
       
        
        System.out.println("========================================== Warung Murah App ==========================================");
        System.out.println("Welcome to Warung Murah App!");
        System.out.println("Please choose your roles!");
        System.out.println("[0] Exit");
        System.out.println("[1] Admin");
        System.out.println("[2] Guest");
        System.out.println("Ps: Please input the index of your roles, and type \"0\" to exit the app. ");
        System.out.println("Please input your options here: ");
        int opsiProgram = scanner.nextInt();
        
        // Menginisiasi Program Utama 
        do{
            if(opsiProgram == 0){
                break;
            }
            if(opsiProgram == 1){
                System.out.println("----------------------------------- Welcome Admin -----------------------------------------");
                System.out.println("Menu onboard: ");
                                    for (int i = 0; i < menu.length; i++){
                                        System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                                    }
                System.out.println();
                System.out.println("Please choose actions bellow! ");
                System.out.println("[0] Exit ");
                System.out.println("[1] Add Menu");
                System.out.println("[2] Update Prices");
                System.out.println("[3] Remove Menu");
                System.out.println("Please input the index of your actions here: ");
                int opsiProgramAdm = scanner.nextInt();
                // Menginisiasi kondisional untuk menjalankan fungsi sesuai dengan pilihan user
                    if(opsiProgramAdm == 0){
                        System.out.println("Do you want to go back to this menu ? (true/false)");
                        boolean backMain = scanner.nextBoolean();
                        // kondisional
                           if(backMain == true){
                            System.out.println("========================================== Warung Murah App ==========================================");
                            System.out.println("Please choose your roles!");
                            System.out.println("[0] Exit");
                            System.out.println("[1] Admin");
                            System.out.println("[2] Guest");
                            System.out.println("Ps: Please input the index of your roles, and type \"0\" to exit the app. ");
                            System.out.println("Please input your options here: ");;
                            opsiProgram = scanner.nextInt();
                        }
                        if(backMain == false){
                            continue;
                        }
                        if(backMain != true && backMain != false){
                            System.out.println("Sorry, wrong input! Please input only true or false");
                            System.out.println("Please input your options here: ");
                            opsiProgramAdm = scanner.nextInt();
                        }
                    }
                    else if(opsiProgramAdm == 1){
                        boolean opsiKeluar = false;
                        do{
                           System.out.println("Please input all the requirement bellow: ");
                           System.out.print("Menu name: ");
                           String nameAdd = scanner.nextLine();
                           if(nameAdd.isEmpty()){
                               System.out.print("Item's name shouldn't be empty!");
                               continue;
                           }
                           System.out.print("Menu price: ");
                           double priceAdd = scanner.nextDouble();
                           System.out.print("Menu cathegory: ");
                           String catAdd = scanner.next();
                           if(catAdd.isEmpty()){
                               System.out.println("Item's cathegory shouldn't be empty!");
                               continue;
                           }
                           System.out.println();
                           System.out.println("Are you sure you want to add this new item to menu? (true/false)");
                           boolean opsi = scanner.nextBoolean();

                                if(opsi != true && opsi !=false){
                                    System.out.println("Wrong input!, please input only true or false...");
                                    continue;
                                }else if (opsi == false){
                                    continue;
                                }
                                if(opsi == true){
                                    Menu[] menuBaru = new Menu[menu.length+1];
                                    System.arraycopy(menu, 0, menuBaru, 0, menu.length);
                                    menuBaru[menuBaru.length-1] = new Menu(nameAdd, priceAdd, catAdd);

                                    menu = menuBaru;
                                    System.out.println("The new item is succesfully added. ");
                                    System.out.println("Here are the new menu:");
                                    System.out.println("Menu onboard: ");
                                    for (int i = 0; i < menu.length; i++){
                                        System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                                    }
                                }
                            System.out.println("Action is done, Do you want to stop? (true/false)");
                            opsi = scanner.nextBoolean();
                            opsiKeluar = opsi;
                       }while(opsiKeluar != true);
                    }
                    else if (opsiProgramAdm == 2){
                        Boolean opsiKeluar = false;
                        do{
                                System.out.println();
                                System.out.println("Please input index of the item you wanted to update the price: ");
                                int indeks = scanner.nextInt();
                                System.out.println("Input the new price: ");
                                double harga = scanner.nextDouble();
                                System.out.println("Are you sure you want to change " + menu[indeks - 1].getName()+ " price? (Yes/No)");
                                String opsi = scanner.next();
                                
                                
                                if (opsi.equalsIgnoreCase("No")){       
                                continue;
                                }
                                if(opsi.equalsIgnoreCase("Yes") ){
                                    menu[indeks - 1].setPrice(harga);
                                    System.out.println(menu[indeks - 1].getName() +" - "+menu[indeks-1].getPrice()+  " is succesfully changed. ");
                                    System.out.println("Here are the new menu:");
                                    System.out.println("Menu onboard: ");
                                    for (int i = 0; i < menu.length; i++){
                                        System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                                    }
                                    opsiKeluar = true;
                                }
                                else{
                                    while(opsi != "Yes" || opsi != "No"){
                                        System.out.println("Sorry wrong input!, please input only Yes or No...");
                                        opsi = scanner.nextLine();
                                        if(opsi.equalsIgnoreCase("Yes")){
                                            menu[indeks - 1].setPrice(harga);
                                            System.out.println(menu[indeks - 1].getName() +" - "+menu[indeks-1].getPrice()+  " is succesfully changed. ");
                                            System.out.println("Here are the new menu:");
                                            System.out.println("Menu onboard: ");
                                            for (int i = 0; i < menu.length; i++){
                                                System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                                            }
                                            opsiKeluar = true;
                                            continue;
                                            }
                                        else if(opsi.equalsIgnoreCase("No")){
                                            continue;
                                        }
                                    }
                                } 
                            System.out.println("Action is done, Do you want to stop? (yes/no)");
                            opsi = scanner.next();
                            if(opsi.equalsIgnoreCase("Yes")){
                                opsiKeluar = true;
                            }
                            else if (opsi.equalsIgnoreCase("No")){
                                opsiKeluar = false;
                            }
                            else{
                                while(opsi != "Yes" || opsi != "No"){
                                    System.out.println("Sorry, wrong input! please input only Yes or No...");
                                    opsi = scanner.nextLine();
                                    if(opsi.equalsIgnoreCase("yes")){
                                        opsiKeluar = true;
                                    }
                                    else if (opsi.equalsIgnoreCase("no")){
                                        opsiKeluar = false;
                                    }
                                }
                            }
                        }while(opsiKeluar == false);
                    }    
                    else if(opsiProgramAdm == 3){
                        boolean opsiKeluar = false;
                        do{
                            System.out.println();
                            System.out.println("Please input index of the item you wanted to remove");
                            int indeks = scanner.nextInt();
                            System.out.println();
                            System.out.println("Are you sure you want to remove " + menu[indeks - 1].getName()+ " from the menu? (Yes/No)");
                            String opsi = scanner.next();
                            
                            if (opsi.equalsIgnoreCase("No")){
                                continue;
                            }
                            else if(opsi.equalsIgnoreCase("Yes")){
                                Menu[] menuBaru = new Menu[menu.length-1];
                                        if(indeks < menu.length){
                                            System.arraycopy(menu, 0, menuBaru, 0, indeks - 1);
                                            System.arraycopy( menu, indeks, menuBaru, indeks - 1, menu.length- indeks);
                                        }
                                        else{
                                            indeks -=1;
                                            System.arraycopy(menu, 0, menuBaru, 0, indeks);
                                        }
                                menu = menuBaru;
                                
                                System.out.println(menu[indeks - 1].getName() +  "is succesfully removed. ");
                                System.out.println("Here are the new menu:");
                                System.out.println("Menu onboard: ");
                                for (int i = 0; i < menu.length; i++){
                                    
                                    System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                                }
                                opsiKeluar = true;
                            }
                            else if (opsi != "Yes" && opsi != "No"){
                                System.out.println("Wrong input!, please input only Yes or no...");
                                System.out.println("Please input your option here: ");
                                opsi = scanner.next();           
                                if (opsi.equalsIgnoreCase("No")){
                                    continue;
                                }
                                else if(opsi.equalsIgnoreCase("Yes")){
                                    Menu[] menuBaru = new Menu[menu.length - 1];
                                    if(indeks < menu.length-1){
                                        System.arraycopy(menu, 0, menuBaru, 0, indeks - 1);
                                        System.arraycopy( menu, indeks, menuBaru, indeks - 1, menu.length - indeks);
                                    }
                                    else{
                                        System.arraycopy(menu, 0, menuBaru, 0, indeks -1); 
                                    }
                                    menu = menuBaru;

                                    System.out.println(menu[indeks - 1].getName() +  "is succesfully removed. ");
                                    System.out.println("Here are the new menu:");
                                    for (int i = 0; i < menu.length; i++){
                                        System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                                    }
                                    opsiKeluar = true;
                                }
                            }
                            System.out.println("Action is done, Do you want to stop? (yes/no)");
                            opsi = scanner.next();
                            if(opsi.equalsIgnoreCase("Yes")){
                                opsiKeluar = true;
                            }
                            else if (opsi.equalsIgnoreCase("No")){
                                opsiKeluar = false;
                            }
                            else{
                                while(opsi != "Yes" || opsi != "No"){
                                    System.out.println("Sorry, wrong input! please input only Yes or No...");
                                    opsi = scanner.nextLine();
                                    if(opsi.equalsIgnoreCase("yes")){
                                        opsiKeluar = true;
                                    }
                                    else if (opsi.equalsIgnoreCase("no")){
                                        opsiKeluar = false;
                                    }
                                }
                            }
                        }while(opsiKeluar == false);
                    }    
                    else if(opsiProgramAdm != 0 &&opsiProgramAdm != 1 && opsiProgramAdm != 2 && opsiProgramAdm != 3){
                        System.out.println("Sorry, you've input the wrong number! Please choose between 0,1, 2 or 3.");
                        System.out.println("Please input your options here: ");
                        opsiProgram = scanner.nextInt();
                }
                
            }
          
            else if(opsiProgram == 2){
                // Menginisiasi menu untuk pelanggan
                System.out.println("----------------------------------Here is our menu!----------------------------------");
                for(int i = 0; i < menu.length; i++){
                    System.out.println((i+1) + " " + menu[i].getName() + "                 " + menu[i].getPrice());
                }
                System.out.println();
                
                // Mendeklarasikan arraylist dan variabel lain yang mungkin untuk proses perulangan dan perhitungan
                ArrayList <String> orderList = new ArrayList<>();
                ArrayList <Integer> quantity = new ArrayList<>();
                ArrayList <Double> orderTotal = new ArrayList<>();
                ArrayList <Double> perItemPrice = new ArrayList<>();
                double tPrice = 0;
                double discount = 0.1;
                double taxrate = 0.1;
                int serviceCost = 20000;
                double service;
                double afterTaxPrice;
                double discountedPrice;
                double totalPriceTax;
                
                // Menginisiasikan perulangan untuk menyimpan pesanan kedalam array
                do{
                    System.out.println("Please input the index of the item you wanted to order: ");
                    System.out.println("(Type \"0\" if you wanted to stop ordering)");
                    int itemOrder = scanner.nextInt();
                    
                    // kondisional untuk keluar dari perulangan
                    if(itemOrder == 0){
                        break;
                    }
                    if(itemOrder < 1 || itemOrder > menu.length){
                        System.out.println("Sorry the index you've input is wrong! Please input it again...");
                        continue;
                    }
                    
                    // Memasukkan kuantitas dari
                    System.out.println("Please input the quantity: ");
                    System.out.println("(The quantity should be above 0)");
                    int orderQty = scanner.nextInt();
                    if(orderQty == 0){
                        System.out.println("The quantity you've input is wrong, please input it again (it should be above 0)");
                        continue;
                    }
                    
                    // Menyimpan pesanan kedalam arrayList
                    orderList.add(menu[itemOrder - 1].getName());
                    quantity.add(orderQty);
                    orderTotal.add(menu[itemOrder - 1].getPrice());
                    perItemPrice.add(orderTotal.get(orderTotal.size()-1)*quantity.get(quantity.size()-1));
                } while(true);
                
                // Melakukan kalkulasi total pemesanan
                for(int i=0; i < orderList.size(); i++){
                    tPrice += perItemPrice.get(i);
                    
                }
                // Menambahkan biaya pajak dan service
                afterTaxPrice = tPrice * taxrate;
                totalPriceTax = tPrice + afterTaxPrice;
                service = totalPriceTax + serviceCost;
                boolean opsiKeluar = false;
                do{
                    if(tPrice == 0){
                        break;
                    }
                    // Melakukan pencetakan struk
                    System.out.println("============================================================");
                    System.out.println("                        Struk Pembayaran                    ");
                    System.out.println("============================================================");

                    //menampilkan setiap item yang dipesan
                    for(int i = 0; i <orderList.size();i++){
                        System.out.println((i+1) + " " + orderList.get(i) + "           " + quantity.get(i) + "           " + perItemPrice.get(i));
                    }
                    System.out.println("Tax rate (10%)               " + afterTaxPrice + "         " + totalPriceTax);
                        System.out.println("Service cost                 " + serviceCost + "         " + service);
                    System.out.println("---------------------------------------------------");

                    // Kondisional untuk menentukan diskon dan penawaran
                    if(service > 100000){
                        // Pada video saya baru sadar ternyata saya menuliskan +, seharusnya servis dikurangi diskon
                        discountedPrice = service * discount;
                        service -= discountedPrice;

                        // Print total
                        System.out.println("Discount (10%)                   " + discountedPrice + "         " + service);
                        System.out.println("Total yang harus dibayar     " + service);
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Thank you, Please come again!!!");
                        System.out.println("=================================================================");
                        break;

                    } else if(service > 50000 && service <= 100000){
                        System.out.println("Selamat anda mendapat penawaran buy 1 get 1 free untuk item minuman Strawberry Juice");
                        System.out.println("Apakah anda tertarik dengan penawaran ini? (true/false): ");;
                        boolean penawaran = scanner.nextBoolean();

                        // Kondisional untuk pengambilan penawaran
                        if(penawaran == true){
                            orderList.add("Strawberry Juice");
                            quantity.add(2);
                            orderTotal.add(menu[7].getPrice());
                            perItemPrice.add(menu[7].getPrice());

                            // Kalkulasi setelah membeli minuman 
                            service += 22000;

                            // Print total
                            System.out.println("Buy 1 get 1 free (Strawberry Juice)" + orderTotal.get(orderTotal.size()-1)+ "           " + quantity.get(quantity.size()-1)+ "           " + perItemPrice.get(perItemPrice.size()-1));
                            System.out.println("Total yang harus dibayar     " + service);
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Thank you, Please come again!!!");
                            System.out.println("=================================================================");
                            break;
                        }else if(penawaran ==false){
                            System.out.println("Total yang harus dibayar     " + service);
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Thank you, Please come again!!!");
                            System.out.println("=================================================================");
                            break;
                        }
                    }else{
                        System.out.println("Total yang harus dibayar     " + service);
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Thank you, Please come again!!!");
                        System.out.println("=================================================================");
                        break;
                    }
                }while(true);
                System.out.println("Bill is closed, do you want to go back to the main menu? (true/false)");
                boolean backMain = scanner.nextBoolean();
                // kondisional
                   if(backMain == true){
                    System.out.println("========================================== Warung Murah App ==========================================");
                    System.out.println("Please choose your roles!");
                    System.out.println("[0] Exit");
                    System.out.println("[1] Admin");
                    System.out.println("[2] Guest");
                    System.out.println("Ps: Please input the index of your roles, and type \"0\" to exit the app. ");
                    System.out.println("Please input your options here: ");;
                    opsiProgram = scanner.nextInt();
                }
                if(backMain == false){
                    continue;
                }
            }else{
                System.out.println("Sorry, you've input the wrong number! Please choose between 0,1, or 2.");
                System.out.println("Please input your options here: ");
                opsiProgram = scanner.nextInt();
            }
        } 
        while(opsiProgram != 0);
        System.out.println("========================================== App Closed ==========================================");
        System.out.println("Code by: Ajeng Ratu Langi(042247643)");
    }
}

