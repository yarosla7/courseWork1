package pro.sky.java.course1.courseWork1;

public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Исаев Никита Владимирович", 1, 95_000);
        employees[1] = new Employee("Носков Никита Юрьевич", 3, 97_000);
        employees[2] = new Employee("Басов Георгий Сергеевич", 3, 65_000);
        employees[3] = new Employee("Журавлев Алексей Андреевич", 2, 110_000);
        employees[4] = new Employee("Саламатов Илья Владимирович", 2, 66_000);
        employees[5] = new Employee("Бековщенко Дмитрий Сергеевич", 5, 115_000);
        employees[6] = new Employee("Носкова Ульяна Эдуардовна", 3, 112_000);
        employees[7] = new Employee("Куклина Мария Владиславовна", 5, 85_000);
        employees[8] = new Employee("Глазкова Ксения Александровна", 4, 87_000);
        employees[9] = new Employee("Козлова Анна Алексеевна", 1, 145_000);

    }
    public static void printAllEmployees() {

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    } // выводим список всех сотрудников

    public static int sumOfSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    } // сумма всех зарплат

    public static Employee minSalary() {
        Employee result = employees[0];
        int minimum = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < minimum) {
                minimum = employee.getSalary();
                result = employee;
            }
        }
        return result;
    } // минимальная ЗП по всем

    public static Employee maxSalary() {
        Employee result = employees[0];
        int maximum = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maximum) {
                maximum = employee.getSalary();
                result = employee;
            }
        }
        return result;
    } // максимальная ЗП по всем

    public static int averageSalary() {
        int sum = sumOfSalary();
        return sum / employees.length;
    } // средняя ЗП по всем

    public static void printAllNames() {
        System.out.println();
        for (Employee employee : employees) {
            System.out.println("ФИО сотрудника: " + employee.getFullName());
        }
    } // распечатать все фио
}