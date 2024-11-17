package ru.zhukov.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Teacher extends Human {

    private String specialization;
    private String academicDegree;
    // Относится к кафедре
    private Department department;

    public Teacher(String fullName,
                   String phoneNumber,
                   LocalDate dateOfBirth,
                   String address,
                   String academicDegree,
                   Department department,
                   String specialization) {
        this.setFullName(fullName);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
        this.setAddress(address);
        this.setAcademicDegree(academicDegree);
        this.setDepartment(department);
        this.setSpecialization(specialization);
        department.getTeachers().add(this);
    }

    @Override
    public String toString() {
        String departmentName = department != null ?
                department.getName()
                : "Нет кафедры";

        return "\nПреподаватель - " +
                "Полное имя: " + getFullName() +
                ", Номер телефона: " + getPhoneNumber() +
                ", Дата рождения: " + getDateOfBirth() +
                ", Адрес: " + getAddress() +
                ", Специализация: " + getSpecialization() +
                ", Ученая степень: " + getAcademicDegree() +
                ", Название кафедры: " + departmentName;
    }
}