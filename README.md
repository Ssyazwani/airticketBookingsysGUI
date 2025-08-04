# GUI Project
Mini Project for ET0885

Develop an Air-ticket Booking System in Java.

Core Features (Minimum Viable Product, MVP)
The following features are crucial for a minimum viable product (MVP). Failure to implement
these will result in not passing the project:

## User Side:
1. User Registration and Login: Allow users to create an account and log in to access the booking
functionality.
2. Flight Listing: Display a list of available flights with details like airline, departure time, arrival
time, and price.
3. Booking Process: Guide users through the booking process, including passenger details,
payment, and confirmation.
4. Booking Management: Allow users to view and manage their booked tickets, including
cancelling bookings.
5. Ticket Confirmation: Print booking confirmation with the ticket details and a unique ticket
number.

## Mapping For User Side:
1. MainGui(1) -> RegisterGui(1)
2. MainGui(1) -> DisplayFlightgui (2) -> BookGui(3) -> BookManagementGUI (4&5)

## Admin Side:
1. Admin Panel: Provide an admin panel with secure access for managing flights, users, and
bookings.
2. Flight Management: Allow admins to add, update, or delete flights, manage seat availability, and
adjust prices.
3. User Management: Enable admins to view and manage user accounts, including user details and
account status.

(In Progress)
## Mapping For Admin Side:
1. AdminGUI(1) -> AdminNaviGUI -> FlightAdminGUI(2) -> FlightFormDialog(2)

2. AdminGUI(1) -> AdminNaviGUI -> UserAdminGUI(3) -> UserFormDialog(3)


Consider to have:
Search: Support searching for flights based on source, destination, 
and date with available
seats.
 Return ticket booking
