public class Programmer extends Employee{
    private String levelOfExpertise;

    public Programmer(String name, int age, double salary,String levelOfExpertise) {
        super(name, age, salary);
        this.levelOfExpertise =levelOfExpertise;
    }
    public String getLevelOfExpertise() {

        return levelOfExpertise;
    }

    public void setLevelOfExpertise(String levelOfExpertise) {

        this.levelOfExpertise = levelOfExpertise;
    }


    @Override
    public double calculateYearlyIncome() {
        return this.getSalary() * 1.5;
    }

    @Override
    public double calculateYearlyIncome(double bonus) {
        return (this.getSalary()+bonus) * 1.5;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("level of expertise: " + levelOfExpertise);
    }
}
