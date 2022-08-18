package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contacts = new ArrayList<>();

    public MobilePhone(){

    }

    public boolean quit(){
        System.out.println("exiting program!");
        return true;
    }

    public void  listOfContacts(){
        for (var contact : contacts){
            System.out.println(contact.getName());
        }
    }

    public void addNewContact(String name, long number){
        if (findContact(name) >= 0){
            System.out.println(name + " already exists in your contacts.");
        } else {
            Contacts newContact = new Contacts(name, number);
            contacts.add(newContact);
        }
    }

    public boolean updateContact(String oldName, String name, long number){
        if(findContact(oldName) < 0){
            System.out.println("contact doesn't exist");
            return false;
        }
        int position = findContact(oldName);
        contacts.get(position).setName(name);
        contacts.get(position).setPhoneNum(number);
        System.out.println(contacts.get(position).getName());
        return true;
    }

    public void removeContact(String name){
        int position = findContact(name);
        this.contacts.remove(position);
        System.out.println("You have just removed " + name + " from your contacts.");
    }

    public int findContact(Contacts contact){
        return this.contacts.indexOf(contact);
    }

    public int findContact (String contactName){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact (Contacts contact){
        return contact.getName() + " => " + contact.getPhoneNum();
    }

    public String queryContact (String contactName){
        int position = findContact(contactName);
        if (position >= 0){
            return contacts.get(position).getName();
        } else {
            return null;
        }
    }

    public Contacts getContact (int position){
        return contacts.get(position);
    }
}
