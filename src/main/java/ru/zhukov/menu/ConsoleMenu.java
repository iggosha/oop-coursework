package ru.zhukov.menu;

import ru.zhukov.entity.*;
import ru.zhukov.manager.EditingManager;
import ru.zhukov.manager.GenerationManager;
import ru.zhukov.manager.RemovingManager;

import java.util.ArrayList;
import java.util.List;

import static ru.zhukov.Main.scanner;
import static ru.zhukov.menu.MenuConstants.*;

public class ConsoleMenu {

    private static final GenerationManager generationManager = new GenerationManager();
    private static final RemovingManager removingManager = new RemovingManager();
    private static final EditingManager editingManager = new EditingManager();
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
                    Institute institute = generationManager.generateFilledInstitute();
                    institutes.add(institute);
                    System.out.println("Успешно сгенерирован случайный " + institute.getName());
                }
                case 2 -> showInstitutes();
                default -> System.err.println(WRONG_OPTION);
            }
        }
        System.out.println("Спасибо, до свидания!");
    }

    private static void showInstitutes() {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institutes.size(); i++) {
            System.out.println((i + 1) + ". " + institutes.get(i).getName());
        }
        if (institutes.isEmpty()) {
            System.err.println("Список институтов пуст");
        }
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= institutes.size()) {
            showInstituteDetails(institutes.get(choice - 1));
        } else {
            System.err.println(WRONG_OPTION);
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
                case 3 -> editingManager.editInstitute(institute);
                default -> System.err.println(WRONG_OPTION);
            }
        }
    }

    private static void showDepartmentsMenu(Institute institute) {
        boolean exit = false;
        while (!exit) {
            System.out.println();
            for (int i = 0; i < institute.getDepartments().size(); i++) {
                System.out.println(institute.getDepartments().get(i).getName());
            }
            System.out.println(RETURN_TO_MENU);
            System.out.println(DEPARTMENT_MANAGEMENT_MENU);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showDepartmentsOfInstitute(institute);
                case 2 -> {
                    Department department = generationManager.generateDepartment(institute);
                    System.out.println("Кафедра " + department.getName() + " успешно добавлена");
                }
                case 3 -> removingManager.removeDepartmentFromInstitute(institute);
                default -> System.err.println(WRONG_OPTION);
            }
        }
    }

    private static void showGroupsMenu(Institute institute) {
        boolean exit = false;
        while (!exit) {
            System.out.println();
            for (int i = 0; i < institute.getGroups().size(); i++) {
                System.out.println(institute.getGroups().get(i).getIdNumber());
            }
            System.out.println(RETURN_TO_MENU);
            System.out.println(GROUP_MANAGEMENT_MENU);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showGroupsOfInstitute(institute);
                case 2 -> {
                    Group group = generationManager.generateGroup(institute);
                    System.out.println("Группа " + group.getIdNumber() + " успешно добавлена");
                }
                case 3 -> removingManager.removeGroupFromInstitute(institute);
                default -> System.err.println(WRONG_OPTION);
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
            System.err.println(WRONG_OPTION);
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
                    Teacher teacher = generationManager.generateTeacher(department);
                    System.out.println("Преподаватель " + teacher.getFullName() + " успешно добавлен");
                }
                case 3 -> removingManager.removeTeacherFromDepartment(department);
                case 4 -> editingManager.editDepartment(department);
                default -> System.err.println(WRONG_OPTION);
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
            System.err.println(WRONG_OPTION);
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
                    Student student = generationManager.generateStudent(group);
                    System.out.println("Студент " + student.getFullName() + " успешно добавлен");
                }
                case 3 -> removingManager.removeStudentFromGroup(group);
                case 4 -> editingManager.editGroup(group);
                default -> System.err.println(WRONG_OPTION);
            }
        }
    }


    private static void showTeachersOfDepartment(Department department) {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < department.getTeachers().size(); i++) {
            System.out.println((i + 1) + ". " + department.getTeachers().get(i).getFullName());
        }
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= department.getTeachers().size()) {
            showTeacherDetails(department.getTeachers().get(choice - 1));
        } else {
            System.err.println(WRONG_OPTION);
        }
    }

    private static void showTeacherDetails(Teacher teacher) {
        boolean exit = false;
        while (!exit) {
            System.out.println(teacher);
            System.out.println(RETURN_TO_MENU);
            System.out.println(TEACHER_MENU);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> editingManager.editTeacher(teacher);
                default -> System.err.println(WRONG_OPTION);
            }
        }
    }

    private static void showStudentsOfGroup(Group group) {
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < group.getStudents().size(); i++) {
            System.out.println((i + 1) + ". " + group.getStudents().get(i).getFullName());
        }
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= group.getStudents().size()) {
            showStudentDetails(group.getStudents().get(choice - 1));
        } else {
            System.err.println(WRONG_OPTION);
        }
    }

    private static void showStudentDetails(Student student) {
        boolean exit = false;
        while (!exit) {
            System.out.println(student);
            System.out.println(RETURN_TO_MENU);
            System.out.println(STUDENT_MENU);
            int choice = handleIntInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> editingManager.editStudent(student);
                default -> System.err.println(WRONG_OPTION);
            }
        }
    }

    private static int handleIntInput() {
        System.out.println(SELECT_OPTION);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Пожалуйста, введите корректное число.");
            return handleIntInput();
        }
    }

    private ConsoleMenu() {
    }
}
