package ru.zhukov.entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Group {

    private String idNumber;
    private String specialization;
    // Содержит студентов
    private List<Student> students;
    // Относится к институту
    private Institute institute;

    public Group(String idNumber, Institute institute, String specialization, List<Student> students) {
        setIdNumber(idNumber);
        setInstitute(institute);
        setSpecialization(specialization);
        setStudents(students);

        institute.getGroups().add(this);
        students.forEach(student -> student.setGroup(this));
    }

    @Override
    public String toString() {
        String studentsNames = students != null && !students.isEmpty() ?
                students.stream()
                        .map(Student::getFullName)
                        .collect(Collectors.joining(", "))
                : "Нет студентов";
        String instituteName = institute != null ?
                institute.getName()
                : "Нет института";

        return "\nГруппа -" +
                " Номер: " + idNumber +
                ", Специализация: " + specialization +
                ", \nИмена студентов: " + studentsNames +
                ", \nНазвание института: " + instituteName;
    }
}