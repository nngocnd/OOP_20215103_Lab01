package test;

import model.DigitalVideoDisc;
import model.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
        "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
        "Animation", "Ron Clements", 88, 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // test print() method
        cart.printCart();

        cart.searchById(1);
        cart.searchByTitle("Aladin");
        cart.searchById(7);
    }
}
