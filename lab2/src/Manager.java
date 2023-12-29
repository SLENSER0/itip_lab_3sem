public class Manager extends Employee {
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public double calculateYearlyIncome() {
        return getSalary() * 1.75;
    }

    @Override
    public double calculateYearlyIncome(double bonus) {
        return (this.getSalary()+bonus) * 1.7;
    }
}
