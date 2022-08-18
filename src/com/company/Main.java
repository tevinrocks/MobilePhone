package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MobilePhone myMobile = new MobilePhone();

    public static void main(String[] args) {

       options();
    }

    public static void options(){
        boolean quit = false;
        while (!quit){
            System.out.println("Select an option: \n" +
                    "0 - Quit \n" +
                    "1 - Add new contact \n" +
                    "2 - Update existing contact \n" +
                    "3 - Delete contact \n" +
                    "4 - Show contacts in phonebook \n" +
                    "5 - Select a contact");
                try{
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        quit = myMobile.quit();
                        break;
                    case 1:
                        addContact();
                        break;
                    case 2:
                        updateContactInfo();
                        break;
                    case 3:
                        deleteContact();
                        break;
                    case 4:
                        printContactList();
                        break;
                    case 5:
                        findContact();
                        break;
                    default:
                        System.out.println("Enter a valid key.");
                }
            } catch (Exception e){
                    System.out.println("Innapropriate key");
                    scanner.nextLine();
                    options();
                }
        }
    }

    public static void printContactList(){
        System.out.println("List of contact names!");
        myMobile.listOfContacts();
        System.out.println();
    }

    public static void updateContactInfo(){
        System.out.println("Enter contact name you would like to update:");
        String name = myMobile.queryContact(scanner.nextLine());
        if (name == null){
            System.out.println("Name doesn't exist in contacts.");
        } else {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();

            System.out.println("Enter new number:");
            long newNumber = scanner.nextLong();
            scanner.nextLine();
            myMobile.updateContact(name, newName, newNumber);
            System.out.println(name + " has been updated to " + newName + "\n");
        }
    }


    public static void addContact() {
        System.out.println("Please enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Now enter " + name + "'s phone number:");
        long number = scanner.nextLong();
        scanner.nextLine();
        myMobile.addNewContact(name, number);

        System.out.println(name + "'s contact information has been added \n");

    }

    public static void deleteContact() {
        System.out.println("Who's contact information would you like to erase?");
        String name = scanner.nextLine();
        myMobile.removeContact(name);
        System.out.println();

    }

    public static void findContact(){
        System.out.println("Enter the username you are searching for:");
        String name = scanner.nextLine();
        int position = myMobile.findContact(name);
        if (position < 0){
            System.out.println("Contact is not in your phonebook. \n" );
        } else {
            Contacts contact = myMobile.getContact(position);
            System.out.println(myMobile.queryContact(contact));
            System.out.println();
        }
    }
}