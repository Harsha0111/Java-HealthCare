import java.util.ArrayList;
import java.util.Scanner;

public class HealthCare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("REGISTRATION DETAILS: ");
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Weight: ");
        int weight = scanner.nextInt();
        System.out.println("Height: ");
        int height = scanner.nextInt();
        System.out.println("LOGIN DETAILS: ");
        System.out.println("ENTER YOUR NAME: ");
        String username = scanner.next();
        System.out.println("ENTER YOUR PASSWORD: ");
        int password = scanner.nextInt();

        System.out.println("SELECT YOUR HEALTH ISSUE");
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient(name, age, weight, height));
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<HealthIssue> healthIssues = new ArrayList<>();
        healthIssues.add(new HealthIssue(1, "heart"));
        healthIssues.add(new HealthIssue(2, "ent"));
        healthIssues.forEach(healthIssue -> {
            System.out.println(healthIssue.getId() + ". " + healthIssue.getIssue());
        });
        int healthissue = scanner1.nextInt();


        System.out.println("Enter your Doctor Choice: ");
        ArrayList<DoctorChoice> doctorChoices = new ArrayList<>();
        doctorChoices.add(new DoctorChoice(1, "Dr.Abi"));
        doctorChoices.add(new DoctorChoice(2, "Dr.Sri"));

        doctorChoices.forEach(doctorChoice -> {
            System.out.println(doctorChoice.getId() + ". " + doctorChoice.getChoice());
        });

        int healthChoice = scanner.nextInt();
        HealthIssue selectedChoice = healthIssues.get(healthChoice - 1);

        System.out.println("Thank You and Have a Good Day!!");
    }
}
