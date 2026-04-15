import java.util.Scanner;

public class VaccineMenu{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("===Welcome===");
            System.out.println("1. Register a new Patient");
            System.out.printin("2. Record a vaccination dose");
            System.out.printin("3. View patient vaccination history");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(); //The code for registering a patient will be linked to this line.
                    break;

                case 2:
                    System.out.println(); //vaccination dose record code.
                    break;
                
                case 3:
                    System.out.println(); //patient history code.
                    break;

                case 4:
                    System.out.println("Exiting. Thank you..."); //Exit option.
                    break;
                
                default:
                    System.out.println("Invalid input, please try again.");
            }
        } while (choice !=4); // run while user has not opted to exit.
        sc.close();
    }
}