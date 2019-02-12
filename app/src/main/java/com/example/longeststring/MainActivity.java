package com.example.longeststring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView longestString;
    Button btnAdd;
    EditText etWords;
    TextView tvYourWords;
    Button btnFind;
    Button btnClear;


    private List<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWords = findViewById(R.id.etWords);
        btnAdd = findViewById(R.id.btnAdd);
        tvYourWords = findViewById(R.id.tvYourWords);
        btnFind = findViewById(R.id.btnFind);
        longestString = findViewById(R.id.longString);
        btnClear = findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(this);
        btnFind.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        //String[] randomArray = {"Ben", "Bob", "David", "Freddy", "Peter", "George", "Vivian"};

        //String longest = findLongestString(randomArray);
        //longestString.setText(longest);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAdd:
                handleAddClick();
                break;
            case R.id.btnFind:
                handleFindClick();
                break;
            case R.id.btnClear:
                handleClearClick();
                break;
        }
    }

    private  void handleAddClick(){
        String word = etWords.getText().toString();
        etWords.getText().clear();
        words.add(word);
        String addList = tvYourWords.getText().toString();
        tvYourWords.setText(addList +"\n" + word);
    }

    private void handleFindClick(){
        if(!words.isEmpty()) {
            String[] randomArray = words.toArray(new String[0]);
            String longest = findLongestString(randomArray);
            longestString.setText(longest);
        }else{
            longestString.setText("There are no words to find!");
        }
        tvYourWords.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    private void handleClearClick() {
        words.clear();
        tvYourWords.setText("");
    }

}
