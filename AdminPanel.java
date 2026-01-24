import java.util.Scanner;
public class AdminPanel {
    public static void main(String[] args) {
        System.out.println("Admin Panel: Access Granted");
        // Additional admin functionalities can be implemented here
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        switch (input) {
            case 1:
                System.out.println("Total users number: ");
                break;
            
            case 2:
                System.out.println("Total transactions number: ");
                break;

            case 3:
                System.out.println("Total active users number: ");
                break;
            case 4:
                System.out.println("Total inactive users number: ");
                break;
                
            default:
                System.out.println("Invalid input");
                break;
        };

        sc.close();
    }
}