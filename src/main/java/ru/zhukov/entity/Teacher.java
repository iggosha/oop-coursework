package ru.zhukov.entity;

import lombok.Data;

@Data
public class Teacher extends Human {

    private String specialization;
    private String academicDegree;
    // Относится к кафедре
    private Department department;


    @Override
    public String toString() {
        String departmentName = department != null ?
                department.getName()
                : "Нет кафедры";

        return "Преподаватель{" +
                "полное имя='" + getFullName() + '\'' +
                ", номер телефона='" + getPhoneNumber() + '\'' +
                ", дата рождения=" + getDateOfBirth() +
                ", адрес='" + getAddress() + '\'' +
                ", специализация='" + specialization + '\'' +
                ", ученая степень='" + academicDegree + '\'' +
                ", кафедра=" + departmentName +
                '}';
    }
}