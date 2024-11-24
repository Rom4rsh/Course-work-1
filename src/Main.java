public class Main {


    private static int calculateSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) sum += employee.getSalary();
        return sum;
    }

    private static int findMaxSalary(Employee[] employees) {
        int maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (maxSalary < employee.getSalary()) maxSalary = employee.getSalary();
        }
        return maxSalary;
    }

    private static int findMinSalary(Employee[] employees) {
        int minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    private static int calculateAvgSalary(Employee[] employees) {
        return calculateSalary(employees) / employees.length;
    }

    private static void returnFullname(Employee[] employees) {
        for (Employee employee : employees) System.out.println(employee.getFullName());
    }

    private static void indexationSalary(Employee[] employees) {
        double indexSalaryPercent = 0.05;
        for (Employee employee : employees) {
            employee.setSalary((int) (employee.getSalary() * indexSalaryPercent + employee.getSalary()));
            System.out.println(employee.getSalary());
        }
    }

    private static void findMinSalaryByDep(Employee[] employees, int department) {
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        System.out.println("Минимальная ЗП в отделе " + department + " равна: " + minSalary);
    }

    private static void findMaxSalaryByDep(Employee[] employees, int departament) {
        double maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departament && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("Максимальная ЗП в отделе " + departament + " равна: " + maxSalary);
    }

    private static int findSumSalaryByDep(Employee[] employees, int department) {
        int salarySum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) salarySum += employee.getSalary();
        }
        return salarySum;
    }

    private static int getEmployCount(Employee[] employees, int department) {
        int count = 0;
        for (var employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("Полное имя- " + employee.getFullName() + ", ЗП: " + employee.getSalary() + " id сотрудника: " + employee.getId());
        }
    }

    public static void printEmployeesSalaryLess(Employee[] employees, int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() > salary)
                System.out.println("Полное имя- " + employee.getFullName() + ", ЗП: " + employee.getSalary() + " id сотрудника: " + employee.getId());
        }
    }

    public static void printEmployeesSalaryMore(Employee[] employees, int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() <= salary)
                System.out.println("Полное имя- " + employee.getFullName() + ", ЗП: " + employee.getSalary() + " id сотрудника: " + employee.getId());
        }
    }

    private static int findAvgSalaryByDep(Employee[] employees, int department) {

        return findSumSalaryByDep(employees, department) / getEmployCount(employees, department);
    }

    private static void indexationSalaryByDep(Employee[] employees, int department) {
        double indexSalaryPercent = 0.05;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * indexSalaryPercent + employee.getSalary()));
                System.out.println(employee.getSalary());
            }
        }
    }


    public static Employee createEmployee(String fullName, int department, int salary) {
        return new Employee(fullName, department, salary);
    }

    public static Employee[] employees = new Employee[6];

    public static void main(String[] args) {
        employees[0] = createEmployee("Иванов Иван Иванович", 1, 60_000);
        employees[1] = createEmployee("Маскимов Алексей Иванович", 1, 61_000);
        employees[2] = createEmployee("Иванов Карим Тагирович", 2, 44_000);
        employees[3] = createEmployee("Кирюшкин Роман Алексеевич", 2, 63_000);
        employees[4] = createEmployee("Романов Роман Романович", 2, 90_000);
        employees[5] = createEmployee("Киреев Кирей Киреевич", 3, 98_000);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        int department = 2;
        System.out.println("=======");
        System.out.println(calculateSalary(employees));
        System.out.println("=======");
        System.out.println(findMaxSalary(employees));
        System.out.println("=======");
        System.out.println(findMinSalary(employees));
        System.out.println("=======");
        System.out.println(calculateAvgSalary(employees));
        System.out.println("=======");
        returnFullname(employees);
        System.out.println("=======");
        indexationSalary(employees);
        System.out.println("=====");
        findMinSalaryByDep(employees, 2);
        System.out.println("=====");
        findMaxSalaryByDep(employees, 2);
        System.out.println("=====");
        System.out.println("Департамент № " + 1 + " сумма выплат: " + findSumSalaryByDep(employees, 1));
        findSumSalaryByDep(employees, 1);
        System.out.println("=====");
        indexationSalaryByDep(employees, 2);
        System.out.println("=====");
        System.out.println("Департамент № " + 2 + " средняя сумма выплат: " + findAvgSalaryByDep(employees, department));
        System.out.println("=====");
        printEmployees(employees);
        System.out.println("=====");
        printEmployeesSalaryLess(employees, 63000);
        System.out.println("=====");
        printEmployeesSalaryMore(employees, 63000);
    }
}



