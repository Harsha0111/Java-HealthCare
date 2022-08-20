package utils;

import model.Doctor;
import model.HealthIssue;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;

public class HealthIssueUtils {
    private ArrayList<HealthIssue> healthIssues = new ArrayList<>();

    public ArrayList<HealthIssue> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(ArrayList<HealthIssue> healthIssues) {
        this.healthIssues = healthIssues;
    }

    public void load() {
        //Heart
        HealthIssue heartHealthIssue = new HealthIssue();
        heartHealthIssue.setId(1);
        heartHealthIssue.setName("Heart");

        ArrayList<Doctor> heartDoctors = new ArrayList<>();
        heartDoctors.add(new Doctor(1, "Dr.Abi"));
        heartDoctors.add(new Doctor(2, "Dr.Suraj"));
        heartDoctors.add(new Doctor(3, "Dr.Mani"));
        heartDoctors.add(new Doctor(4, "Dr.Priya"));

        heartHealthIssue.setDoctors(heartDoctors);
        healthIssues.add(heartHealthIssue);

        //ENT
        HealthIssue entHealthIssue = new HealthIssue();
        entHealthIssue.setId(2);
        entHealthIssue.setName("Ent");

        ArrayList<Doctor> entDoctors = new ArrayList<>();
        entDoctors.add(new Doctor(1, "Dr.Inba"));
        entDoctors.add(new Doctor(2, "Dr.Mega"));
        entDoctors.add(new Doctor(3, "Dr.Sara"));
        entDoctors.add(new Doctor(4, "Dr.Prasath"));

        entHealthIssue.setDoctors(entDoctors);
        healthIssues.add(entHealthIssue);


    }

}
