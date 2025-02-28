import java.util.*;

class Passenger {
    int id;
    String name;
    String flightNumber;
    String seatNumber;

    public Passenger(int id, String name, String flightNumber, String seatNumber) {
        this.id = id;
        this.name = name;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
    }
}

public class AirlineReservationSystem {
    private static List<Passenger> reservations = new ArrayList<>();
    private static int passengerIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nAirline Reservation System");
            System.out.println("1. Book a Flight");
            System.out.println("2. View Reservations");
            System.out.println("3. Search Reservation");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    bookFlight();
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    searchReservation();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }

    private static void bookFlight() {
        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter Seat Number: ");
        String seatNumber = scanner.nextLine();
        
        Passenger passenger = new Passenger(passengerIdCounter++, name, flightNumber, seatNumber);
        reservations.add(passenger);
        System.out.println("Flight booked successfully! Reservation ID: " + passenger.id);
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found!");
            return;
        }
        
        System.out.println("\nList of Reservations:");
        System.out.printf("%-5s %-20s %-15s %-10s\n", "ID", "Name", "Flight Number", "Seat Number");
        for (Passenger p : reservations) {
            System.out.printf("%-5d %-20s %-15s %-10s\n", p.id, p.name, p.flightNumber, p.seatNumber);
        }
    }

    private static void searchReservation() {
        System.out.print("Enter Reservation ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (Passenger p : reservations) {
            if (p.id == id) {
                System.out.println("Reservation Found:");
                System.out.println("ID: " + p.id);
                System.out.println("Name: " + p.name);
                System.out.println("Flight Number: " + p.flightNumber);
                System.out.println("Seat Number: " + p.seatNumber);
                return;
            }
        }
        System.out.println("Reservation not found!");
    }

    private static void cancelReservation() {
        System.out.print("Enter Reservation ID to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Iterator<Passenger> iterator = reservations.iterator();
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            if (p.id == id) {
                iterator.remove();
                System.out.println("Reservation cancelled successfully.");
                return;
            }
        }
        System.out.println("Reservation not found!");
    }
}




SAMPLE INPUT:   (User selects option 1 to book a flight)
    
        Airline Reservation System
1. Book a Flight
2. View Reservations
3. Search Reservation
4. Cancel Reservation
5. Exit
Enter your choice: 1
Enter Passenger Name: John Doe
Enter Flight Number: AI101
Enter Seat Number: A12


SAMPLE OUTPUT: 
    Flight booked successfully! Reservation ID: 1

    


