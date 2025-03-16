package stepDefinitions;

import io.cucumber.java.en.Given;
import utils.DBUtils;

public class DBSteps {
	
	
	@Given("User Sucessfully Connected to DB")
	public void user_sucessfully_connected_to_db() {
		DBUtils.getConnection_SQL() ;  
	}

}
