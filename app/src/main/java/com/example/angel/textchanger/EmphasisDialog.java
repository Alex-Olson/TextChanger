package com.example.angel.textchanger;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class EmphasisDialog extends DialogFragment {
    final CharSequence[] EMPHASIS_CHOICES  = {"Capitalize", "Add Exclamation Points", "Add Smiley Face"};

    ArrayList selectedChoices;

    interface emphasisDialogListener{
        void onSelection(ArrayList arrayList);
    }

    emphasisDialogListener mListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mListener = (emphasisDialogListener) activity;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        selectedChoices = new ArrayList();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog = builder.setTitle("What emphasis would you like?")
                .setMultiChoiceItems(EMPHASIS_CHOICES, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked){
                            selectedChoices.add(which);
                        } else if (selectedChoices.contains(which)){
                            selectedChoices.remove(Integer.valueOf(which));
                        }


                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onSelection(selectedChoices);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();

        return dialog;



    }


}
