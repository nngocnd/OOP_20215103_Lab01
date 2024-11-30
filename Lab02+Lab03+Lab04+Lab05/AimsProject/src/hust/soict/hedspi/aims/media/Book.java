package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
        } else {
            System.out.println(STR."Author: \{authorName} is already exist.");
        }
    }

    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
        } else {
            System.out.println(STR."Author: \{authorName} is not exist.");
        }
    }

    public static class DigitalVideoDisc {
        private String title;
        private String category;
        private String director;
        private int length;
        private float cost;

        private static int nbDigitalVideoDiscs = 0;

        private int id;

        public DigitalVideoDisc(String title) {
            this.title = title;
            incrementDVDCount();
        }

        public DigitalVideoDisc(String title, String category, float cost) {
            this.title = title;
            this.category = category;
            this.cost = cost;
            incrementDVDCount();
        }

        public DigitalVideoDisc(String title, String category, String director, float cost) {
            this.title = title;
            this.category = category;
            this.director = director;
            this.cost = cost;
            incrementDVDCount();
        }

        public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
            this.title = title;
            this.category = category;
            this.director = director;
            this.length = length;
            this.cost = cost;
            incrementDVDCount();
        }

        private void incrementDVDCount() {
            nbDigitalVideoDiscs++;
            this.id = nbDigitalVideoDiscs;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public float getCost() {
            return cost;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }


        public static int getNbDigitalVideoDiscs() {
            return nbDigitalVideoDiscs;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
        }

        public boolean isMatch(String title){
            return this.title.equalsIgnoreCase(title);
        }
    }
}
