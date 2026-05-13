package utilities;

import com.github.javafaker.Faker;

public class RandomDataUltility {
	Faker faker = new Faker();
	
	public String randomUsername() {
		return faker.name().username();  // username are in username 
	}
	public String randomPassword() {
		return faker.internet().password();  //passwords are in internet 
	}
	public String randomFullname() {
		return faker.name().fullName();  //fullnamesa are in name method
	}
	public String randomEmails() {
		return faker.internet().emailAddress();  // emails are in internet method
	}
	public String randomMobilenumber() {
		return faker.phoneNumber().cellPhone();   //mobile numbers are in phonenumber method 
	}

}
