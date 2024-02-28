import java.util.Scanner;

public class HotelReservationSystem {
    private static final int NUM_ROOMS = 10; // Number of rooms in the hotel
    private static final double STANDARD_ROOM_PRICE = 100.0;
    private static final double DELUXE_ROOM_PRICE = 150.0;

    private static boolean[] isRoomAvailable = new boolean[NUM_ROOMS];
    private static double[] roomPrices = new double[NUM_ROOMS];

    public static void main(String[] args) {
        initializeRooms();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void initializeRooms() {
        for (int i = 0; i < NUM_ROOMS; i++) {
            isRoomAvailable[i] = true;
            roomPrices[i] = i % 2 == 0 ? STANDARD_ROOM_PRICE : DELUXE_ROOM_PRICE;
        }
    }

    private static void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < NUM_ROOMS; i++) {
            if (isRoomAvailable[i]) {
                System.out.println("Room " + (i + 1) + " - Price: $" + roomPrices[i]);
            }
        }
    }

    private static void makeReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter room number to reserve: ");
        int roomNumber = scanner.nextInt();

        if (roomNumber < 1 || roomNumber > NUM_ROOMS) {
            System.out.println("Invalid room number.");
            return;
        }

        if (!isRoomAvailable[roomNumber - 1]) {
            System.out.println("Room " + roomNumber + " is not available.");
            return;
        }

        isRoomAvailable[roomNumber - 1] = false;
        System.out.println("Reservation for Room " + roomNumber + " has been made.");
    }

    private static void viewBookingDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your reservation number: ");
        int reservationNumber = scanner.nextInt();

        if (reservationNumber < 1 || reservationNumber > NUM_ROOMS) {
            System.out.println("Invalid reservation number.");
            return;
        }

        if (isRoomAvailable[reservationNumber - 1]) {
            System.out.println("No booking found for reservation number " + reservationNumber);
            return;
        }

        System.out.println("Booking Details:");
        System.out.println("Reservation Number: " + reservationNumber);
        System.out.println("Room Number: " + reservationNumber);
        System.out.println("Price: $" + roomPrices[reservationNumber - 1]);

        // Placeholder for payment processing
        processPayment(roomPrices[reservationNumber - 1]);
    }

    private static void processPayment(double amount) {
        // Placeholder for payment processing logic
        System.out.println("Payment of $" + amount + " has been processed successfully.");
    }
}
