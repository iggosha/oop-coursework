package ru.zhukov.entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Department {

    private String name;
    // Содержит преподавателей
    private List<Teacher> teachers;
    // Относится к институту
    private Institute institute;

    @Override
    public String toString() {
        String teachersNames = teachers != null && !teachers.isEmpty() ?
                teachers.stream()
                        .map(Teacher::getFullName)
                        .collect(Collectors.joining(", "))
                : "Нет преподавателей";
        String instituteName = institute != null ?
                institute.getName()
                : "Нет института";

        return "Кафедра{" +
                "название='" + name + '\'' +
                ", преподаватели=" + teachersNames +
                ", институт=" + instituteName +
                '}';
    }
}