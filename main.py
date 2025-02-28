class Flight:
    def __init__(self, flight_number, origin, destination, seats):
        self.flight_number = flight_number
        self.origin = origin
        self.destination = destination
        self.seats = seats  # Dictionary of seat number and availability
        self.passenger_list = {}

    def book_seat(self, passenger_name, seat_number):
        if seat_number in self.seats and self.seats[seat_number] == "Available":
            self.seats[seat_number] = "Booked"
            self.passenger_list[seat_number] = passenger_name
            print(f"Seat {seat_number} successfully booked for {passenger_name}.")
        else:
            print("Seat is already booked or does not exist!")

    def cancel_booking(self, seat_number):
        if seat_number in self.passenger_list:
            print(f"Booking for {self.passenger_list[seat_number]} on seat {seat_number} has been canceled.")
            del self.passenger_list[seat_number]
            self.seats[seat_number] = "Available"
        else:
            print("No booking found for this seat!")

    def display_seats(self):
        print("Seat Availability:")
        for seat, status in self.seats.items():
            print(f"Seat {seat}: {status}")


def main():
    flight = Flight("AI101", "New York", "Los Angeles", {1: "Available", 2: "Available", 3: "Available"})
    
    while True:
        print("\nAirline Reservation System")
        print("1. Book a Seat")
        print("2. Cancel Booking")
        print("3. View Seat Availability")
        print("4. Exit")
        
        choice = input("Enter your choice: ")
        
        if choice == "1":
            name = input("Enter passenger name: ")
            seat = int(input("Enter seat number: "))
            flight.book_seat(name, seat)
        elif choice == "2":
            seat = int(input("Enter seat number to cancel: "))
            flight.cancel_booking(seat)
        elif choice == "3":
            flight.display_seats()
        elif choice == "4":
            print("Exiting system. Thank you!")
            break
        else:
            print("Invalid choice, please try again.")

if __name__ == "__main__":
    main()
