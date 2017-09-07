package in.apptozee.calc.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import in.apptozee.calc.calc.Calc.CalcMain;
import in.apptozee.calc.calc.Login.MainActivity;
import in.apptozee.calc.calc.movieinfo.LoginActivity;

/**
 * Created by amareshjana on 22/03/17.
 */

public class MainMenuApplicationsAcitivity extends AppCompatActivity implements View.OnClickListener {

    Button mLogin, mCalc,movieInfo,mExit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mLogin = (Button) findViewById(R.id.login);
        mCalc = (Button) findViewById(R.id.calc);
        movieInfo = (Button) findViewById(R.id.movie_info);
        mExit = (Button) findViewById(R.id.exit);

        mCalc.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        movieInfo.setOnClickListener(this);
        mExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Intent mLoginIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mLoginIntent);
                break;
            case R.id.calc:
                Intent mCalIntent = new Intent(getApplicationContext(), CalcMain.class);
                startActivity(mCalIntent);
                break;
            case R.id.movie_info:
                Intent mMovieIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mMovieIntent);
                break;
            case R.id.exit:
                finish();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Coming Soon...", Toast.LENGTH_LONG).show();
        }
    }
}
