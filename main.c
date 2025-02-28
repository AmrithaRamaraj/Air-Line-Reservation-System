#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SEATS 100

typedef struct {
    int seatNumber;
    char passengerName[50];
    int isBooked;
} Seat;

Seat seats[MAX_SEATS];

void initializeSeats() {
    for (int i = 0; i < MAX_SEATS; i++) {
        seats[i].seatNumber = i + 1;
        seats[i].isBooked = 0;
        strcpy(seats[i].passengerName, "");
    }
}

void bookSeat() {
    int seatNum;
    printf("Enter seat number to book (1-%d): ", MAX_SEATS);
    scanf("%d", &seatNum);
    getchar();
    
    if (seatNum < 1 || seatNum > MAX_SEATS) {
        printf("Invalid seat number!\n");
        return;
    }
    
    if (seats[seatNum - 1].isBooked) {
        printf("Seat already booked!\n");
    } else {
        printf("Enter passenger name: ");
        fgets(seats[seatNum - 1].passengerName, 50, stdin);
        seats[seatNum - 1].passengerName[strcspn(seats[seatNum - 1].passengerName, "\n")] = 0;
        seats[seatNum - 1].isBooked = 1;
        printf("Seat booked successfully!\n");
    }
}

void viewSeats() {
    printf("\nSeat Status:\n");
    for (int i = 0; i < MAX_SEATS; i++) {
        printf("Seat %d: %s\n", seats[i].seatNumber, seats[i].isBooked ? seats[i].passengerName : "Available");
    }
}

void cancelBooking() {
    int seatNum;
    printf("Enter seat number to cancel (1-%d): ", MAX_SEATS);
    scanf("%d", &seatNum);
    getchar();
    
    if (seatNum < 1 || seatNum > MAX_SEATS) {
        printf("Invalid seat number!\n");
        return;
    }
    
    if (!seats[seatNum - 1].isBooked) {
        printf("Seat is not booked!\n");
    } else {
        seats[seatNum - 1].isBooked = 0;
        strcpy(seats[seatNum - 1].passengerName, "");
        printf("Booking cancelled successfully!\n");
    }
}

void mainMenu() {
    int choice;
    while (1) {
        printf("\nAirline Reservation System\n");
        printf("1. Book a Seat\n");
        printf("2. View Seats\n");
        printf("3. Cancel Booking\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        getchar();
        
        switch (choice) {
            case 1:
                bookSeat();
                break;
            case 2:
                viewSeats();
                break;
            case 3:
                cancelBooking();
                break;
            case 4:
                printf("Exiting the system.\n");
                exit(0);
            default:
                printf("Invalid choice! Try again.\n");
        }
    }
}

int main() {
    initializeSeats();
    mainMenu();
    return 0;
}
