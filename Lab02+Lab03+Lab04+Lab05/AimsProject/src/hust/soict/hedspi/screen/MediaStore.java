package hust.soict.hedspi.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> addToCart());
        container.add(btnAddToCart);

        if(media instanceof Playable){
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> playMedia());
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void playMedia() {
        Playable playableMedia = (Playable) media;

        JDialog dialog = new JDialog();
        dialog.setTitle("Playing media ... ");
        dialog.setSize(300, 200);

        dialog.setLayout(new BorderLayout());

        JLabel label = new JLabel("Now playing: " + media.toString());

        JButton btnClose = new JButton("Close");
        dialog.add(btnClose, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        playableMedia.play();
    }

    private void addToCart() {
        cart.addMedia(media);
    }
}
