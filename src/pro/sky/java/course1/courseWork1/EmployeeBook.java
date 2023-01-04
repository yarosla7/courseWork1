package pro.sky.java.course1.courseWork1;

//Третий уровень сложности

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void addEmployee(String fullName, int department, int salary) {
        boolean check = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                check = true;
                employees[i] = new Employee(fullName, department, salary);
                return;
            }
        }
        if (!check) {
            System.out.println("Нельзя добавить сотрудника, нет вакансий");
        }
    } // добавляем сотрудника

    public void deleteEmployeeById(int id) {
        boolean check = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                check = true;
                System.out.println(employees[i].getId() + " - удалён.");
                employees[i] = null;
                return;
            }
        }
        if (!check) {
            System.out.println("Не удалось найти сотрудника с ID:" + id);
        }
    } // удаляем по ID

    public void deleteEmployeeByName(String fullName) {
        boolean check = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                check = true;
                System.out.println(employees[i] + " - удалён.");
                employees[i] = null;
                return;
            }
        }
        if (!check) {
            System.out.println("Не удалось найти такого сотрудника");
        }
    } // удаляем по ФИО

    public int toChangeSalaryByFullName(String fullName, int newSalary) {
        boolean check = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                check = true;
                System.out.println("Зарплата для " + fullName + " была успешно повышена.");
                employees[i].setSalary(newSalary);
            }
        }
        if (!check) {
            System.out.println("error 404 (Сотрудник не найден)");
        }
        return newSalary;
    } // повышаем ЗП для конкретного сотрудника по ФИО

    public int toChangeDepartmentByFullName(String fullName, int newDepartment) {
        if (newDepartment <= 0 || newDepartment > 5) {
            throw new IllegalArgumentException("Такого отдела не существует.");
        }
        boolean check = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                check = true;
                System.out.println("Отдел для " + fullName + " была успешно изменен.");
                employees[i].setDepartment(newDepartment);
            }
        }
        if (!check) {
            System.out.println("error 404 (Сотрудник не найден)");
        }
        return newDepartment;
    } // изменение отдела для конкретного сотрудника

    public void printDepartmentAndFullNamesIn() {
        for (int j = 1; j <= 5; j++) {
            System.out.println("Отдел #" + j + ": ");
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getDepartment() == j) {
                    System.out.println(employees[i].getFullName());
                }
            }
            System.out.println();
        }
    } // печатаем отделы и сотрудников в нем

    /* Базовый уровень ============================================================================================= */

    public void printAllEmployees() {

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    } // выводим список всех сотрудников

    public int sumOfSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    } // сумма всех зарплат

    public Employee minSalary() {
        Employee result = employees[0];
        int minimum = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minimum) {
                minimum = employee.getSalary();
                result = employee;
            }
        }
        return result;
    } // минимальная ЗП по всем

    public Employee maxSalary() {
        Employee result = employees[0];
        int maximum = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maximum) {
                maximum = employee.getSalary();
                result = employee;
            }
        }
        return result;
    } // максимальная ЗП по всем

    public int averageSalary() {
        int sum = sumOfSalary();
        return sum / counterEmployee();
    } // средняя ЗП по всем

    public void printAllNames() {
        System.out.println();
        for (Employee employee : employees) {
            System.out.println("ФИО сотрудника: " + employee.getFullName());
        }
    } // распечатать все фио

    /* Повышенная сложность ======================================================================================= */

    public Employee findMinSalaryInDepartment(int department) {
        checkDep(department);
        counterInDep(department);
        Employee result = employees[0];
        int min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() < min) {
                min = employee.getSalary();
                result = employee;
            }
        }
        return result;
    } // найти в отделе минимальную ЗП

    public Employee findMaxSalaryInDepartment(int department) {
        checkDep(department);
        counterInDep(department);
        Employee result = employees[0];
        int max = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() > max) {
                max = employee.getSalary();
                result = employee;
            }
        }
        return result;
    } // найти в отделе максимальную ЗП

    public int departmentalCost(int department) {
        checkDep(department);
        counterInDep(department);
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    } // сумма затрат на отдел

    public int departmentalMiddleCost(int department) {
        checkDep(department);
        counterInDep(department);
        int counter = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter = counter + 1;
            }
        }
        return departmentalCost(department) / counter;
    } // средняя ЗП на отдел

    public void indexSalaryDepartment(int department, int percent) {
        checkDep(department);
        counterInDep(department);
        double realPercent = (double) percent / 100;
        int currentSalary;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary + (currentSalary * realPercent)));
            }
        }
    } // индексация ЗП на процент в отделе

    public void indexSalaryForAll(int percent) {
        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("У вас нет сотрудников");
            }
        }
        double realPercent = (double) percent / 100;
        int currentSalary;
        for (Employee employee : employees) {
            currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary + (currentSalary * realPercent)));
        }
    } //индексация ЗП всем

    public void printAllInDepartment(int department) {
        checkDep(department);
        counterInDep(department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.printExceptDepartment(department));
            }
        }
    } // распечатать всех кто в отделе

    public void printAllIfTheSalaryIsLessThan(int sum) {
        for (Employee employee : employees) {
            if (employee.getSalary() < sum) {
                System.out.println(employee.printForSearch());
            }
        }
    } // распечатать всех у кого ЗП меньше, чем

    public void printAllIfTheSalaryIsMoreThan(int sum) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= sum) {
                System.out.println(employee.printForSearch());
            }
        }
    } // распечатать всех у кого ЗП больше, чем

    //вспомогательные методы

    public int counterEmployee() {
        int counter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                counter++;
            }
        }
        return counter;
    } // посчитать всего

    public int counterInDep(int department) {
        int counter = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter++;
            } else if (employee == null) {
                throw new RuntimeException("Error 404 no one was found");
            }
        }
        return counter;
    } // посчитать в отделе

    public void checkDep(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует.");
        }
    } // проверка на существующий отдел
}