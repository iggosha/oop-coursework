package ru.zhukov;

import ru.zhukov.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private ConsoleMenu() {
    }

    private static final EntityGenerator entityGenerator = new EntityGenerator();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Institute> institutes = new ArrayList<>();
    private static final String SELECT_OPTION = "Выберите опцию: ";
    private static final String WRONG_OPTION = "Неверный выбор. Пожалуйста, попробуйте снова.";
    private static final String RETURN_TO_MENU = "0. Вернуться в меню";
    private static final String RETURNING = "Возврат в меню";

    public static void startWithMainMenu() {
        System.out.println("Добро пожаловать в АИС 'Система образования'");
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    
                    Главное меню:
                    1. Добавить институт со случайными данными
                    2. Просмотреть список институтов
                    3. Завершить работу""");
            System.out.print(SELECT_OPTION);
            switch (handleIntInput()) {
                case 1 -> {
                    institutes.add(entityGenerator.generateRandomInstitute());
                    System.out.println("Успешно сгенерирован случайный институт");
                }
                case 2 -> showInstitutes();
                case 3 -> exit = true;
                default -> System.out.println(WRONG_OPTION);
            }
        }
        System.out.println("Спасибо, до свидания!");
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
            System.out.println("""
                    1. Просмотреть кафедры
                    2. Просмотреть группы
                    3. Вернуться в главное меню""");
            System.out.print(SELECT_OPTION);
            int choice = handleIntInput(); // Считываем оставшийся символ новой строки
            switch (choice) {
                case 1 -> showDepartmentsOfInstitute(institute);
                case 2 -> showGroupsOfInstitute(institute);
                case 3 -> exit = true;
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
            System.out.println("1. Просмотреть преподавателей");
            System.out.println("2. Вернуться в меню института");
            System.out.print(SELECT_OPTION);
            int choice = handleIntInput();
            switch (choice) {
                case 1 -> showTeachersOfDepartment(department);
                case 2 -> exit = true;
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
            System.out.println("1. Просмотреть студентов");
            System.out.println("2. Вернуться в меню института");
            System.out.print(SELECT_OPTION);
            int choice = handleIntInput();
            switch (choice) {
                case 1 -> showStudentsOfGroup(group);
                case 2 -> exit = true;
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
        return Integer.parseInt(scanner.nextLine());
    }
}
