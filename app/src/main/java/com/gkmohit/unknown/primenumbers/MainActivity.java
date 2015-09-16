package com.gkmohit.unknown.primenumbers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayAdapter myArrayAdapter = null;
    private ArrayList myFactorList = null;
    private ListView myListView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void checkForPrime(View view){

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        Model model = new Model();
        TextView resultTV = (TextView) findViewById(R.id.result);
        EditText inputET = (EditText) findViewById(R.id.inputText);
        ListView factorList = (ListView) findViewById(R.id.factorList);
        StringBuffer resultString = new StringBuffer();
        int inputNumber;
        try {

            inputNumber = Integer.parseInt(inputET.getText().toString());
            if (inputNumber == 0 || inputNumber == 1){
//                resultString.append(inputNumber + " is neither a prime number nor a composite number.");
                resultTV.setText(resultString.toString());
            }
            else if (inputNumber == 2){
//                resultString.append(inputNumber + " is a prime number.");
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
                myListView = (ListView) findViewById(R.id.factorList);
                myFactorList = model.getArrayList();
                myFactorList.add(inputNumber);
                myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myFactorList);
                myListView.setAdapter(myArrayAdapter);

            }
            else{
                try{
                    myArrayAdapter.clear();
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
                myArrayAdapter.clear();
            } catch (NullPointerException exception){

            }
            resultTV.setText("Please enter an integer you wish to check for.");
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
