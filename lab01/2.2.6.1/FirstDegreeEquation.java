import javax.swing.JOptionPane;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        String a, b, strResult = "";
        double A, B;

        do {
            a = JOptionPane.showInputDialog(null,
                    "Please input a: ", "ax + b = 0",
                    JOptionPane.INFORMATION_MESSAGE);
            A = Double.parseDouble(a);

            if (A == 0) {
                JOptionPane.showMessageDialog(null,
                        "a must not be zero. Try again");
            }
        } while (A == 0);

        b = JOptionPane.showInputDialog(null,
                "Please input b: ", "ax + b = 0",
                JOptionPane.INFORMATION_MESSAGE);
        B = Double.parseDouble(b);

        strResult += A + "x + " + B + " = 0\n" + "=> x = " + (-B / A);

        // display
        JOptionPane.showMessageDialog(null, strResult, 
        "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);;
    }
}
