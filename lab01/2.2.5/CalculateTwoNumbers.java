import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "";
        
        double sum, difference, product, quotient = 1;

        strNum1 = JOptionPane.showInputDialog(null, 
        "Please input the first number: ", "Input the first number", 
        JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null, 
        "Please input the second number: ", "Input the second number", 
        JOptionPane.INFORMATION_MESSAGE);
        
        double num2 = Double.parseDouble(strNum2);

        // calculate 
        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;

        if (num2 != 0){
            quotient = num1 / num2;
        }
        

        // modify display variable
        strNotification += strNum1 + " + " + strNum2 + " = " + sum + "\n" +
                            strNum1 + " - " + strNum2 + " = " + difference + "\n" +
                            strNum1 + " * " + strNum2 + " = " + product + "\n";
                            
        if (num2 != 0){
            strNotification += strNum1 + " / " + strNum2 + " = " + quotient + "\n";
        } else {
            strNotification += "Cannot divide becase the second number equals zero\n";
        }
                            
        // show message dialog
        JOptionPane.showMessageDialog(null, strNotification,
        "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
