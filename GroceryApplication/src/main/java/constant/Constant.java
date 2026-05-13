package constant;

public class Constant {
	
	public static final String CONFIGFILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config.property";
	public static final String TESTDATA = System.getProperty("user.dir") + "\\src\\test\\resources\\MainTestData.xlsx";
	
	public static final String VALIDCREDENTIALERROR = "user is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR = "user is able to login with invalid credentials";
	public static final String VALIDUSERNAMEERROR = "user is able to login with invalid password";
	public static final String VALIDPASSWORDERROR = "user is able to login with invalid username";
	public static final String SUCEESSFULLYLOGOUTERROR = "user is unable to logout";
	public static final String ADDNEWADMINUSERERROR = "user creation is failed";
	public static final String SEARCHNEWLYADDEDUSERERROR = "unable to find user";
	public static final String UPDATECONTACTDETAILSERROR = "user contact updation failed";
	public static final String ADDNEWNEWSERROR = "user failed to create new news ";
	public static final String SEARCHNEWLYADDEDNEWSERROR = "unable to find news";
	
	//this is how you take the local path, for this we use getproperty() method

}


