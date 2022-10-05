package com.example.romanconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.romanconverter.R.id;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText number;
    private TextView roman;
    private Button convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=(EditText)findViewById(R.id.btn_nb);
        roman=(TextView)findViewById(id.btn_result);
        convert=(Button)findViewById(R.id.button1);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);//to close the keyboard
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);//to close the keyboard
                int num1=Integer.parseInt(number.getText().toString());

                List<String> letters = new ArrayList<String>();
                letters=Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L","XL" ,"X", "IX", "V", "IV", "I");
                List<Integer> numbers = new ArrayList<Integer>();
                numbers=Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
                StringBuilder roman_number= new StringBuilder();
                int num2=num1;
                while (num2>0){

                    for (int i=0; i<13 ; i++){
                        if(num2>= numbers.get(i)){
                            int max_numerator=num2/numbers.get(i);
                            for (int j=0; j<(max_numerator);j++){
                                roman_number.append(letters.get(i));
                                num2 -= numbers.get(i);

                            }


                        }


                    }
                }




                roman.setText(roman_number);
                num2=0;
                roman_number.setLength(0);

            }
        });



    }
}