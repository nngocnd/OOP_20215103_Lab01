import java.util.Scanner;

public class NumbersOfDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // enter month
        String month;
        do {
        	System.out.println("Enter month: ");
        	month = input.nextLine();
        } while(!isValidMonth(month));
        
        // enter year
        int year;
        
        do {
        	System.out.println("Enter year: ");
        	while (!input.hasNextInt()) {
        		System.out.println("Pls enter year again");;
        		input.next();
        	}
        	year = input.nextInt();
        } while (year < 0);
        
        int calculate = calDays(month, year);
        System.out.println(year + ", " + month + " has: " + calculate + " days");
        	
        input.close();
    }
    
    private static boolean isValidMonth(String input) {
    	String [] validMonths = {"January", "Jan", "Jan.", "1", "Febuary", "Feb", "Feb.", "2", "March", "Mar", "Mar.", "3",
    							"April", "Apr", "Apr.", "4", "May", "May.", "5", "June", "Jun.", "Jun", "6", "July", "Jul.",
    							"Jul", "7", "August", "Aug", "Aug.", "8", "September", "Sep", "Sep." ,"9", "October", "Oct",
    							"Oct.", "10", "November", "Nov", "Nov.", "11", "December", "Dec", "Dec.", "12" };
    	for (String validMonth : validMonths) {
    		if (validMonth.equals(input)) return true;
    	}
    	System.out.println("Pls enter again");
    	return false; 
    }
    
    private static int calDays(String month, int year) {
        int monthNumber;
        if (Character.isDigit(month.charAt(0))) {
            // If the input is a number
            monthNumber = Integer.parseInt(month);
        } else {
            if (month.equals("January") || month.equals("Jan") || month.equals("Jan.")) monthNumber = 1;
            else if (month.equals("Febuary") || month.equals("Feb") || month.equals("Feb.")) monthNumber = 2;
            else if (month.equals("March") || month.equals("Mar") || month.equals("Mar.")) monthNumber = 3;
            else if (month.equals("April") || month.equals("Apr") || month.equals("Apr.")) monthNumber = 4;
            else if (month.equals("May") || month.equals("May") || month.equals("May.")) monthNumber = 5;
            else if (month.equals("June") || month.equals("Jun") || month.equals("Jun.")) monthNumber = 6;
            else if (month.equals("July") || month.equals("Jul") || month.equals("Jul.")) monthNumber = 7;
            else if (month.equals("August") || month.equals("Aug") || month.equals("Aug.")) monthNumber = 8;
            else if (month.equals("September") || month.equals("Sep") || month.equals("Sep.")) monthNumber = 9;
            else if (month.equals("October") || month.equals("Oct") || month.equals("Oct.")) monthNumber = 10;
            else if (month.equals("November") || month.equals("Nov") || month.equals("Nov.")) monthNumber = 11;
            else if (month.equals("December") || month.equals("Dec") || month.equals("Dec.")) monthNumber = 12;
            else monthNumber = 0;
        }

        switch (monthNumber) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1; // Invalid month
        }
    }

    private static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
