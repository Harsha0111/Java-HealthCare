package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String name;
    private int password;
    private int age;
    private int height;
    private int weight;
    private ArrayList<Appointment> appointments = new ArrayList<>();
}
