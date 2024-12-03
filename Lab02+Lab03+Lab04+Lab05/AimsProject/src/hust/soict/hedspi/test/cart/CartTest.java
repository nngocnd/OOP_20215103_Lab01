//package hust.soict.hedspi.test.cart;
//
//import hust.soict.hedspi.aims.cart.Cart;
//import hust.soict.hedspi.aims.media.Book;
//import hust.soict.hedspi.aims.media.DigitalVideoDisc;
//import hust.soict.hedspi.aims.media.Media;
//
//public class CartTest {
//    public static void main(String[] args) {
//        Cart cart = new Cart();
//
//        Media media1 = new DigitalVideoDisc("The Lion King",
//            "Animation", "Roger Allers", 87, 19.95f);
//        cart.addMedia(media1);
//
//        Book.DigitalVideoDisc dvd2 = new Book.DigitalVideoDisc("Star Wars",
//        "Science Fiction", "George Lucas", 87, 24.95f);
//        cart.addDigitalVideoDisc(dvd2);
//
//        Book.DigitalVideoDisc dvd3 = new Book.DigitalVideoDisc("Aladin",
//        "Animation", "Ron Clements", 88, 18.99f);
//        cart.addDigitalVideoDisc(dvd3);
//
//        // test print() method
//        cart.printCart();
//
//        cart.searchById(1);
//        cart.searchByTitle("Aladin");
//        cart.searchById(7);
//    }
//}
