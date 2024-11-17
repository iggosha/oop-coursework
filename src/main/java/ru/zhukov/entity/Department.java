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

    public Department(Institute institute, String name, List<Teacher> teachers) {
        setInstitute(institute);
        setName(name);
        setTeachers(teachers);

        institute.getDepartments().add(this);
        teachers.forEach(teacher -> teacher.setDepartment(this));
    }

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

        return "\nКафедра - " +
                " Название: " + name +
                ", Имена преподавателей: " + teachersNames +
                ", Название института: " + instituteName;
    }
}