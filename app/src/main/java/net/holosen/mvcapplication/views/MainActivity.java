package net.holosen.mvcapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.holosen.mvcapplication.R;
import net.holosen.mvcapplication.controllers.ILoginController;
import net.holosen.mvcapplication.controllers.LoginController;
import net.holosen.mvcapplication.models.User;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText username, password;
    private Button btnLogin;
    private ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        loginController = new LoginController(this);

        btnLogin.setOnClickListener(view -> {
            User user = new User();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            loginController.doLogin(user);
        });
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Login succeed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}