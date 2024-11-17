package ru.zhukov;

public class StringConstants {

    public static final String SELECT_OPTION = "Выберите опцию: ";
    public static final String WRONG_OPTION = "Неверный выбор. Пожалуйста, попробуйте снова.";
    public static final String RETURN_TO_MENU = "\n0. Вернуться в меню";
    public static final String RETURNING = "Возврат в меню";

    public static final String MAIN_MENU = """
            
            Главное меню:
            0. Завершить работу
            1. Добавить институт со случайными данными
            2. Просмотреть институты""";

    public static final String INSTITUTE_MENU = """
            1. Просмотреть данные кафедр
            2. Просмотреть данные групп""";

    public static final String DEPARTMENT_MENU = """
            1. Просмотреть данные преподавателей""";

    public static final String GROUP_MENU = """
            1. Просмотреть данные студентов группы""";

    private StringConstants() {
    }


    public static final String[] FIRST_NAMES = {"Иван", "Петр", "Алексей", "Дмитрий", "Сергей"};
    public static final String[] LAST_NAMES = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов"};
    public static final String[] SPECIALIZATIONS = {"Информатика", "Математика", "Физика", "Химия", "Биология"};
    public static final String[] ACADEMIC_DEGREES = {"Доктор наук", "Кандидат наук", "Магистр", "Бакалавр"};
    public static final String[] ADDRESSES = {"ул. Тверская, д. 1", "ул. Невский проспект, д. 2", "ул. Баумана, д. 3",
            "ул. Красный проспект, д. 4", "ул. Ленина, д. 5", "ул. 5 августа, д. 7"
    };
    public static final String[] INSTITUTE_NAMES = {"Институт инженерных и цифровых технологий",
            "Юридический институт", "Педагогический институт", "Медицинский институт", "Институт наук о Земле"};
    public static final String[] DEPARTMENT_NAMES = {"Кафедра математического и программного обеспечения информационных систем",
            "Кафедра прикладной информатики и информационных технологий", "Кафедра материаловедения и нанотехнологий",
            "Кафедра информационных и робототехнических систем", "Кафедра автоматизированных систем и технологий"};
}
