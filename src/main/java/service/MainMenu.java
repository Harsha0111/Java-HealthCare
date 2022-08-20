package service;

import model.Appointment;
import model.Doctor;
import model.HealthIssue;
import model.User;

import utils.HealthIssueUtils;
import utils.UsersUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface {
    private HealthIssueUtils healthIssuesUtils;
    private Auth auth;

    private UsersUtils usersUtils;

    public MainMenu(HealthIssueUtils healthIssueUtils, Auth auth, UsersUtils usersUtils) {
        this.auth = auth;
        this.healthIssuesUtils = healthIssueUtils;
        this.usersUtils = usersUtils;
    }

    @Override
    public void printMenu() {
        System.out.println("1. Book Appointment");
        System.out.println("2. View Booking");
        System.out.println("3. Logout");
        System.out.println("Enter your choice");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            ArrayList<HealthIssue> healthIssues = healthIssuesUtils.getHealthIssues();

            healthIssues.forEach(healthIssue -> {
                System.out.println(healthIssue.getId() + ". " + healthIssue.getName());
            });

            System.out.println("Enter your choice:");
            int healthIssueChoice = scanner.nextInt();

            if (healthIssueChoice <= healthIssues.size()) {
                HealthIssue selectedHealthIssue = healthIssues.get(healthIssueChoice - 1);

                ArrayList<Doctor> doctors = selectedHealthIssue.getDoctors();

                doctors.forEach(doctor -> {
                    System.out.println(doctor.getId() + ". " + doctor.getDoctorsName());
                });

                System.out.println("Enter your choice:");
                int doctorChoice = scanner.nextInt();
                if (doctorChoice <= doctors.size()) {
                    Doctor selectedDoctor = doctors.get(doctorChoice - 1);
                    System.out.println("Are you sure you wanna book appointment with " +
                            selectedDoctor.getDoctorsName() + " for " + selectedHealthIssue.getName());

                    System.out.println("1. yes");
                    System.out.println("2. No");
                    System.out.println("Enter your choice:");
                    int confirmationChoice = scanner.nextInt();
                    if (confirmationChoice == 1) {
                        Appointment appointment = new Appointment();
                        appointment.setDate(new Date());
                        appointment.setHealthIssue(selectedHealthIssue.getName());
                        appointment.setDoctor(selectedDoctor.getDoctorsName());

                        User loggedInUser = usersUtils.getLoggedInUser();

                        ArrayList<Appointment> appointments = loggedInUser.getAppointments();
                        appointments.add(appointment);
                        System.out.println("Booked Appointment");
                        printMenu();

                    } else if (confirmationChoice == 2) {
                        printMenu();
                    } else {
                        System.out.println("Invalid Choice");
                        printMenu();
                    }

                } else {
                    System.out.println("Invalid Choice");
                    printMenu();
                }
            } else {
                System.out.println("Invalid Choice");
                printMenu();
            }

        } else if (choice == 2) {

            ArrayList<Appointment> appointments = usersUtils.getLoggedInUser().getAppointments();
            if (appointments.size() > 0) {
                appointments.forEach(appointment -> {
                    System.out.println("Health Issue " + appointment.getHealthIssue());
                    System.out.println("Doctor" + appointment.getDoctor());
                    System.out.println("Date" + appointment.getDate());
                    System.out.println("------------------------");
                });
                printMenu();
            } else {
                System.out.println("No Appointments");
                printMenu();
            }

        } else if (choice == 3) {
            System.exit(0);
        } else {
            System.out.println("Invalid choice");
        }
    }
}
