package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;

public class Store {
    private final static int CAPACITY = 5;
    private ArrayList<DigitalVideoDisc> itemsInStore;

    public Store (){
        itemsInStore = new ArrayList<>(CAPACITY);
    }

    public void addDVD(DigitalVideoDisc dvd){
        if (itemsInStore.size() < CAPACITY){
            itemsInStore.add(dvd);
            System.out.println(dvd.getTitle() + " has been added in the store.");
        } else {
            System.out.println("The store is full. Cannot add " + dvd.getTitle());
        }
    }

    public void removeDVD(String title){
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++){
            if (itemsInStore.get(i).isMatch(title)){
                found = true;
                itemsInStore.remove(i);
                System.out.println(title + "has been removed.");
            }
        }

        if (!found){
            System.out.println(title + " does not exist.");
        }
    }
}
