package ru.zhukov;

import ru.zhukov.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class EntityGenerator {

    private static final Random random = new Random();
    private static final String[] FIRST_NAMES = {"Иван", "Петр", "Алексей", "Дмитрий", "Сергей"};
    private static final String[] LAST_NAMES = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов"};
    private static final String[] SPECIALIZATIONS = {"Информатика", "Математика", "Физика", "Химия", "Биология"};
    private static final String[] ACADEMIC_DEGREES = {"Доктор наук", "Кандидат наук", "Магистр", "Бакалавр"};
    private static final String[] ADDRESSES = {"Москва", "Санкт-Петербург", "Казань", "Новосибирск", "Екатеринбург"};
    private static final String[] INSTITUTE_NAMES = {"Институт инженерных и цифровых технологий",
            "Юридический институт", "Педагогический институт", "Медицинский институт", "Институт наук о Земле"};
    private static final String[] DEPARTMENT_NAMES = {"Кафедра математического и программного обеспечения информационных систем",
            "Кафедра прикладной информатики и информационных технологий", "Кафедра материаловедения и нанотехнологий",
            "Кафедра информационных и робототехнических систем", "Кафедра автоматизированных систем и технологий"};


    public Institute generateRandomInstitute() {
        Institute institute = createInstitute();
        Department department = createDepartment(institute);
        Group group = createGroup(institute);
        createStudent(group);
        createTeacher(department);
        return institute;
    }

    private Teacher createTeacher(Department department) {
        String teacherFullName = generateRandomName();
        String teacherPhoneNumber = generateRandomPhoneNumber();
        LocalDate teacherDateOfBirth = generateRandomDateOfBirth();
        String teacherAddress = getRandomArrayElement(ADDRESSES);
        String teacherSpecialization = getRandomArrayElement(SPECIALIZATIONS);
        String teacherAcademicDegree = getRandomArrayElement(ACADEMIC_DEGREES);
        return new Teacher(teacherFullName, teacherPhoneNumber, teacherDateOfBirth,
                teacherAddress, teacherAcademicDegree, department, teacherSpecialization);
    }

    private Student createStudent(Group group) {
        String studentFullName = generateRandomName();
        String studentPhoneNumber = generateRandomPhoneNumber();
        LocalDate studentDateOfBirth = generateRandomDateOfBirth();
        String studentAddress = getRandomArrayElement(ADDRESSES);
        String studentIdNumber = String.valueOf(random.nextInt(100000) + 100000);
        return new Student(studentFullName, studentPhoneNumber, studentDateOfBirth,
                studentAddress, group, studentIdNumber);
    }

    private Group createGroup(Institute institute) {
        String groupIdNumber = String.valueOf(random.nextInt(100000) + 100000);
        String groupSpecialization = getRandomArrayElement(SPECIALIZATIONS);
        return new Group(groupIdNumber, institute, groupSpecialization, new ArrayList<>());
    }

    private Department createDepartment(Institute institute) {
        String departmentName = getRandomArrayElement(DEPARTMENT_NAMES);
        return new Department(institute, departmentName, new ArrayList<>());
    }

    private Institute createInstitute() {
        String instituteName = getRandomArrayElement(INSTITUTE_NAMES);
        return new Institute(instituteName, new ArrayList<>(), new ArrayList<>());
    }

    private String generateRandomName() {
        return getRandomArrayElement(FIRST_NAMES) + " " + getRandomArrayElement(LAST_NAMES);
    }

    private LocalDate generateRandomDateOfBirth() {
        int year = 1980 + random.nextInt(25);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return LocalDate.of(year, month, day);
    }

    private String generateRandomPhoneNumber() {
        return "+79" + random.nextInt(100000000);
    }

    private <T> T getRandomArrayElement(T[] array) {
        return array[random.nextInt(array.length)];
    }
}
