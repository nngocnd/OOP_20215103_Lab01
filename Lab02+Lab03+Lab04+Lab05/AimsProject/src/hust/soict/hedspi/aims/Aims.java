package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        Book.DigitalVideoDisc dvd1 = new Book.DigitalVideoDisc("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);

        anOrder.addDigitalVideoDisc(dvd1);

        Book.DigitalVideoDisc dvd2 = new Book.DigitalVideoDisc("Star Wars", "Science Fiction",
                "George Lucas", 87, 24.95f);

        anOrder.addDigitalVideoDisc(dvd2);

        Book.DigitalVideoDisc dvd3 = new Book.DigitalVideoDisc("Aladin", "Animation",
                18.99f);

        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        for (int i = 0; i < anOrder.getItemsOrdered().size(); i++) {
            Book.DigitalVideoDisc disc = anOrder.getItemsOrdered().get(i);
            System.out.println("Disc: " + disc.getTitle() + ", Cost: " + disc.getCost());
        }

        anOrder.removeDigitalVideoDisc(dvd3);

        for (int i = 0; i < anOrder.getItemsOrdered().size(); i++) {
            Book.DigitalVideoDisc disc = anOrder.getItemsOrdered().get(i);
            System.out.println("Disc: " + disc.getTitle() + ", Cost: " + disc.getCost());
        }
    }
}