package in.apptozee.calc.calc.movieinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.apptozee.calc.calc.R;
import in.apptozee.calc.calc.movieinfo.database.DbHelper;
import in.apptozee.calc.calc.movieinfo.model.UserModel;

/**
 * Created by amareshjana on 24/03/17.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText usernameReg;
    private EditText passwordReg;
    private EditText mobileNo;
    private EditText email;
    private Button regBtn;

    private void findViews() {
        name = (EditText) findViewById(R.id.name);
        usernameReg = (EditText) findViewById(R.id.username_reg);
        passwordReg = (EditText) findViewById(R.id.password_reg);
        mobileNo = (EditText) findViewById(R.id.mobile_no);
        email = (EditText) findViewById(R.id.email);
        regBtn = (Button) findViewById(R.id.reg_btn);

        regBtn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info_register);
        findViews();

    }

    @Override
    public void onClick(View v) {
        if (v == regBtn) {
            UserModel userModel = new UserModel(usernameReg.getText().toString(), passwordReg.getText().toString(), mobileNo.getText().toString()
                    , email.getText().toString(), name.getText().toString());

            DbHelper mDbHelper = new DbHelper(RegisterActivity.this);
            if (mDbHelper.insertUser(userModel)>0) {
                Toast.makeText(RegisterActivity.this,"User Registered",Toast.LENGTH_LONG).show();
                finish();
            } else {
                Snackbar snackbar = Snackbar
                        .make(v, "User Not Registered", Snackbar.LENGTH_LONG);
                snackbar.show();
                finish();
            }
        }
    }
}
