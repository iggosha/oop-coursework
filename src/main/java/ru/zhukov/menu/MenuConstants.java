package ru.zhukov.menu;

public class MenuConstants {

    public static final String SELECT_OPTION = "Выберите опцию: ";
    public static final String WRONG_OPTION = "Неверный выбор. Пожалуйста, попробуйте снова.";
    public static final String RETURN_TO_MENU = "\n0. Вернуться в меню";
    public static final String RETURNING = "Возврат в меню";
    public static final String SKIP_INPUT = "Нажимайте Enter для пропуска изменения поля";

    public static final String MAIN_MENU = """

            Главное меню:
            0. Завершить работу
            1. Сгенерировать институт со случайными данными
            2. Создать институт
            3. Выбрать институт из списка
            4. Удалить институт
            """;

    public static final String INSTITUTE_MENU = """
            1. Работа с кафедрами
            2. Работа с группами
            3. Изменить институт""";

    public static final String DEPARTMENT_MANAGEMENT_MENU = """
            1. Выбрать кафедру из списка
            2. Сгенерировать кафедру
            3. Создать кафедру
            4. Удалить кафедру""";

    public static final String GROUP_MANAGEMENT_MENU = """
            1. Выбрать группу из списка
            2. Сгенерировать группу
            3. Создать группу
            4. Удалить группу""";

    public static final String DEPARTMENT_MENU = """
            1. Просмотреть данные преподавателей
            2. Сгенерировать преподавателя
            3. Создать преподавателя
            4. Удалить преподавателя
            5. Изменить кафедру""";

    public static final String GROUP_MENU = """
            1. Просмотреть данные студентов группы
            2. Сгенерировать студента
            3. Создать студента
            4. Удалить студента
            5. Изменить группу""";

    public static final String TEACHER_MENU = "1. Изменить преподавателя";

    public static final String STUDENT_MENU = "1. Изменить студента";

    private MenuConstants() {
    }
}
