package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Book;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Book.DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public List<Book.DigitalVideoDisc> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addDigitalVideoDisc(Book.DigitalVideoDisc disc){
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(disc);
            System.out.println("The disc has been added");
            if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            }
        } else {
            System.out.println("The cart is full. Can not add anymore");
        }
    }

    public void removeDigitalVideoDisc (Book.DigitalVideoDisc disc){
        if (itemsOrdered.remove(disc)) {
            System.out.println("The disc has been removed");
        } else {
            System.out.println("Cannot found the disc");
        }
    }

    public float totalCost() {
        float TotalCost = 0;
        for (Book.DigitalVideoDisc disc : itemsOrdered) {
            TotalCost += disc.getCost();
        }
        return TotalCost;
    }

    public void addDigitalVideoDisc(Book.DigitalVideoDisc[] dvdList){
        if (itemsOrdered.size() + dvdList.length <= MAX_NUMBERS_ORDERED){
            for (Book.DigitalVideoDisc disc : dvdList) {
                itemsOrdered.add(disc);
            }
        } else {
            System.out.println("The cart is full. Can not add entired list");
        }
    }

    public void addDigitalVideoDisc(Book.DigitalVideoDisc dvd1, Book.DigitalVideoDisc dvd2){
        if (itemsOrdered.size() + 2 <= MAX_NUMBERS_ORDERED){
            itemsOrdered.add(dvd1);
            itemsOrdered.add(dvd2);
        } else {
            System.out.println("The cart is full. Can not add this two discs");
        }
    }

    public void printCart(){
        float totalCost = 0;
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Book.DigitalVideoDisc dvd : itemsOrdered){
            System.out.println(dvd.toString());
            totalCost += dvd.getCost();
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("***************************************************");
    }

    public void searchById(int Id){
        boolean found = false;
        for (Book.DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getId() == Id) {
                found = true;
                System.out.println(disc.toString());
            }
        }

        if (found == false) {
            System.out.println("No disc found with id: " + Id);
        }
    }

    public void searchByTitle(String title){
        boolean found = false;
        for (Book.DigitalVideoDisc disc : itemsOrdered) {
            if (disc.isMatch(title)) {
                found = true;
                System.out.println(disc.toString());
            }
        }
        if (found == false) {
            System.out.println("No disc found with title: " + title);
        } 
    }
}
