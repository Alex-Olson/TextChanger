package com.example.angel.textchanger;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class ResultsDialog extends DialogFragment {

    interface resultsDialogListener{
        void userClickedOK();
    }

    resultsDialogListener mListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mListener = (resultsDialogListener) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        Bundle args = getArguments();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog = builder.setMessage(args.getString("Display String", "oops"))
                .setTitle("Your emphasised text is...")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.userClickedOK();
                    }
                })
                .create();
        return dialog;
    }
}
