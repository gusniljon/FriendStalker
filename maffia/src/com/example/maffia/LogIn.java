package com.example.maffia;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogIn extends Activity {

	private String email; 
	private String username;
	private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

//	private void login() {
//		if (CheckDetails.emailAvailable(email) == false)
//			CheckDetails.getAccount(email);
//		else if (CheckDetails.usernameAvailable(username) == false)
//			CheckDetails.getAccount(username);
//		else {
//			return;
//		}
//		if (password == CheckDetails.account.password()) {
//			/*
//			 * Start MainActivity with CheckDetails.account as account;
//			 */
//			return;
//		}
//		System.out.println("Invalid Username/Email and/or Incorrect Password");
//	}
    
	public void login(View view) {
		Intent intent = new Intent(this, ViewMap.class);
		startActivity(intent);
	}
	private void register() {
		// TODO
	}

}
