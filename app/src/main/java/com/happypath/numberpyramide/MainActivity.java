package com.happypath.numberpyramide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button result;
    EditText numberCount;
    EditText numbers;
    EditText resultText;
    ArrayList<Integer> integers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberCount = (EditText) findViewById(R.id.editText);
        numbers = (EditText) findViewById(R.id.editText2);
        resultText = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);
        result = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (numberCount.getText().toString().length() > 0) {
                                              integers = Utils.randomArray(Integer.parseInt(numberCount.getText().toString()), 0, 39);
                                              numbers.setText(TextUtils.join(", ", integers));
                                          }
                                      }
                                  }
        );

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pyramide = Utils.calculatePyramide(Utils.calculatePyramideRow(integers));
                resultText.setText(pyramide.toString());
            }
        });
    }
}
