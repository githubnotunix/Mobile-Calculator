package com.acme.calculator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import com.acme.calculator.R;
import com.acme.calculator.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private static String TAG = CalculatorActivity.class.getName();
    private TextView numberLabel;
    private Button button_clear;
    private Button button_posneg;
    private Button button_bkspce;
    private Button button_divide;
    private Button button_seven;
    private Button button_eight;
    private Button button_nine;
    private Button button_multiply;
    private Button button_four;
    private Button button_five;
    private Button button_six;
    private Button button_subtract;
    private Button button_one;
    private Button button_two;
    private Button button_three;
    private Button button_add;
    private Button button_zero;
    private Button button_decimal;
    private Button button_equal;
    Expression exp;
    //String var = "9+8";
    int count = 0;//counts number of parenthesis for sign button
    CalculatorPresenter presenter = new CalculatorPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        numberLabel = (TextView) findViewById(R.id.numberLabel);
        button_clear =(Button)findViewById(R.id.button_clear);
        button_clear.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            //Toast.makeText(getApplicationContext(),"Clear Clicked", Toast.LENGTH_SHORT).show();
            numberLabel.setText(numberLabel.getText() + "C");
            numberLabel.setText("");//prints nothing to textview to clear screen
        }
        });
        button_posneg =(Button)findViewById(R.id.button_posneg);
        button_posneg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                CharSequence currchar = numberLabel.getText().toString();
                //Toast.makeText(getApplicationContext(),"Posneg Clicked", Toast.LENGTH_SHORT).show();
                if(numberLabel.getText().length() < 2)//when there is no possibility of pressing the sign button
                {
                    numberLabel.setText(numberLabel.getText().toString() + "(-");
                }
               else if(currchar.subSequence(currchar.length()-2, currchar.length()).equals("(-"))//checking if the sign button was pressed previously
                {
                    numberLabel.setText(currchar.subSequence(0, currchar.length()-2));
                    numberLabel.setText(numberLabel.getText().toString()+ "");
                    //Toast.makeText(getApplicationContext(),"Posneg Clicked", Toast.LENGTH_SHORT).show();
                }
                else{
                    numberLabel.setText(numberLabel.getText().toString() + "(-");//for all other cases
                }
            }

        });
        button_bkspce =(Button)findViewById(R.id.button_bkspce);
        button_bkspce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Backspace Clicked", Toast.LENGTH_SHORT).show();
                //numberLabel.setText(numberLabel.getText().toString()+ "CE");
                if(numberLabel.getText().length() > 0)
                {
                    CharSequence currchar = numberLabel.getText().toString();
                    numberLabel.setText(currchar.subSequence(0, currchar.length()-1));//keeps element 0 to length-1
                }
            }
        });
        button_divide =(Button)findViewById(R.id.button_divide);
        button_divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Divide Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "/");
            }
        });
        button_seven =(Button)findViewById(R.id.button_seven);
        button_seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Seven Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "7");
            }
        });
        button_eight =(Button)findViewById(R.id.button_eight);
        button_eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Eight Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "8");
            }
        });
        button_nine =(Button)findViewById(R.id.button_nine);
        button_nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Nine Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "9");
            }
        });
        button_multiply =(Button)findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Multiply Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "*");
            }
        });
        button_four =(Button)findViewById(R.id.button_four);
        button_four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Four Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "4");
            }
        });
        button_five =(Button)findViewById(R.id.button_five);
        button_five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Five Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "5");
            }
        });
        button_six =(Button)findViewById(R.id.button_six);
        button_six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Six Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "6");
            }
        });
        button_subtract =(Button)findViewById(R.id.button_subtract);
        button_subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Subtract Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "-");
            }
        });
        button_one =(Button)findViewById(R.id.button_one);
        button_one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"One Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "1");
            }
        });
        button_two =(Button)findViewById(R.id.button_two);
        button_two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Two Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "2");
            }
        });
        button_three =(Button)findViewById(R.id.button_three);
        button_three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Three Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "3");
            }
        });
        button_add =(Button)findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Add Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "+");
            }
        });
        button_zero =(Button)findViewById(R.id.button_zero);
        button_zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Zero Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ "0");
            }
        });
        button_decimal =(Button)findViewById(R.id.button_decimal);
        button_decimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getApplicationContext(),"Decimal Clicked", Toast.LENGTH_SHORT).show();
                numberLabel.setText(numberLabel.getText().toString()+ ".");
            }
        });
        button_equal =(Button)findViewById(R.id.button_equal);
        button_equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                for(int i = 0; i < numberLabel.getText().length(); i++)//counts all left parenthesis
                {
                    CharSequence currchar = numberLabel.getText().toString();
                    if(currchar.subSequence(i, i +1).equals("("))
                    {
                        count++;
                    }
                }
                //Toast.makeText(getApplicationContext(), Integer.toString(count), Toast.LENGTH_SHORT).show();
                while (count > 0) {//adds on right parenthesis to evaluate equation
                    count--;
                    numberLabel.setText(numberLabel.getText().toString()+ ")");
                }
                // Toast.makeText(getApplicationContext(),"Equal Clicked", Toast.LENGTH_SHORT).show();
                try{
                    exp = new ExpressionBuilder(numberLabel.getText().toString()).build();//takes equation from the textview
                    //exp.evaluate();
                    numberLabel.setText(Double.toString(exp.evaluate()));}//evaluates the equation and prints it to the textview
                catch(Exception e)
                {
                Toast.makeText(getApplicationContext(), "Not a valid input", Toast.LENGTH_SHORT).show();
            }
            }
        });
        presenter.onCreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calculator, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.action_reset:
                presenter.onResetSelected();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
