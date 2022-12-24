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

    public static int minSalary() {
        int minimum = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < minimum) {
                minimum = employee.getSalary();
            }
        }
        return minimum;
    } // минимальная ЗП по всем

    public static int maxSalary() {
        int maximum = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maximum) {
                maximum = employee.getSalary();
            }
        }
        return maximum;
    } // максимальная ЗП по всем

    public static int averageSalary() {
        sumOfSalary();
        int sum = sumOfSalary();
        return sum / employees.length;
    } // средняя ЗП по всем

    public static void printAllNames() {
        System.out.println();
        for (Employee employee : employees) {
            System.out.println("ФИО сотрудника: " + employee.getFullName());
        }
    } // распечатать все фио

    /* Повышенная сложность */
    public static void checkDep(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует.");
        }
    } // проверка на существующий отдел
    public static int findMinSalaryInDepartment(int department) {
        checkDep(department);
        int min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if(employee.getSalary() < min){
                    min = employee.getSalary();
                }
            }
        }
        return min;
    } // найти в отделе минимальную ЗП

    public static int findMaxSalaryInDepartment(int department) {
        checkDep(department);
        int max = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if(employee.getSalary() > max){
                    max = employee.getSalary();
                }
            }
        }
        return max;
    } // найти в отделе максимальную ЗП

    public static int departmentalCost(int department) {
        checkDep(department);
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    } // сумма затрат на отдел

    public static int departmentalMiddleCost (int department){
        checkDep(department);
        departmentalCost(department);
        int middle = 0;
        int counter = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                counter = counter + 1;
                middle = departmentalCost(department) / counter;
            }
        }
        return middle;
    } // средняя ЗП на отдел

    public static int indexSalary (int percent){
        double realPercent = (double) percent / 100;
        int sumOfIndex;
        int newSalary = 0;
        for (Employee employee : employees) {
            sumOfIndex = (int) (employee.getSalary() * realPercent);
            employee.setSalary(sumOfIndex + employee.getSalary());
            newSalary = employee.getSalary();
        }
        return newSalary;
    } // индексация ЗП всем на процент

    public static void printAllInDepartment (int department) {
        checkDep(department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.printExceptDepartment(department));
            }
        }
    } // распечатать всех кто в отделе

    public static void printAllIfTheSalaryIsLessThan (int sum) {
        for (Employee employee : employees) {
            if (employee.getSalary() < sum) {
                System.out.println(employee.printForSearch());
            }
        }
    } // распечатать всех у кого ЗП меньше, чем

    public static void printAllIfTheSalaryIsMoreThan (int sum){
        for (Employee employee : employees) {
            if (employee.getSalary() >= sum) {
                System.out.println(employee.printForSearch());
            }
        }
    } // распечатать всех у кого ЗП больше, чем
}