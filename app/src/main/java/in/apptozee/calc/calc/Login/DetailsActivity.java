package in.apptozee.calc.calc.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import in.apptozee.calc.calc.R;

/**
 * Created by amareshjana on 22/03/17.
 */

public class DetailsActivity extends AppCompatActivity {

    TextView mUserName, mPassword;
    String mUsernameStr = "", mPasswordStr = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);

        mUserName = (TextView) findViewById(R.id.username_tv);
        mPassword = (TextView) findViewById(R.id.password_tv);

        Bundle extras = getIntent().getExtras();
        mUsernameStr = extras.getString("username");
        mPasswordStr = extras.getString("password");

        mUserName.setText(mUsernameStr);
        mPassword.setText(mPasswordStr);
    }
}