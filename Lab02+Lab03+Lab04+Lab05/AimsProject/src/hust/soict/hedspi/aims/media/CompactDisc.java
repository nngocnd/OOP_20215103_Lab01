package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " is added");
        } else {
            System.out.println("Track " + track.getTitle() + "is already exist.");
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " is removed");
        } else {
            System.out.println("Track " + track.getTitle() + "is not exist. Can not remove");
        }
    }

    public int getLength(){
        int totalLength = 0;
        for(Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        for (Track track : tracks){
            track.play();
        }
    }
}
