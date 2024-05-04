import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User u1 = new UserManager("name", "surname",
                "username", "password", "mail@example.com");

        User u2 = new UserManager("name", "surname",
                "username", "password", "mail@example.com");

        Scanner keyb = new Scanner(System.in);

        u1.register("tuncay","çelik","tncyy","1234.","tuncay@gmail");

        u2.register("tuncayss","çeliss","tncyyy","123","tuncaydfg@gmail");
        u2.login("tncyyy","123");

//        System.out.println("    Register");
//        System.out.print("Name: ");
//        String name = keyb.nextLine();
//        System.out.print("Surname: ");
//        String surname = keyb.nextLine();
//        System.out.print("Username: ");
//        String regusername = keyb.nextLine();
//        System.out.print("Password: ");
//        String regpassword = keyb.nextLine();
//        System.out.print("Email: ");
//        String email = keyb.nextLine();

//        u1.register(name, surname, regusername, regpassword, email);
//        System.out.println(u1.getName() + " " + u1.getSurname() + " " + u1.getUsername()
//                + " " + u1.getPassword() + " " + u1.getEmail());
//
//        System.out.println("    Login ");
//
//        System.out.print("Username: ");
//        String username = keyb.nextLine();
//        System.out.print("Password: ");
//        String password = keyb.nextLine();
//        u1.login(username, password);


        u1.updateUsername("tncyy","tanci");
        u2.updateUsername("tncyyy","tuncay");

        //u2.logout();

        u1.updatePassword("tanci","abcd");
        u2.updatePassword("tuncay","derf");

        u2.updateNameAndSurname("Ece","YellowPlace");

        u2.login("tuncay","derf");

        System.out.println(u1.getID());
        System.out.println(u2.getID());

    }
}