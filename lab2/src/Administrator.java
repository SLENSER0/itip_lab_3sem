class Administrator extends Employee {
    public Administrator(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public double calculateYearlyIncome() {
        return getSalary() * 1.2;
    }

    @Override
    public double calculateYearlyIncome(double bonus) {
        return (this.getSalary()+bonus) * 1.2;
    }
}