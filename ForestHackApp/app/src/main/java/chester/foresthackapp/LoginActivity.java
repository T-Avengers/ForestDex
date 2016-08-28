package chester.foresthackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public TextView tv_display;
    private Button btn_login;
    private Button btn_register;
    private EditText et_username;
    private EditText et_password;
    private boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_display = (TextView) findViewById(R.id.chesText);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        et_username= (EditText) findViewById(R.id.et_username);
        et_password= (EditText) findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changeIt(tv_display,et_username.getText().toString(),et_password.getText().toString());
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private void changeIt(TextView tv,String user,String pass){
        if(user.equals("Chester") && pass.equals("123")){
            tv.setText("Login Success!");
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
        else{
            tv.setText("Invalid Login!");
        }
    }

    @Override
    public void onBackPressed() {
        if(!exit){
            Toast.makeText(this, "Press Back again to Quit.", Toast.LENGTH_SHORT).show();
            exit = true;
        }
        else if(exit){
            finish();
        }
    }
}
