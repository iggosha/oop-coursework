package ru.zhukov;

import ru.zhukov.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.zhukov.StringConstants.*;

public class ConsoleMenu {

    private static final EntityGenerator entityGenerator = new EntityGenerator();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Institute> institutes = new ArrayList<>();

    public static void startWithMainMenu() {
        System.out.println("Добро пожаловать в АИС 'Система образования'");
        boolean exit = false;
        while (!exit) {
            System.out.println(MAIN_MENU);
            System.out.println(SELECT_OPTION);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> addRandomInstitute();
                case 2 -> showInstitutes();
                default -> System.out.println(WRONG_OPTION);
            }
        }
        System.out.println("Спасибо, до свидания!");
    }

    private static void addRandomInstitute() {
        institutes.add(entityGenerator.generateRandomInstitute());
        System.out.println("Успешно сгенерирован случайный институт");
    }

    private static void showInstitutes() {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institutes.size(); i++) {
            System.out.println((i + 1) + ". " + institutes.get(i).getName());
        }
        System.out.print(SELECT_OPTION);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= institutes.size()) {
            showInstituteDetails(institutes.get(choice - 1));
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static void showInstituteDetails(Institute institute) {
        boolean exit = false;
        while (!exit) {
            System.out.println(institute);
            System.out.println(RETURN_TO_MENU);
            System.out.println(INSTITUTE_MENU);
            System.out.println(SELECT_OPTION);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showDepartmentsOfInstitute(institute);
                case 2 -> showGroupsOfInstitute(institute);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showDepartmentsOfInstitute(Institute institute) {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institute.getDepartments().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getDepartments().get(i).getName());
        }
        System.out.print(SELECT_OPTION);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= institute.getDepartments().size()) {
            showDepartmentDetails(institute.getDepartments().get(choice - 1));
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static void showDepartmentDetails(Department department) {
        boolean exit = false;
        while (!exit) {
            System.out.println(department);
            System.out.println(RETURN_TO_MENU);
            System.out.println(DEPARTMENT_MENU);
            System.out.println(SELECT_OPTION);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showTeachersOfDepartment(department);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showGroupsOfInstitute(Institute institute) {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institute.getGroups().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getGroups().get(i).getIdNumber());
        }
        System.out.print(SELECT_OPTION);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= institute.getGroups().size()) {
            showGroupDetails(institute.getGroups().get(choice - 1));
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static void showGroupDetails(Group group) {
        boolean exit = false;
        while (!exit) {
            System.out.println(group);
            System.out.println(RETURN_TO_MENU);
            System.out.println(GROUP_MENU);
            System.out.println(SELECT_OPTION);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showStudentsOfGroup(group);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showStudentsOfGroup(Group group) {
        for (Student student : group.getStudents()) {
            System.out.println(student);
        }
    }

    private static void showTeachersOfDepartment(Department department) {
        for (Teacher teacher : department.getTeachers()) {
            System.out.println(teacher);
        }
    }

    private static int handleIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста, введите корректное число.");
            return handleIntInput();
        }
    }

    private ConsoleMenu() {
    }
}
