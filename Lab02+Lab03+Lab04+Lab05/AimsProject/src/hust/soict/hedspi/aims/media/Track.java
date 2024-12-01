package hust.soict.hedspi.aims.media;

import javax.swing.*;
import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ( o == null || !(o instanceof Track)) return false;
        Track track = (Track)o;
        return this.title != null && this.title.equals(track.getTitle())
                && this.length == track.length;
    }

    public int hashCode(){
        return Objects.hash(title, length);
    }
}
