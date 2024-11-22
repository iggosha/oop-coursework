package ru.zhukov.manager;

import ru.zhukov.entity.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static ru.zhukov.Main.scanner;
import static ru.zhukov.menu.MenuConstants.SKIP_INPUT;

public class EditingManager {

    public void editGroup(Group group) {
        System.out.println(SKIP_INPUT);
        System.out.println("Введите новый номер группы:");
        String newIdNumber = scanner.nextLine();
        if (!newIdNumber.isBlank()) {
            group.setIdNumber(newIdNumber);
            System.out.println("Номер группы успешно изменен на " + newIdNumber);
        }

        System.out.println("Введите новую специализацию группы:");
        String newSpecialization = scanner.nextLine();
        if (!newSpecialization.isBlank()) {
            group.setSpecialization(newSpecialization);
            System.out.println("Специализация группы успешно изменена на " + newSpecialization);
        }
    }

    public void editInstitute(Institute institute) {
        System.out.println(SKIP_INPUT);
        System.out.println("Введите новое название института:");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            institute.setName(newName);
            System.out.println("Название института успешно изменено на " + newName);
        }
    }

    public void editDepartment(Department department) {
        System.out.println(SKIP_INPUT);
        System.out.println("Введите новое название кафедры:");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            department.setName(newName);
            System.out.println("Название кафедры успешно изменено на " + newName);
        }
    }

    public void editStudent(Student student) {
        System.out.println(SKIP_INPUT);
        System.out.println("Введите новое полное имя студента:");

        String newFullName = scanner.nextLine();

        if (!newFullName.isBlank()) {
            student.setFullName(newFullName);
            System.out.println("Полное имя студента успешно изменено на " + newFullName);
        }

        System.out.println("Введите новый номер телефона студента:");
        String newPhoneNumber = scanner.nextLine();
        if (!newPhoneNumber.isBlank()) {
            student.setPhoneNumber(newPhoneNumber);
            System.out.println("Номер телефона студента успешно изменен на " + newPhoneNumber);
        }

        System.out.println("Введите новую дату рождения студента (ГГГГ-ММ-ДД):");
        LocalDate newDateOfBirth = handleDateInput();
        if (newDateOfBirth != null) {
            student.setDateOfBirth(newDateOfBirth);
            System.out.println("Дата рождения студента успешно изменена на " + newDateOfBirth);
        }

        System.out.println("Введите новый адрес студента:");
        String newAddress = scanner.nextLine();

        if (!newAddress.isBlank()) {
            student.setAddress(newAddress);
            System.out.println("Адрес студента успешно изменен на " + newAddress);
        }

        System.out.println("Введите новый номер зачётки студента:");
        String newIdNumber = scanner.nextLine();
        if (!newIdNumber.isBlank()) {
            student.setIdNumber(newIdNumber);
            System.out.println("Номер зачётки студента успешно изменен на " + newIdNumber);
        }
    }

    public void editTeacher(Teacher teacher) {
        System.out.println(SKIP_INPUT);
        System.out.println("Введите новое полное имя преподавателя:");
        String newFullName = scanner.nextLine();
        if (!newFullName.isBlank()) {
            teacher.setFullName(newFullName);
            System.out.println("Полное имя преподавателя успешно изменено на " + newFullName);
        }

        System.out.println("Введите новый номер телефона преподавателя:");
        String newPhoneNumber = scanner.nextLine();
        if (!newPhoneNumber.isBlank()) {
            teacher.setPhoneNumber(newPhoneNumber);
            System.out.println("Номер телефона преподавателя успешно изменен на " + newPhoneNumber);
        }

        System.out.println("Введите новую дату рождения преподавателя (ГГГГ-ММ-ДД):");
        LocalDate newDateOfBirth = handleDateInput();
        if (newDateOfBirth != null) {
            teacher.setDateOfBirth(newDateOfBirth);
            System.out.println("Дата рождения преподавателя успешно изменена на " + newDateOfBirth);
        }

        System.out.println("Введите новый адрес преподавателя:");
        String newAddress = scanner.nextLine();
        if (!newAddress.isBlank()) {
            teacher.setAddress(newAddress);
            System.out.println("Адрес преподавателя успешно изменен на " + newAddress);
        }

        System.out.println("Введите новую специализацию преподавателя:");
        String newSpecialization = scanner.nextLine();
        if (!newSpecialization.isBlank()) {
            teacher.setSpecialization(newSpecialization);
            System.out.println("Специализация преподавателя успешно изменена на " + newSpecialization);
        }

        System.out.println("Введите новую ученую степень преподавателя:");
        String newAcademicDegree = scanner.nextLine();
        if (!newAcademicDegree.isBlank()) {
            teacher.setAcademicDegree(newAcademicDegree);
            System.out.println("Ученая степень преподавателя успешно изменена на " + newAcademicDegree);
        }
    }

    private LocalDate handleDateInput() {
        try {
            String updatedDateStringValue = scanner.nextLine();
            if (updatedDateStringValue.isBlank()) {
                return null;
            }
            return LocalDate.parse(updatedDateStringValue);
        } catch (DateTimeParseException e) {
            System.err.println("Пожалуйста, введите корректную дату.");
            return handleDateInput();
        }
    }
}
