import java.util.Scanner;

public class TrafficFineSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FineLinkedList list = new FineLinkedList();
        int choice;

        do {
            System.out.println("\n🚦 Traffic Fine Management System 🚦");
            System.out.println("1. Add Traffic Fine");
            System.out.println("2. Display All Fines");
            System.out.println("3. Search Fine by Vehicle Number");
            System.out.println("4. Pay Fine");
            System.out.println("5. Delete Paid Fine");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Fine ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Driver Name: ");
                    String name = sc.nextLine();

                    System.out.print("Vehicle Number: ");
                    String vehicle = sc.nextLine();

                    System.out.print("Violation Type: ");
                    String violation = sc.nextLine();

                    System.out.print("Fine Amount: ");
                    double amount = sc.nextDouble();

                    list.addFine(id, name, vehicle, violation, amount);
                    break;

                case 2:
                    list.displayFines();
                    break;

                case 3:
                    System.out.print("Enter Vehicle Number: ");
                    list.searchByVehicle(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Fine ID to Pay: ");
                    list.payFine(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Fine ID to Delete: ");
                    list.deletePaidFine(sc.nextInt());
                    break;

                case 6:
                    System.out.println("System closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
