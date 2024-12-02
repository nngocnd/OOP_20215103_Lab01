package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public Cart(){

    }

    public Cart(List<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public float totalCost() {
        float TotalCost = 0;
        for (Media item : itemsOrdered) {
            TotalCost += item.getCost();
        }
        return TotalCost;
    }

    public void addMedia(Media media){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " is added to the cart");
        } else {
            System.out.println("Cannot add anymore. The cart is full");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " is removed from the cart");
        } else {
            System.out.println(media.getTitle() + " is not exist. Cannot remove");
        }
    }

    public void sortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
//    public void printCart(){
//        System.out.println("***********************CART***********************");
//        System.out.println("Ordered Items:");
//        for (Media item : itemsOrdered){
//            System.out.println(dvd.toString());
//            totalCost += dvd.getCost();
//        }
//        System.out.println("Total cost: " + this.totalCost());
//        System.out.println("***************************************************");
//    }

//    public void searchById(int Id){
//        boolean found = false;
//        for (Book.DigitalVideoDisc disc : itemsOrdered) {
//            if (disc.getId() == Id) {
//                found = true;
//                System.out.println(disc.toString());
//            }
//        }
//
//        if (found == false) {
//            System.out.println("No disc found with id: " + Id);
//        }
//    }
//
//    public void searchByTitle(String title){
//        boolean found = false;
//        for (Book.DigitalVideoDisc disc : itemsOrdered) {
//            if (disc.isMatch(title)) {
//                found = true;
//                System.out.println(disc.toString());
//            }
//        }
//        if (found == false) {
//            System.out.println("No disc found with title: " + title);
//        }
//    }
}
