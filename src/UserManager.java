import java.util.ArrayList;

public class UserManager extends User{

    static boolean didLogin = false; //giriş yaptıktan sonra yapılabilecek işlemler için kullan örn. updateUsername.

    private static int nextID = 1;
    private int userID;

    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public UserManager(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }


    @Override
    public void register(String name, String surname,String username, String password, String email) {

        if (usernames.contains(username))
            System.out.println("This username already taken, please try another usernames.");
        else {
            this.username = username;
            usernames.add(username);
            this.password = password;
            passwords.add(password);

            this.email = email;
            this.name = name;
            this.surname = surname;
            System.out.println("Account created, now you can log in.");
            this.userID = nextID++;
        }
    }

    public void logout(){
        didLogin = false;
    }

    @Override
    public void login(String username, String password) {

        if (usernames.contains(username)){
            int indexOfUsername = usernames.indexOf(username);

            if (passwords.get(indexOfUsername).equals(password)){
                didLogin = true;
                System.out.printf("You logged in, %s!%n", name);
            }else {
                System.out.println("There is a mistake on your password!");
            }

        }else {
            System.out.println("This username is not fount!");
        }

    }

    // loginden sonra yapılsınn düzelt -- düzelttim
    @Override
    public void updateUsername(String oldUsername, String newUsername) {

        if (didLogin == true){  // if you don't log in, you cannot update your username
            if (getUsername().equals(oldUsername)) {
                this.username = newUsername;
                usernames.set(usernames.indexOf(oldUsername), newUsername);
                System.out.printf("Your username updated to \"%s\" from \"%s\"!%n", newUsername, oldUsername);
            }else {
                System.out.println("You cannot rewrite another username!!!");
            }
        }
        else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    // loginden sonra yapılsınn düzelt -- düzelttim
    @Override
    public void updatePassword(String username, String newPassword) {

        if (didLogin == true){ // if you don't log in, you cannot update your password

            if (getUsername().equals(username)){
                this.password = newPassword;
                passwords.set(usernames.indexOf(username),newPassword);
                System.out.println("Your password changed!");
            }else {
                System.out.println("You cannot rewrite another password!!!");
            }
        }
        else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    @Override
    public void updateEmail(String newEmail){

        if (didLogin == true) {

            this.email = newEmail;
            System.out.printf("Your email updated to \"%s\"!%n", email);
        }
        else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    @Override
    public void updateNameAndSurname(String newName, String newSurname){
        if (didLogin) {
            this.name = newName;
            this.surname = newSurname;
            System.out.printf("Your name and surname updated as %s and %s%n", name, surname);
        }else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    public int getID() {
        return userID;
    }
}
