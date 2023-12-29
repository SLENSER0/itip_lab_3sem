
public class Main {
    public static void main(String[] args) {
        Administrator admin = new Administrator("John", 30, 75000);
        admin.displayInfo();
        System.out.println("id: " + admin.getId());
        System.out.println(admin.calculateYearlyIncome());

        Programmer programmer = new Programmer("Alex", 28, 75000, "Senior");
        programmer.displayInfo();
        System.out.println("id: " + programmer.getId());
        System.out.println(programmer.calculateYearlyIncome());

    }
}