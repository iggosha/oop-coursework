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

        return "Группа{" +
                "номер='" + idNumber + '\'' +
                ", специализация='" + specialization + '\'' +
                ", студенты=" + studentsNames +
                ", институт=" + instituteName +
                '}';
    }
}