package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
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

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public boolean isMatch(String title){
        return this.getTitle().equalsIgnoreCase(title);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public String toString(){
        return getId() + ". DVD " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + "$";
    }
}