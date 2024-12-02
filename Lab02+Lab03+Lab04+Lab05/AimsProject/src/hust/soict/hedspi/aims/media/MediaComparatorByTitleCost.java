package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        int titleComparison = o1.getTitle().compareToIgnoreCase(o2.getTitle());
        if (titleComparison != 0){
            return titleComparison;
        }
        return Float.compare(o2.getCost(), o1.getCost());
    }
}
