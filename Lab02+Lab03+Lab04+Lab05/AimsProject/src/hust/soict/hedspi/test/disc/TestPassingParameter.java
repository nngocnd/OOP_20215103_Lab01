package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.Book;

public class TestPassingParameter {
    public static void main(String[] args) {
        Book.DigitalVideoDisc jungleDVD = new Book.DigitalVideoDisc("Jungle");
        Book.DigitalVideoDisc cinderellaDVD = new Book.DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
    }

    public static void swap(Book.DigitalVideoDisc dvd1, Book.DigitalVideoDisc dvd2) {
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);
    }

    public static void changeTitle(Book.DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new Book.DigitalVideoDisc(oldTitle);
    }
}