package comli.example.c4q.beatdiabetes.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import comli.example.c4q.beatdiabetes.MainActivity;
import comli.example.c4q.beatdiabetes.R;

public class LoginActivity extends AppCompatActivity {

    private TextView password;
    private TextView username;
    private CheckBox checkBox;
    private Button login;
    private SharedPreferences sharedPrefs;
    private static final String SHAREDPREF = "mySharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        checkBox = findViewById(R.id.my_checkbox);
        login = findViewById(R.id.login_button);

        sharedPrefs = getApplicationContext().getSharedPreferences(SHAREDPREF, MODE_PRIVATE);

        if (sharedPrefs.getBoolean("isChecked", false)) {
            username.setText(sharedPrefs.getString("username", null));
            password.setText(sharedPrefs.getString("password", null));
            checkBox.setChecked(sharedPrefs.getBoolean("isChecked", false));
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPrefs.edit();
                if (checkBox.isChecked()) {
                    editor.putString("username", username.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("isChecked", checkBox.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", checkBox.isChecked());
                    editor.commit();
                }  if(username.getText().toString().equals("user@aol.com")&& password.getText().toString().equals("password1234")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("username",username.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
