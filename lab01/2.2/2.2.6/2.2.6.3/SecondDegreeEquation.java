import javax.swing.JOptionPane;

public class SecondDegreeEquation {
    public static void main(String[] args) {
        String input;
        double A, B, C;
        
        do {
            input = JOptionPane.showInputDialog(null, "Input A: ",
            "Ax^2 + Bx + C = 0", JOptionPane.INFORMATION_MESSAGE);
            A = Double.parseDouble(input);

            if (A == 0){
                JOptionPane.showMessageDialog(null, "A must not be zero");
            }
        } while (A == 0);
        

        input = JOptionPane.showInputDialog(null, "Input B: ",
        "Ax^2 + Bx + C = 0", JOptionPane.INFORMATION_MESSAGE);
        B = Double.parseDouble(input);

        input = JOptionPane.showInputDialog(null, "Input C: ",
        "Ax^2 + Bx + C = 0", JOptionPane.INFORMATION_MESSAGE);
        C = Double.parseDouble(input);

        double delta = B*B - 4*A*C;

        if (delta > 0){
            double x1 = (-B + Math.sqrt(delta)) / (2 * A);
            double x2 = (-B - Math.sqrt(delta)) / (2 * A);
            JOptionPane.showMessageDialog(null, 
            "The equation has two distinct solutions.\n x1 = " + x1 + "   x2 = " + x2);
        } else if (delta == 0){
            double x = -B / (2 * A);
            JOptionPane.showMessageDialog(null, "Equations with double roots\n x = " + x);
        } else {
            JOptionPane.showMessageDialog(null, "Equation with no solution.");
        }
        System.exit(0);
    }
}
