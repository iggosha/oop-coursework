package ru.zhukov;

import ru.zhukov.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static ru.zhukov.StringConstants.*;

public class EntityGenerator {

    private static final Random random = new Random();

    public Institute generateFilledInstitute() {
        Institute institute = generateInstitute();
        for (int i = 0; i < 2; i++) {
            Department department = generateDepartment(institute);
            for (int j = 0; j < 2; j++) {
                generateTeacher(department);
            }
            Group group = generateGroup(institute);
            for (int j = 0; j < 2; j++) {
                generateStudent(group);
            }
        }
        return institute;
    }

    public Department generateDepartment(Institute institute) {
        String departmentName = getRandomArrayElement(DEPARTMENT_NAMES);
        return new Department(institute, departmentName, new ArrayList<>());
    }

    public Teacher generateTeacher(Department department) {
        String teacherFullName = generateRandomName();
        String teacherPhoneNumber = generateRandomPhoneNumber();
        LocalDate teacherDateOfBirth = generateRandomDateOfBirth();
        String teacherAddress = getRandomArrayElement(ADDRESSES);
        String teacherSpecialization = getRandomArrayElement(SPECIALIZATIONS);
        String teacherAcademicDegree = getRandomArrayElement(ACADEMIC_DEGREES);
        return new Teacher(teacherFullName, teacherPhoneNumber, teacherDateOfBirth,
                teacherAddress, teacherAcademicDegree, department, teacherSpecialization);
    }

    public Student generateStudent(Group group) {
        String studentFullName = generateRandomName();
        String studentPhoneNumber = generateRandomPhoneNumber();
        LocalDate studentDateOfBirth = generateRandomDateOfBirth();
        String studentAddress = getRandomArrayElement(ADDRESSES);
        String studentIdNumber = String.valueOf(random.nextInt(100000) + 10000);
        return new Student(studentFullName, studentPhoneNumber, studentDateOfBirth,
                studentAddress, group, studentIdNumber);
    }

    public Group generateGroup(Institute institute) {
        String groupIdNumber = String.valueOf(random.nextInt(100000) + 10000);
        String groupSpecialization = getRandomArrayElement(SPECIALIZATIONS);
        return new Group(groupIdNumber, institute, groupSpecialization, new ArrayList<>());
    }

    public Institute generateInstitute() {
        String instituteName = getRandomArrayElement(INSTITUTE_NAMES);
        return new Institute(instituteName, new ArrayList<>(), new ArrayList<>());
    }

    public String generateRandomName() {
        return getRandomArrayElement(FIRST_NAMES) + " " + getRandomArrayElement(LAST_NAMES);
    }

    public LocalDate generateRandomDateOfBirth() {
        int year = 1980 + random.nextInt(25);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return LocalDate.of(year, month, day);
    }

    public String generateRandomPhoneNumber() {
        return "+793" + random.nextInt(100000000);
    }

    public <T> T getRandomArrayElement(T[] array) {
        return array[random.nextInt(array.length)];
    }
}
