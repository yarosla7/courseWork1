package pro.sky.java.course1.courseWork1;

/*Курсовая */

public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Исаев Никита Владимирович", 1, 95_000);
        employeeBook.addEmployee("Носков Никита Юрьевич", 2, 97_000);
        employeeBook.addEmployee("Басов Георгий Сергеевич", 2, 65_000);
        employeeBook.addEmployee("Журавлев Алексей Андреевич", 3, 110_000);
        employeeBook.addEmployee("Саламатов Илья Владимирович", 3, 66_000);
        employeeBook.addEmployee("Бековщенко Дмитрий Сергеевич", 5, 115_000);
        employeeBook.addEmployee("Носкова Ульяна Эдуардовна", 3, 112_000);
        employeeBook.addEmployee("Куклина Мария Владиславовна", 5, 85_000);
        employeeBook.addEmployee("Глазкова Ксения Александровна", 4, 87_000);
        employeeBook.addEmployee("Козлова Анна Алексеевна", 1, 145_000);
    }
}