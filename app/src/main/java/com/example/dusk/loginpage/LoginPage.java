package com.example.dusk.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Document needs to be edited for the following on a later time
*  - Function to validate username and password from sql database
*  - Update on the UI, based on group input on a later date
*  Made as of 02/07/18 By Trajon Felton
* */

public class LoginPage extends AppCompatActivity {
    //Pattern Matching Variables
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Object Variables
        EditText username = (EditText) findViewById(R.id.loginUserID);
        EditText password = (EditText) findViewById(R.id.loginUserPwd);
        Button btnLogin = (Button) findViewById(R.id.buttonLogin);
        Button btnRegister = (Button) findViewById(R.id.buttonRegister);

        /**
         * Listens to clicks on the {@code btnLogin }
         * When executed, it will invoke the {@code onClick}
         * method of {@code btnLogin}
         */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * onClick Action for @code btnLogin
             * If the inputed userID and password entered for
             * @code username and @code password is valid, this will
             * bring the user to the main app page, or else it will
             * prompt a toast to the user of invalid login credentials
             */
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, MainPage.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            /**
             *onClick Action for Register Button,
             * Upon user clicking the Register button it will bring the user
             * to the registration page.
             */
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginPage.this, Registration.class);
                startActivity(intent);
            }
        });
    }
    /**
     * Validates the @code username and @code password texts entered by the user
     *  **Note**, for Login Page this will need to be edited to match case by SQL Database.
     *  @param emailStr is the email that the user inputed into the UserID textbox
     *  @param pwdStr is the password string that the user inputed into the Password textbox.
     */
    public static boolean validate(String emailStr, String pwdStr) {
        Matcher emailMatch = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        Matcher pwdMatch = VALID_PASSWORD_REGEX.matcher(pwdStr);
        return emailMatch.find() && pwdMatch.find();
    }
}