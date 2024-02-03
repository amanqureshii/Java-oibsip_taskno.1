import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class ReservationSystem {
    private Map<String, List<String>> reservations;

    public ReservationSystem() {
        this.reservations = new HashMap<>();
    }

    public void makeReservation(String userName, String reservationDate) {
        List<String> users = reservations.get(reservationDate);
        if (users == null) {
            users = new ArrayList<>();
            reservations.put(reservationDate, users);
        }
        users.add(userName);
        System.out.println("Reservation successful for " + userName + " on " + reservationDate);
    }
    

    public void displayReservations() {
        System.out.println("Current Reservations:");
        for (Map.Entry<String, List<String>> entry : reservations.entrySet()) {
            String date = entry.getKey();
            List<String> users = entry.getValue();
            System.out.println(date + ": " + users);
        }
    }
}

 class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Make Reservation");
            System.out.println("2. Display Reservations");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter reservation date (YYYY-MM-DD): ");
                    String reservationDate = scanner.nextLine();
                    reservationSystem.makeReservation(userName, reservationDate);
                    break;
                case 2:
                    reservationSystem.displayReservations();
                    break;
                case 3:
                    System.out.println("Exit the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

