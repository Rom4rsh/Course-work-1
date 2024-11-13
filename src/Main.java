public class Main {

    private static int calculateSallary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++)
            sum += employees[i].getSalary();
        return sum;
    }

    private static int findMaxSalary(Employee[] employees) {
        int maxSalary = -1;
        for (int i = 0; i < employees.length; i++)
            if (maxSalary < employees[i].getSalary())
                maxSalary = employees[i].getSalary();
        return maxSalary;
    }

    private static int findMinSalary(Employee[] employees) {
        int minSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++)
            if (minSalary > employees[i].getSalary())
                minSalary = employees[i].getSalary();
        return minSalary;
    }

    private static int calculateAvgSalary(Employee[] employees) {
        int avgSalary = calculateSallary(employees) / employees.length;
        return avgSalary;
    }

    private static void returnFullname(Employee[] employees) {
        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i].getFullName());
    }


    public static Employee[] employees = new Employee[5];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 3, 60_000);
        employees[1] = new Employee("Маскимов Алексей Иванович", 2, 61_000);
        employees[2] = new Employee("Иванов Карим Тагирович", 5, 44_000);
        employees[3] = new Employee("Кирюшкин Роман Алексеевич", 1, 63_000);
        employees[4] = new Employee("Романов Роман Романович", 4, 90_000);
        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i]);
        System.out.println("=======");
        System.out.println(calculateSallary(employees));
        System.out.println("=======");
        System.out.println(findMaxSalary(employees));
        System.out.println("=======");
        System.out.println(findMinSalary(employees));
        System.out.println("=======");
        System.out.println(calculateAvgSalary(employees));
        System.out.println("=======");
        returnFullname(employees);
    }

}



