import java.util.ArrayList;
import java.util.Scanner;

public class HealthCare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Weight: ");
        int weight = scanner.nextInt();
        System.out.println("Height: ");
        int height = scanner.nextInt();

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient(name, age, weight, height));

        System.out.println("SELECT YOUR HEALTH ISSUES :");

        ArrayList<HealthIssue> healthIssues = new ArrayList<>();
        healthIssues.add(new HealthIssue(1, "heart"));
        healthIssues.add(new HealthIssue(2, "ent"));

        healthIssues.forEach(healthIssue -> {
            System.out.println(healthIssue.getId() + ". " + healthIssue.getIssue());
        });
        System.out.println("Enter your choice: ");
        int healthChoice = scanner.nextInt();
        HealthIssue selectedChoice=healthIssues.get(healthChoice-1);

        System.out.println("REMEDIES TO BE FOLLOWED:" + "\n"
                + "*Morning Walk: 1 HRS" + "\n");

        System.out.println("Thank You and Have a Good Day!!");
    }
}
