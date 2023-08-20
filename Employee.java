import java.time.Year;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (salary <= 1000) {
            return 0;
        } else {
            return salary * 0.03;
        }
    }

    public double bonus() {
        if (workHours > 40) {
            int extraHours = workHours - 40;
            return extraHours * 30;
        } else {
            return 0;
        }
    }

    public void raiseSalary() {
        int currentYear = Year.now().getValue();
        int yearsWorked = currentYear - hireYear;

        if (yearsWorked < 10) {
            salary += salary * 0.05;
        } else if (yearsWorked >= 10 && yearsWorked < 20) {
            salary += salary * 0.10;
        } else {
            salary += salary * 0.15;
        }
    }

    @Override
    public String toString() {
        double totalSalary = salary - tax() + bonus();
        return "Adı: " + name +
                "\nMaaşı: " + salary +
                "\nÇalışma Saati: " + workHours +
                "\nBaşlangıç Yılı: " + hireYear +
                "\nVergi: " + tax() +
                "\nBonus: " + bonus() +
                "\nMaaş Artışı: " + (salary * 0.05) +
                "\nVergi ve Bonuslar ile birlikte maaş: " + (salary - tax() + bonus()) +
                "\nToplam Maaş: " + totalSalary;
    }

    public static void main(String[] args) {
        Employee kemal = new Employee("kemal", 2000.0, 45, 1985);
        kemal.raiseSalary();
        System.out.println(kemal.toString());
    }
}