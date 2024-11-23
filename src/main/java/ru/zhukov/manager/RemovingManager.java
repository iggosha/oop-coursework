package ru.zhukov.manager;

import ru.zhukov.entity.Department;
import ru.zhukov.entity.Group;
import ru.zhukov.entity.Institute;

import java.util.List;

import static ru.zhukov.Main.scanner;
import static ru.zhukov.menu.MenuConstants.*;

public class RemovingManager {

    public void removeInstituteFromList(List<Institute> instituteList) {
        System.out.println("Выберите институт для удаления:");
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < instituteList.size(); i++) {
            System.out.println((i + 1) + ". " + instituteList.get(i).getName());
        }
        int choice = handleIntInput();
        if (choice == 0) {
            System.out.println(RETURNING);
        } else if (choice > 0 && choice <= instituteList.size()) {
            instituteList.remove(choice - 1);
            System.out.println("Институт успешно удалён");
        } else {
            System.out.println(WRONG_OPTION);
        }
    }

    public void removeGroupFromInstitute(Institute institute) {
        System.out.println("Выберите группу для удаления:");
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institute.getGroups().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getGroups().get(i).getIdNumber());
        }
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

    public void removeDepartmentFromInstitute(Institute institute) {
        System.out.println("Выберите кафедру для удаления:");
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < institute.getDepartments().size(); i++) {
            System.out.println((i + 1) + ". " + institute.getDepartments().get(i).getName());
        }
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

    public void removeTeacherFromDepartment(Department department) {
        System.out.println("Выберите преподавателя для удаления:");
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < department.getTeachers().size(); i++) {
            System.out.println((i + 1) + ". " + department.getTeachers().get(i).getFullName());
        }
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

    public void removeStudentFromGroup(Group group) {
        System.out.println("Выберите студента для удаления:");
        System.out.println(RETURN_TO_MENU);
        for (int i = 0; i < group.getStudents().size(); i++) {
            System.out.println((i + 1) + ". " + group.getStudents().get(i).getFullName());
        }
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
}
