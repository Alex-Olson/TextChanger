package com.example.angel.textchanger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
//TODO: figure out why i cant pull stuff from arraylist to change string

public class MainActivity extends AppCompatActivity
implements EmphasisDialog.emphasisDialogListener, ResultsDialog.resultsDialogListener  {
    Button emphasisButton;
    EditText userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = (EditText) findViewById(R.id.user_text);

        emphasisButton = (Button) findViewById(R.id.emphasise_button);
        emphasisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmphasisDialog dialog = new EmphasisDialog();
                dialog.show(getFragmentManager(), dialog.getClass().getName());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    @Override
    public void onSelection(ArrayList arrayList) {
        String displayString = userText.getText().toString();

        if (arrayList.size() != 0){
            //the integer for the uppercase option

              if (arrayList.contains(0) ){
                    displayString = displayString.toUpperCase();
                }
                //the integer for the ! option
                if (arrayList.contains(1)) {
                    displayString = displayString + "!!!!";
                }
                //the integer for the :) option
                if (arrayList.contains(2)) {
                    displayString = displayString + " :)";
                }
            }

            ResultsDialog dialog = new ResultsDialog();
            Bundle dialogArgs = new Bundle();
            dialogArgs.putString("Display String", displayString);
            dialog.setArguments(dialogArgs);
            dialog.show(getFragmentManager(), dialog.getClass().getName());
        }






    @Override
    public void userClickedOK() {

    }
}
