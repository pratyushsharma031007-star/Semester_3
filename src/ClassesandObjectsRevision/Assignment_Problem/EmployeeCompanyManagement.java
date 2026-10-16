package ClassesandObjectsRevision.Assignment_Problem;

class Employe {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employe(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyManagement {
    public static void main(String[] args) {
        Employe e1 = new Employe("Arun", 50000);
        Employe e2 = new Employe("Priya", 60000);
        Employe e3 = new Employe("Rahul", 55000);

        Employe.printCompanyInfo();
    }
}