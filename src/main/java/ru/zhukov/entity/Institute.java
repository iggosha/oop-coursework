package ru.zhukov.entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Institute {

    private String name;
    // Содержит кафедры с преподавателями
    private List<Department> departments;
    // Содержит группы со студентами
    private List<Group> groups;

    @Override
    public String toString() {
        String departmentsNames = departments != null && !departments.isEmpty() ?
                departments.stream()
                        .map(Department::getName)
                        .collect(Collectors.joining(", "))
                : "нет кафедр";
        String groupsIds = groups != null && !groups.isEmpty() ?
                groups.stream()
                        .map(Group::getIdNumber)
                        .collect(Collectors.joining(", "))
                : "Нет групп";

        return "Институт{" +
                "название='" + name + '\'' +
                ", кафедры=" + departmentsNames +
                ", группы=" + groupsIds +
                '}';
    }
}