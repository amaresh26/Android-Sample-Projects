package in.apptozee.calc.calc.Calc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import in.apptozee.calc.calc.R;

/**
 * Created by amareshjana on 22/03/17.
 */

public class CalcMain extends AppCompatActivity implements View.OnClickListener{

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bAdd, bSub, bDiv, bMul, bEqual, bClear;
    EditText mInput;
    TextView result;
    String input = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        mInput = (EditText) findViewById(R.id.input);
        result = (TextView) findViewById(R.id.result);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b0 = (Button) findViewById(R.id.btn0);
        bAdd = (Button) findViewById(R.id.add);
        bSub = (Button) findViewById(R.id.sub);
        bMul = (Button) findViewById(R.id.mul);
        bDiv = (Button) findViewById(R.id.div);
        bEqual = (Button) findViewById(R.id.btn_equal);
        bClear = (Button) findViewById(R.id.btn_clr);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bAdd.setOnClickListener(this);
        bSub.setOnClickListener(this);
        bMul.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bEqual.setOnClickListener(this);
        bClear.setOnClickListener(this);

        bClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mInput.setText("");
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                input = mInput.getText().toString();
                mInput.setText(input + "1");
                break;
            case R.id.btn2:
                input = mInput.getText().toString();
                mInput.setText(input + "2");
                break;
            case R.id.btn3:
                input = mInput.getText().toString();
                mInput.setText(input + "3");
                break;
            case R.id.btn4:
                input = mInput.getText().toString();
                mInput.setText(input + "4");
                break;
            case R.id.btn5:
                input = mInput.getText().toString();
                mInput.setText(input + "5");
                break;
            case R.id.btn6:
                input = mInput.getText().toString();
                mInput.setText(input + "6");
                break;
            case R.id.btn7:
                input = mInput.getText().toString();
                mInput.setText(input + "7");
                break;
            case R.id.btn8:
                input = mInput.getText().toString();
                mInput.setText(input + "8");
                break;
            case R.id.btn9:
                input = mInput.getText().toString();
                mInput.setText(input + "9");
                break;
            case R.id.btn0:
                input = mInput.getText().toString();
                mInput.setText(input + "0");
                break;
            case R.id.add:
                input = mInput.getText().toString();
                mInput.setText(input + "+");
                break;
            case R.id.sub:
                input = mInput.getText().toString();
                mInput.setText(input + "-");
                break;
            case R.id.mul:
                input = mInput.getText().toString();
                mInput.setText(input + "*");
                break;
            case R.id.div:
                input = mInput.getText().toString();
                mInput.setText(input + "/");
                break;
            case R.id.btn_clr:
                input = mInput.getText().toString();
                int len = input.length();
                mInput.setText(input.substring(0, len - 1));
                break;
            case R.id.btn_equal:
                input = mInput.getText().toString();
                result.setText(doOperation(input));
                break;
        }
    }

    public String doOperation(String val) {
        int result = 0;
        if (val.contains("+")) {
            String[] vals = val.split("\\+");
            result = Integer.parseInt(vals[0]) + Integer.parseInt(vals[1]);
        }
        else if(val.contains("-"))
        {
            String[] vals = val.split("-");
            result = Integer.parseInt(vals[0]) - Integer.parseInt(vals[1]);
        }
        else if(val.contains("*"))
        {
            String[] vals = val.split("\\*");
            result = Integer.parseInt(vals[0]) * Integer.parseInt(vals[1]);
        }
        else if(val.contains("/"))
        {
            String[] vals = val.split("/");
            result = Integer.parseInt(vals[0]) / Integer.parseInt(vals[1]);
        }
        return result + "";
    }
}