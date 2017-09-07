package in.apptozee.calc.calc.movieinfo;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import in.apptozee.calc.calc.R;
import in.apptozee.calc.calc.movieinfo.database.DbHelper;

/**
 * Created by amareshjana on 24/03/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {

    private EditText username;
    private EditText password;
    private Button loginBttn;
    private TextView mRegistration;
    private double lat = 0, lon = 0;
    DbHelper mDbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_movie_info_login);
        mDbHelper = new DbHelper(getApplicationContext());
        findViews();
    }

    private void findViews() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginBttn = (Button) findViewById(R.id.login_bttn);
        mRegistration = (TextView) findViewById(R.id.register);

        loginBttn.setOnClickListener(this);
        mRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == loginBttn) {
            String username_str = username.getText().toString();
            String password_str = password.getText().toString();

            if (username_str.equals("Admin") && password_str.equals("password")) {
                Intent mIntent = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(mIntent);
                finish();
            } else if (mDbHelper.getUserDetails(username_str, password_str)) {
                Intent mIntent = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(mIntent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "no such user", Toast.LENGTH_LONG).show();
            }

        } else if (v == mRegistration) {
            Intent mIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(mIntent);
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
