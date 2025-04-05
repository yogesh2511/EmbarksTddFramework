package pages;

import com.github.javafaker.Faker;

public class UserData {
    private String email;
    private String password;

    // Constructor
    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Generate random user using Faker
    public static UserData generateRandomUser() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 16); 
        return new UserData(email, password);
    }

	public static String getRegisteredUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		UserData user = UserData.generateRandomUser();
		System.out.println("Generated User Email: " + user.getEmail());
		System.out.println("Generated User Password: " + user.getPassword());
	}
}
