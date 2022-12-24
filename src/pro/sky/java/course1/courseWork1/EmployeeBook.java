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
            if(!check) {
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
        public int toChangeSalaryForOne(String fullName, int newSalary) {
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
        public int toChangeDepartmentForOne(String fullName, int newDepartment) {
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

        public void printAllEmployees () {
            if (counterEmployee() == 0) {
                throw new RuntimeException("Нет сотрудников.");
            }
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee);
                }
            }
        } // выводим список всех сотрудников
        public int sumOfSalary () {
            int sum = 0;
            for (Employee employee : employees) {
                if (employee != null) {
                    sum += employee.getSalary();
                }
            }
            return sum;
        } // сумма всех зарплат
        public int minSalary () {
            int minimum = Integer.MAX_VALUE;
            for (Employee employee : employees) {
                if (employee.getSalary() < minimum) {
                    minimum = employee.getSalary();
                }
            }
            return minimum;
        } // минимальная ЗП по всем
        public int maxSalary () {
            int maximum = Integer.MIN_VALUE;
            for (Employee employee : employees) {
                if (employee.getSalary() > maximum) {
                    maximum = employee.getSalary();
                }
            }
            return maximum;
        } // максимальная ЗП по всем
        public int averageSalary () {
            sumOfSalary();
            int sum = sumOfSalary();
            return sum / employees.length;
        } // средняя ЗП по всем
        public void printAllNames () {
            if (counterEmployee() == 0) {
                throw new RuntimeException("Нет сотрудников.");
            }
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println("ФИО сотрудника: " + employee.getFullName());
                } else {
                    System.out.println("Место для нового сотрудника");
                }
            }
        } // распечатать все фио

        /* Повышенная сложность ======================================================================================= */
        public int findMinSalaryInDepartment (int department){
            checkDep(department);
            int min = Integer.MAX_VALUE;
            for (Employee employee : employees) {
                if (employee.getDepartment() == department && employee.getSalary() < min) {
                        min = employee.getSalary();
                }
            }
            return min;
        } // найти в отделе минимальную ЗП
        public int findMaxSalaryInDepartment (int department){
            checkDep(department);
            int max = Integer.MIN_VALUE;
            for (Employee employee : employees) {
                if (employee.getDepartment() == department && employee.getSalary() > max) {
                        max = employee.getSalary();
                }
            }
            return max;
        } // найти в отделе максимальную ЗП
        public int departmentalCost (int department){
            checkDep(department);
            int sum = 0;
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
            return sum;
        } // сумма затрат на отдел
        public int departmentalMiddleCost (int department){
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
        public int indexSalary (int percent){
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
        public void printAllInDepartment (int department){
            checkDep(department);
            if (counterInDep(department) == 0) {
                throw new RuntimeException("В отделе нет сотрудников.");
            }
            for (Employee employee : employees)
                if (employee.getDepartment() == department) {
                    System.out.println(employee.printExceptDepartment(department));
                }
        } // распечатать всех кто в отделе
        public void printAllIfTheSalaryIsLessThan (int sum){
            for (Employee employee : employees) {
                if (employee.getSalary() < sum) {
                    System.out.println(employee.printForSearch());
                }
            }
        } // распечатать всех у кого ЗП меньше, чем
        public void printAllIfTheSalaryIsMoreThan (int sum){
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
                }
            }
            return counter;
        } // посчитать в отделе
        public void checkDep (int department){
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует.");
        }
    } // проверка на существующий отдел
}