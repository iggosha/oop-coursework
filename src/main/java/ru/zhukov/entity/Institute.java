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

    public Institute(String name, List<Department> departments, List<Group> groups) {
        setGroups(groups);
        setName(name);
        setDepartments(departments);
        departments.forEach(department -> department.setInstitute(this));
        groups.forEach(group -> group.setInstitute(this));
    }

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

        return "\nИнститут - " +
                "Название: " + name +
                ", \nНазвания кафедр: " + departmentsNames +
                ", \nНомера групп: " + groupsIds;
    }
}