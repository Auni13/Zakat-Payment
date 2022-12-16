package com.example.zakatpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences sharedpreferences;
    Button btnkeep, btnwear;
    Button btnclear;
    EditText goldWeight;
    EditText goldValue;
    TextView tvoutputzp, tvoutputvg, tvoutputtz;
    String Shared_pref = "sharedPrefs";
    String gold_Weight = "weight";
    String gold_Value = "currentvalue";
    double weight,value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        goldWeight = (EditText) findViewById(R.id.Weight);
        goldValue = (EditText) findViewById(R.id.Value);
        sharedpreferences = getSharedPreferences(Shared_pref, Context.MODE_PRIVATE);
        goldWeight.setText(sharedpreferences.getString(gold_Weight,""));
        goldValue.setText(sharedpreferences.getString(gold_Value,""));

        btnkeep = (Button) findViewById(R.id.btnkeep);
        btnwear = (Button) findViewById(R.id.btnwear);
        btnclear = (Button) findViewById(R.id.btnclear);

        btnkeep.setOnClickListener(this);
        btnwear.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        tvoutputtz = (TextView) findViewById(R.id.tvoutputtz);
        tvoutputvg = (TextView) findViewById(R.id.tvoutputvg);
        tvoutputzp = (TextView) findViewById(R.id.tvoutputzp);


    }

        @Override
        public void onClick(View view) {
            double totaluruf, totalvalue, totalzktpay, totalzakat;
                switch(view.getId()) {
                    case R.id.btnkeep:
                        try{
                            weight = Double.parseDouble(goldWeight.getText().toString());
                            value = Double.parseDouble(goldValue.getText().toString());
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(gold_Weight,goldWeight.getText().toString());
                            editor.putString(gold_Value,goldValue.getText().toString());
                            editor.apply();

                        } catch (NumberFormatException nfe) {
                            Toast.makeText(this, "Please enter a number ", Toast.LENGTH_SHORT).show();
                        }
                            totaluruf = weight - 85;
                            totalvalue = weight * value;
                            totalzktpay = (totaluruf) * value;
                            totalzakat = 0.025 * totalzktpay;
                            if (totaluruf <= 0) {
                                tvoutputvg.setText("The Total Value Of Gold: RM" + totalvalue);
                                tvoutputzp.setText("Zakat payable: RM0");
                                tvoutputtz.setText("Total Zakat: RM0");
                            } else {
                                tvoutputvg.setText("The Total Value Of Gold: RM" + totalvalue);
                                tvoutputzp.setText("Zakat payable: RM" + totalzktpay);
                                tvoutputtz.setText("Total Zakat: RM" + totalzakat);
                            }
                            break;

                    case R.id.btnwear:
                        try {
                            weight = Double.parseDouble(goldWeight.getText().toString());
                            value = Double.parseDouble(goldValue.getText().toString());
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(gold_Weight,goldWeight.getText().toString());
                            editor.putString(gold_Value,goldValue.getText().toString());
                            editor.apply();


                        } catch (NumberFormatException nfe) {
                            Toast.makeText(this, "Please enter a number ", Toast.LENGTH_SHORT).show();
                        }
                            totaluruf = weight - 200;
                            totalvalue= weight*value;
                            totalzktpay= (totaluruf)*value;
                            totalzakat = 0.025*totalzktpay;

                            if(totaluruf<= 0) {
                                tvoutputvg.setText("The Total Value Of Gold: RM" + totalvalue);
                                tvoutputzp.setText("Zakat payable: RM0");
                                tvoutputtz.setText("Total Zakat: RM0");
                            } else{
                                tvoutputvg.setText("The Total Value Of Gold: RM" + totalvalue);
                                tvoutputzp.setText("Zakat payable: RM" + totalzktpay);
                                tvoutputtz.setText("Total Zakat: RM" + totalzakat);
                            }
                            break;
                    case R.id.btnclear:
                        goldWeight.setText("");
                        goldValue.setText("");
                        tvoutputvg.setText("");
                        tvoutputzp.setText("");
                        tvoutputtz.setText("");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + view.getId());
                }
            }



        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);

            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.about:
                //Toast.makeText(this,"This is about", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.settings:
                Toast.makeText(this,"This is settings", Toast.LENGTH_LONG).show();
                break;

            case R.id.search:
                Toast.makeText(this,"This is search", Toast.LENGTH_LONG).show();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return super.onOptionsItemSelected(item);
        }
}