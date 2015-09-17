package com.gkmohit.unknown.primenumbers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayAdapter mArrayAdapter = null;
    private ArrayList mFactorList = null;
    private ListView mListView = null;
    private ColorWheel mColorWheel = new ColorWheel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setColors();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void checkForPrime(View view){


        //Hiding the keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        //Changing colours on button click
        setColors();

        Model model = new Model();
        TextView resultTV = (TextView) findViewById(R.id.result);
        EditText inputET = (EditText) findViewById(R.id.inputText);

        StringBuffer resultString = new StringBuffer();
        int inputNumber;
        try {

            inputNumber = Integer.parseInt(inputET.getText().toString());
            if (inputNumber == 0 || inputNumber == 1){
                //resultString.append(inputNumber + " is neither a prime number nor a composite number.");
                resultTV.setText(resultString.toString());
            }
            else if (inputNumber == 2){
                //resultString.append(inputNumber + " is a prime number.");
                resultTV.setText(resultString.toString());
            }
            else{
                int counter;
                for( counter = 2; counter < inputNumber ;  counter++){
                    if( inputNumber % counter == 0){
                        model.addFactor(counter);
                    }
                }
            }
            resultTV.setText(model.getList());
            if(model.size() > 1){
                Toast.makeText(view.getContext(), "Calculating the factors of " + inputNumber, Toast.LENGTH_SHORT).show();
                resultTV.setText(inputNumber + " is a composite number. The factors of " + inputNumber + " " +
                        "are : \n");
                mListView = (ListView) findViewById(R.id.factorList);
                mFactorList = model.getArrayList();
                mFactorList.add(inputNumber);
                mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mFactorList);
                mListView.setAdapter(mArrayAdapter);

            }
            else{
                try{
                    mArrayAdapter.clear();
                } catch (NullPointerException e){

                }
                if (inputNumber == 0 || inputNumber == 1){
//                    Toast.makeText(view.getContext(), "You have entered a special number.", Toast.LENGTH_LONG).show();
                    resultString.append(inputNumber + " is neither a prime number nor a composite number.");
                    resultTV.setText(resultString.toString());
                }else{
                    Toast.makeText(view.getContext(), "You have entered a prime number.", Toast.LENGTH_SHORT).show();
                    resultTV.setText(inputNumber + " is a prime number. The only factors are 1 and \t" + inputNumber + ".");
                }
            }
        }
        catch (NumberFormatException e){
            try{
                mArrayAdapter.clear();
            } catch (NullPointerException exception){

            }
            resultTV.setText("Please enter an integer you wish to check for.");
        }
    }

    /**
     * Method to set the colors on create.
     */
    public void setColors() {
        TextView resultTV = (TextView) findViewById(R.id.result);
        EditText inputET = (EditText) findViewById(R.id.inputText);
        RelativeLayout backgroundLayout = (RelativeLayout) findViewById(R.id.backgroundLayout);
        Button checkButton = (Button) findViewById(R.id.checkInput);
        ListView factorList = (ListView) findViewById(R.id.factorList);
        LinearLayout inputLayout = (LinearLayout) findViewById(R.id.inputLayout);

        //Changing the background colors
        int color = mColorWheel.getColor();
        inputET.setTextColor(color);
        checkButton.setTextColor(color);
        resultTV.setBackgroundColor(color);
        factorList.setBackgroundColor(color);
        inputLayout.setBackgroundColor(color);
        backgroundLayout.setBackgroundColor(color);

    }
}
