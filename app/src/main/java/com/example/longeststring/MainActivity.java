package com.example.longeststring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView longestString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        longestString = findViewById(R.id.longString);

        String[] randomNames = {"Ben", "Bob", "David", "Freddy", "Peter", "George", "Vivian"};
        String longest = findLongestString(randomNames);
        longestString.setText(longest);
    }
    private String findLongestString(String[] stringArray){
        int arrayNum = 0;
        String finalAnswer = "";
        int stringLength = stringArray[0].length();
        for(int i=1; i<stringArray.length; i++){
            if(stringArray[i].length() > stringLength){
                arrayNum = i;
                stringLength = stringArray[i].length();

            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j<stringArray.length;  j++){
            if(stringArray[j].length() == stringLength){
                stringBuilder.append(stringArray[j]+" - " + stringLength);
                stringBuilder.append("\n");
            }
        }
        finalAnswer = stringBuilder.toString();
        //finalAnswer = stringArray[arrayNum]+" - " + stringLength;
        return finalAnswer;
    }
}
