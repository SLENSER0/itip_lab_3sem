public class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {"Dsfah!4", "ahsdjfhsafjas", "fdas3fadFdf"};

        for (String password: passwords) {
            System.out.println("\n"+password+":");
            if (password.matches("^(?=.+[A-Z])(?=.+\\d)[a-zA-Z\\d]{8,16}$")) {
                System.out.print("Password is valid");
            } else {
                System.out.print("Invalid password");
            }
        }

    }
}