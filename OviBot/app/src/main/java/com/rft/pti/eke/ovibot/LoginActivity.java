package com.rft.pti.eke.ovibot;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "test@test.com:test123"
    };

    private View loginFormView;
    private View loginProgressView;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;

    private UserLoginTask mAuthTask = null;
    private Storage storage;
    CheckBox cb_szulo;
    CheckBox cb_ovono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        storage = new Storage(this);
        // Check if user is saved already
        if (storage.getName() != null) {
            startMainActivity();
        }

        loginFormView = findViewById(R.id.login_form);
        loginProgressView = findViewById(R.id.login_progress);

        emailEditText = (EditText) findViewById(R.id.email_editText);
        passwordEditText = (EditText) findViewById(R.id.password_editText);
        signInButton = (Button) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
        CheckBox cb_szulo = (CheckBox) findViewById(R.id.cb_szulo);
        cb_szulo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    signInButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1= new Intent(LoginActivity.this,Szulo.class);
                            startActivity(intent1);

                        }
                    });
                }
            }
        });
        CheckBox cb_ovono = (CheckBox) findViewById(R.id.cb_ovono);
        cb_ovono.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    signInButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(LoginActivity.this,Ovono.class);
                            startActivity(intent);
                        }
                    });

                }
            }
        });


    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthTask != null) {
            mAuthTask.cancel(true);
        }
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, Ovono.class);
        startActivity(intent);

        // Make sure the user cannot come back by tapping on back
        //finish();
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        emailEditText.setError(null);
        passwordEditText.setError(null);

        // Store values at the time of the login attempt.
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordEditText.setError(getString(R.string.error_invalid_password));
            focusView = passwordEditText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError(getString(R.string.error_field_required));
            focusView = emailEditText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailEditText.setError(getString(R.string.error_invalid_email));
            focusView = emailEditText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //: Replace this with your own logic
        return password.length() >= 6 ;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    private void showProgress(final boolean show) {
        loginProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // : attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    boolean match = pieces[1].equals(mPassword);
                    if (match) {
                        byte[] bytesEncoded = Base64.encode(pieces[1].getBytes(), Base64.URL_SAFE);
                        String token = new String(bytesEncoded);
                        System.out.println("encoded value is " + token);

                        byte[] dec = Base64.decode(token, Base64.URL_SAFE);
                        System.out.println("decoded value is " + new String(dec));

                        String email = pieces[0];
                        String name = email.split("\\@")[0];
                        storage.setEmail(email);
                        storage.setName(name);
                        storage.setToken(token);
                    }
                    return match;
                }
            }
            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                startMainActivity();
            } else {
                passwordEditText.setError(getString(R.string.error_incorrect_password));
                passwordEditText.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}