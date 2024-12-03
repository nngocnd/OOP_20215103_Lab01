package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Scanner scanner = new Scanner(System.in);
    private static Cart cart = new Cart();
    private static int DVDCountInCart = 0;
    public static void main(String[] args) {
        Media media1 = new DigitalVideoDisc("The Lion King",
            "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(media1);


        while (true){
            showMenu();
            int showMenuOption = scanner.nextInt();
            scanner.nextLine();
            switch (showMenuOption){
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3");
            }
        }
    }

    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(){
        System.out.println("Store Item:");
        store.print();
        while (true){
            storeMenu();
            int storeMenuOption = scanner.nextInt();
            scanner.nextLine();
            switch (storeMenuOption){
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.printCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4");
            }
        }
    }

    public static void updateStore(){
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                System.out.println("What kind of media do you want to add:");
                System.out.println("1. Book");
                System.out.println("2. CompactDisc");
                System.out.println("3. DigitalVideoDisc");
                System.out.println("4. Disc");
                int typeMediaOption = scanner.nextInt();
                scanner.nextLine();
                switch (typeMediaOption){
                    case 1:
                        Book book = createBook();
                        store.addMedia(book);
                        break;
                    case 2:
                        CompactDisc compactDisc = createCompactDisc();
                        store.addMedia(compactDisc);
                        break;
                    case 3:
                        DigitalVideoDisc digitalVideoDisc = createDigitalVideoDisc();
                        store.addMedia(digitalVideoDisc);
                        break;
                    case 4:
                        Disc disc = createDisc();
                        store.addMedia(disc);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 2:
                System.out.println("Please enter the title of media: ");
                String titleMedia = scanner.nextLine();
                Media media = store.searchByTitle(titleMedia);
                if (media != null){
                    store.removeMedia(media);
                } else {
                    System.out.println("Media not found");
                }
        }
    }

    public static void seeCurrentCart(){
        cart.printCart();
        while (true){
            cartMenu();
            int cartMenuOption = scanner.nextInt();
            scanner.nextLine();
            switch (cartMenuOption){
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    System.out.println("Please enter the title of media: ");
                    String titleMedia = scanner.nextLine();
                    Media media = store.searchByTitle(titleMedia);
                    if (media != null){
                        cart.removeMedia(media);
                    } else {
                        System.out.println("Media not found");
                    }
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    System.out.println("An order is created");
                    cart.clear();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4-5");
            }
        }
    }

    public static void filterMediaInCart(){
        System.out.println("1. Filter by Id");
        System.out.println("2. Filter by Title");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                System.out.println("Enter an Id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.filterById(id);
                break;
            case 2:
                System.out.println("Enter an Title: ");
                String title = scanner.nextLine();
                cart.filterByTitle(title);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void sortMediasInCart(){
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by cost");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                cart.sortByTitle();
                cart.printCart();
                break;
            case 2:
                cart.sortByCost();
                cart.printCart();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    public static void seeMediaDetails(){
        System.out.println("Please enter the title of media: ");
        String titleMedia = scanner.nextLine();
        Media media = store.searchByTitle(titleMedia);
        if (media != null){
            System.out.println(media.toString());
            mediaDetailsMenu();
            int mediaDetailsMenuOption = scanner.nextInt();
            scanner.nextLine();
            switch (mediaDetailsMenuOption){
                case 1:
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc){
                        DVDCountInCart += 1;
                        System.out.println("The number of DVD in current cart: " + DVDCountInCart);
                    }
                    break;
                case 2:
                    if (media instanceof Playable){
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2");
            }
        } else {
            System.out.println("Media not found");
        }
    }

    public static void addMediaToCart(){
        System.out.println("Please enter the title of media: ");
        String titleMedia = scanner.nextLine();
        Media media = store.searchByTitle(titleMedia);
        if (media != null){
            cart.addMedia(media);
            if (media instanceof DigitalVideoDisc){
                DVDCountInCart += 1;
                System.out.println("The number of DVD in current cart: " + DVDCountInCart);
            }
        } else {
            System.out.println("Media not found");
        }
    }

    public static void playMedia(){
        System.out.println("Please enter the title of media: ");
        String titleMedia = scanner.nextLine();
        Media media = store.searchByTitle(titleMedia);
        if (media instanceof Playable){
            ((Playable) media).play();
        } else {
            System.out.println("Media not found");
        }
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static Book createBook(){
        System.out.println("Id: ");
        int idMedia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Title: ");
        String titleMedia = scanner.nextLine();
        System.out.println("Category: ");
        String categoryMedia = scanner.nextLine();
        System.out.println("Cost: ");
        float costMedia = scanner.nextFloat();
        scanner.nextLine();

        List<String> authors = new ArrayList<>();
        while(true){
            System.out.println("Enter author's name. 'exit' to stop");
            String author = scanner.nextLine();
            if (author.equalsIgnoreCase("exit")){
                break;
            }
            authors.add(author);
        }

        Book book = new Book(idMedia, titleMedia, categoryMedia, costMedia, authors);
        return book;
    }

    public static CompactDisc createCompactDisc(){
        System.out.println("Id: ");
        int idMedia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Title: ");
        String titleMedia = scanner.nextLine();
        System.out.println("Category: ");
        String categoryMedia = scanner.nextLine();
        System.out.println("Cost: ");
        float costMedia = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Artist: ");
        String artist = scanner.nextLine();
        List<Track> tracks = new ArrayList<>();
        while(true){
            System.out.println("Add track. 'yes' or 'no'");
            String addTrack = scanner.nextLine();
            if (addTrack.equalsIgnoreCase("yes")){
                Track track = createTrack();
                tracks.add(track);
            } else {
                break;
            }
        }

        CompactDisc compactDisc = new CompactDisc(idMedia, titleMedia, categoryMedia, costMedia, artist, tracks);
        return compactDisc;
    }

    public static Track createTrack(){
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        Track track = new Track(title, length);
        return track;
    }

    public static DigitalVideoDisc createDigitalVideoDisc(){
        System.out.println("Id: ");
        int idMedia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Title: ");
        String titleMedia = scanner.nextLine();
        System.out.println("Category: ");
        String categoryMedia = scanner.nextLine();
        System.out.println("Cost: ");
        float costMedia = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Director: ");
        String director = scanner.nextLine();

        DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(idMedia, titleMedia, categoryMedia, costMedia, length, director);
        return digitalVideoDisc;
    }

    public static Disc createDisc(){
        System.out.println("Id: ");
        int idMedia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Title: ");
        String titleMedia = scanner.nextLine();
        System.out.println("Category: ");
        String categoryMedia = scanner.nextLine();
        System.out.println("Cost: ");
        float costMedia = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Director: ");
        String director = scanner.nextLine();

        Disc disc = new DigitalVideoDisc(idMedia, titleMedia, categoryMedia, costMedia, length, director);
        return disc;
    }
}