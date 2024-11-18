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
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> {
                    Institute institute = entityGenerator.generateFilledInstitute();
                    institutes.add(institute);
                    System.out.println("Успешно сгенерирован случайный " + institute.getName());
                }
                case 2 -> showInstitutes();
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
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showDepartmentsMenu(institute);
                case 2 -> showGroupsMenu(institute);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showDepartmentsMenu(Institute institute) {
        boolean exit = false;
        while (!exit) {
            System.out.println(RETURN_TO_MENU);
            System.out.println(DEPARTMENT_MANAGEMENT_MENU);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showDepartmentsOfInstitute(institute);
                case 2 -> {
                    Department department = entityGenerator.generateDepartment(institute);
                    System.out.println("Кафедра " + department.getName() + " успешно добавлена");
                }
                case 3 -> removeDepartmentFromInstitute(institute);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showGroupsMenu(Institute institute) {
        boolean exit = false;
        while (!exit) {
            System.out.println(RETURN_TO_MENU);
            System.out.println(GROUP_MANAGEMENT_MENU);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showGroupsOfInstitute(institute);
                case 2 -> {
                    Group group = entityGenerator.generateGroup(institute);
                    System.out.println("Группа " + group.getIdNumber() + " успешно добавлена");
                }
                case 3 -> removeGroupFromInstitute(institute);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showDepartmentsOfInstitute(Institute institute) {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institute.getDepartments().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getDepartments().get(i).getName());
        }
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
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showTeachersOfDepartment(department);
                case 2 -> {
                    Teacher teacher = entityGenerator.generateTeacher(department);
                    System.out.println("Преподаватель " + teacher.getFullName() + " успешно добавлен");
                }
                case 3 -> removeTeacherFromDepartment(department);
                default -> System.out.println(WRONG_OPTION);
            }
        }
    }

    private static void showGroupsOfInstitute(Institute institute) {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institute.getGroups().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getGroups().get(i).getIdNumber());
        }
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
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showStudentsOfGroup(group);
                case 2 -> {
                    Student student = entityGenerator.generateStudent(group);
                    System.out.println("Студент" + student.getFullName() + " успешно добавлен");
                }
                case 3 -> removeStudentFromGroup(group);
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

    private static void removeDepartmentFromInstitute(Institute institute) {
        System.out.println("Выберите кафедру для удаления:");
        for (int i = 0; i < institute.getDepartments().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getDepartments().get(i).getName());
        }
        System.out.println(RETURN_TO_MENU);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= institute.getDepartments().size()) {
            institute.getDepartments().remove(choice - 1);
            System.out.println("Кафедра успешно удалена");
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static void removeGroupFromInstitute(Institute institute) {
        System.out.println("Выберите группу для удаления:");
        for (int i = 0; i < institute.getGroups().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getGroups().get(i).getIdNumber());
        }
        System.out.println(RETURN_TO_MENU);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= institute.getGroups().size()) {
            institute.getGroups().remove(choice - 1);
            System.out.println("Группа успешно удалена");
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static void removeTeacherFromDepartment(Department department) {
        System.out.println("Выберите преподавателя для удаления:");
        for (int i = 0; i < department.getTeachers().size(); i++) {
            System.out.println((i + 1) + ". " + department.getTeachers().get(i).getFullName());
        }
        System.out.println(RETURN_TO_MENU);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= department.getTeachers().size()) {
            department.getTeachers().remove(choice - 1);
            System.out.println("Преподаватель успешно удален");
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static void removeStudentFromGroup(Group group) {
        System.out.println("Выберите студента для удаления:");
        for (int i = 0; i < group.getStudents().size(); i++) {
            System.out.println((i + 1) + ". " + group.getStudents().get(i).getFullName());
        }
        System.out.println(RETURN_TO_MENU);
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= group.getStudents().size()) {
            group.getStudents().remove(choice - 1);
            System.out.println("Студент успешно удален");
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    private static int handleIntInput() {
        System.out.println(SELECT_OPTION);
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
