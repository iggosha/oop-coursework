package ru.zhukov.entity;

import lombok.Data;

@Data
public class Student extends Human {

    private String idNumber;
    // Относится к группе
    private Group group;

    @Override
    public String toString() {
        String groupId = group != null ?
                group.getIdNumber()
                : "Нет группы";

        return "Студент{" +
                "полное имя='" + getFullName() + '\'' +
                ", номер телефона='" + getPhoneNumber() + '\'' +
                ", дата рождения=" + getDateOfBirth() +
                ", адрес='" + getAddress() + '\'' +
                ", номер='" + idNumber + '\'' +
                ", группа=" + groupId +
                '}';
    }
}