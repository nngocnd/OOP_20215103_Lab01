package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private final static int CAPACITY = 100;
    private ArrayList<Media> itemsInStore;

    public Store (){
        itemsInStore = new ArrayList<>(CAPACITY);
    }

    public void addMedia(Media media){
        if (itemsInStore.size() < CAPACITY){
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added in the store.");
        } else {
            System.out.println("The store is full. Cannot add " + media.getTitle());
        }
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " is removed from the store");
        } else {
            System.out.println(media.getTitle() + " is not exist. Cannot remove");
        }
    }

    public void print(){
        for (Media item : itemsInStore){
            System.out.println(item.toString());
        }
    }

    public Media searchByTitle(String title){
        for (Media item : itemsInStore){
            if (title.equalsIgnoreCase(item.getTitle())){
                return item;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
