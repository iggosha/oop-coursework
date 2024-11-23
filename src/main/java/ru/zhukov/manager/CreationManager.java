package ru.zhukov.manager;

import ru.zhukov.entity.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static ru.zhukov.Main.scanner;
import static ru.zhukov.manager.InputConstants.*;

public class CreationManager {

    public Institute createInstitute() {
        System.out.println(INPUT_INSTITUTE_NAME);
        String name = scanner.nextLine();
        List<Department> departments = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        return new Institute(name, departments, groups);
    }

    public Department createDepartment(Institute institute) {
        System.out.println(INPUT_DEPARTMENT_NAME);
        String name = scanner.nextLine();
        List<Teacher> teachers = new ArrayList<>();
        return new Department(institute, name, teachers);
    }

    public Group createGroup(Institute institute) {
        System.out.println(INPUT_GROUP_ID_NUMBER);
        String idNumber = scanner.nextLine();
        System.out.println(INPUT_GROUP_SPECIALIZATION);
        String specialization = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        return new Group(idNumber, institute, specialization, students);
    }

    public Teacher createTeacher(Department department) {
        System.out.println(INPUT_TEACHER_FULL_NAME);
        String fullName = scanner.nextLine();
        System.out.println(INPUT_TEACHER_PHONE_NUMBER);
        String phoneNumber = scanner.nextLine();
        System.out.println(INPUT_TEACHER_DATE_OF_BIRTH);
        LocalDate dateOfBirth = handleDateInput();
        System.out.println(INPUT_TEACHER_ADDRESS);
        String address = scanner.nextLine();
        System.out.println(INPUT_TEACHER_SPECIALIZATION);
        String specialization = scanner.nextLine();
        System.out.println(INPUT_TEACHER_ACADEMIC_DEGREE);
        String academicDegree = scanner.nextLine();
        return new Teacher(fullName, phoneNumber, dateOfBirth, address, academicDegree, department, specialization);
    }

    public Student createStudent(Group group) {
        System.out.println(INPUT_STUDENT_FULL_NAME);
        String fullName = scanner.nextLine();
        System.out.println(INPUT_STUDENT_PHONE_NUMBER);
        String phoneNumber = scanner.nextLine();
        System.out.println(INPUT_STUDENT_DATE_OF_BIRTH);
        LocalDate dateOfBirth = handleDateInput();
        System.out.println(INPUT_STUDENT_ADDRESS);
        String address = scanner.nextLine();
        System.out.println(INPUT_STUDENT_ID_NUMBER);
        String idNumber = scanner.nextLine();
        return new Student(fullName, phoneNumber, dateOfBirth, address, group, idNumber);
    }

    private LocalDate handleDateInput() {
        try {
            String updatedDateStringValue = scanner.nextLine();
            if (updatedDateStringValue.isBlank()) {
                System.err.println(INPUT_CORRECT_DATE);
                return handleDateInput();
            }
            return LocalDate.parse(updatedDateStringValue);
        } catch (DateTimeParseException e) {
            System.err.println(INPUT_CORRECT_DATE);
            return handleDateInput();
        }
    }
}
