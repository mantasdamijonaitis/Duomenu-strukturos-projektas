/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskreciosprojektas;

import java.util.Comparator;

/**
 *
 * @author mantas.damijonaitis
 */
public class Student implements Comparable<Student> {

    private String name;
    private String surname;
    private String group;
    private String university;
    private String speciality;

    public Student() {

    }

    public Student(String Name, String Surname, String Group, String University, String Speciality) {
        this.name = Name;
        this.surname = Surname;
        this.group = Group;
        this.university = University;
        this.speciality = Speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String Group) {
        this.group = Group;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String University) {
        this.university = University;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String Speciality) {
        this.speciality = Speciality;
    }

    @Override
    public String toString() {
        return "Name: " + name + " surname: " + surname
                + " group: " + group + " university: " + university
                + " faculty: " + speciality;
    }

    @Override
    public int compareTo(Student o) {
        if (o == null) {
            return 0;
        }
        if (name.compareTo(o.name) != 0) {
            return name.compareTo(o.name);
        }
        if (surname.compareTo(o.surname) != 0) {
            return surname.compareTo(o.surname);
        }
        if (group.compareTo(o.group) != 0) {
            return group.compareTo(o.group);
        }
        if (university.compareTo(o.university) != 0) {
            return university.compareTo(o.university);
        }
        return speciality.compareTo(o.speciality);
    }
}
