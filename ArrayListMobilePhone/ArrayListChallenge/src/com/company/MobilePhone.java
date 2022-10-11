package com.company;

import java.util.ArrayList;

public class MobilePhone {

    String myNumber;
    private ArrayList<Contact> phoneContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.phoneContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }

        phoneContact.add(contact);
        return true;
    }

    public boolean updateContact(Contact existingContact, Contact newContact) {
        int foundPosition = findContact(existingContact);
        if (foundPosition < 0) {
            System.out.println(existingContact.getName() + " was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact " + existingContact.getName() + " exists. Update was not successful.");
            return false;
        }

        this.phoneContact.set(foundPosition, newContact);
        System.out.println(existingContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }

        this.phoneContact.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted successfully.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.phoneContact.indexOf(contact);
    }

    private int findContact(String contact) {
        for (int i = 0; i <this.phoneContact.size(); i++) {
            Contact Contact = this.phoneContact.get(i);
            if (Contact.getName().equals(contact)) {
                return i;
            }
        }

        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }

            return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.phoneContact.get(position);
        }

        return null;
    }

    public void PrintContacts() {
        System.out.println("Contact list");
        for (int i = 0; i < this.phoneContact.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.phoneContact.get(i).getName() + "  " +
                    this.phoneContact.get(i).getPhoneNumber());
        }
    }
}
