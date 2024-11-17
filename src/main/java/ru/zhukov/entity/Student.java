package ru.zhukov.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Human {

    private String idNumber;
    // Относится к группе
    private Group group;

    public Student(String fullName,
                   String phoneNumber,
                   LocalDate dateOfBirth,
                   String address,
                   Group group,
                   String idNumber) {
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setIdNumber(idNumber);
        setGroup(group);

        group.getStudents().add(this);
    }

    @Override
    public String toString() {
        String groupId = group != null ?
                group.getIdNumber()
                : "Нет группы";

        return "\nСтудент - " +
                "Полное имя: " + getFullName() +
                ", Номер телефона: " + getPhoneNumber() +
                ", Дата рождения: " + getDateOfBirth() +
                ", Адрес: " + getAddress() +
                ", Номер зачётки: " + getIdNumber() +
                ", Номер группы: " + groupId;
    }
}