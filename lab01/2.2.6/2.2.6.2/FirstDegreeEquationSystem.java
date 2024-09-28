import javax.swing.JOptionPane;

public class FirstDegreeEquationSystem {
    public static void main(String[] args) {
        String a11, a12, b1, a21, a22, b2;
        double A11, A12, B1, A21, A22, B2;

        a11 = JOptionPane.showInputDialog(null, 
        "Input a11: ", "a11x + a12y = b1", JOptionPane.INFORMATION_MESSAGE);
        A11 = Double.parseDouble(a11);

        a12 = JOptionPane.showInputDialog(null, 
        "Input a12: ", "a11x + a12y = b1", JOptionPane.INFORMATION_MESSAGE);
        A12 = Double.parseDouble(a12);

        b1 = JOptionPane.showInputDialog(null, 
        "Input b1: ", "a11x + a12y = b1", JOptionPane.INFORMATION_MESSAGE);
        B1 = Double.parseDouble(b1);

        a21 = JOptionPane.showInputDialog(null, 
        "Input a21: ", "a21x + a22y = b2", JOptionPane.INFORMATION_MESSAGE);
        A21 = Double.parseDouble(a21);

        a22 = JOptionPane.showInputDialog(null, 
        "Input a22: ", "a21x + a22y = b2", JOptionPane.INFORMATION_MESSAGE);
        A22 = Double.parseDouble(a22);

        b2 = JOptionPane.showInputDialog(null, 
        "Input b2: ", "a21x + a22y = b2", JOptionPane.INFORMATION_MESSAGE);
        B2 = Double.parseDouble(b2);

        double D = A11 * A22 - A21 * A12;
        double D1 = B1 * A22 - B2 * A12;
        double D2 = A11 * B2 - A21 * B1;
        
        if (D != 0){
            JOptionPane.showMessageDialog(null, 
            "The system has a unique solution.\nx1 = " + D1/D + "\n" + "x2 = " + D2/D,
             "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (D1 == 0 && D2 == 0){
                JOptionPane.showMessageDialog(null, 
                "The system has infinitely many solutions.", "Result", 
                JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                "Unsolved system.", "Result", 
                JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }   
}
