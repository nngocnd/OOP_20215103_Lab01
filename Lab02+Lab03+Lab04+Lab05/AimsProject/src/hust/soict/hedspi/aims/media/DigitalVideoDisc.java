package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        incrementDVDCount();
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        incrementDVDCount();
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
        incrementDVDCount();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
        incrementDVDCount();
    }

    private void incrementDVDCount() {
        nbDigitalVideoDiscs++;
        super.setId(nbDigitalVideoDiscs);
    }

    public void setDirector(String director) {
        super.setDirector(director);
    }

    public void setLength(int length) {
        super.setLength(length);
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public String toString() {
        return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + "$";
    }

    public boolean isMatch(String title){
        return this.getTitle().equalsIgnoreCase(title);
    }
}