import javax.swing.JOptionPane;

public class DisplayTriangle {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Height: ");
        int height = Integer.parseInt(input);

        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++) {
                str.append(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                str.append("*");
            }
        str.append("\n");
        }

        JOptionPane.showMessageDialog(null, str.toString());
        System.exit(0);
    }
}
