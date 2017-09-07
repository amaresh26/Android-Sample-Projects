package in.apptozee.calc.calc.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.apptozee.calc.calc.R;

public class MainActivity extends AppCompatActivity {

    Button mLogin;
    EditText mUsername, mPassword;
    String mUsernameStr,mPasswordStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username_et);
        mPassword = (EditText) findViewById(R.id.password_et);
        mLogin = (Button) findViewById(R.id.login_btn);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsernameStr = mUsername.getText().toString();
                mPasswordStr = mPassword.getText().toString();

                Intent mIntent = new Intent(getApplicationContext(), DetailsActivity.class);
                mIntent.putExtra("username",mUsernameStr);
                mIntent.putExtra("password",mPasswordStr);
                startActivity(mIntent);
            }
        });
    }
}