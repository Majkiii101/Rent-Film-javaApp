# Rent-Film-javaApp

This is a Java application for managing a film rental service. The application features a graphical user interface (GUI) utilizes a MySQL database to store information about films, customers, rentals, and more.

Usage:

To run this app first you have to create a database in MySql called: "wypozyczalnia". After that you simply compile and run the application from your IDE. 
When it's done, you will be greated with first menu:

![obraz](https://github.com/Majkiii101/Rent-Film-javaApp/assets/52582634/d35c6707-4096-46d5-ac7f-b0860ee8e48e)

Before you start using application you have to click first "Dodaj potrzebne tabele" button so that app create necessary tabels to run propely.

1. Logowanie - is used to sign in (there are two types of accounts: employee - already created (default login - 000000 / password - admin) and client - created in register menu by user)
2. rejestracja - is used to sign up (there will be automatically generated ID number as your login)

Employee:

- add new films to the database and edit them

Client:

- rent/buys films
- returns rented films
