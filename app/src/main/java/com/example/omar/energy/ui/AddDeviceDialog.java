package com.example.omar.energy.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.omar.energy.R;

/**
 * Created by omar on 07/07/17.
 */

public class AddDeviceDialog extends DialogFragment {



    public interface ShareDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String name, int kwh, int usageTime);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    ShareDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (ShareDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ShareDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogCustom);

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.activity_register, null);
        final EditText etUsername = (EditText) dialogView.findViewById(R.id.textInputEditTextName);
        final EditText etEmail = (EditText) dialogView.findViewById(R.id.textInputEditTextEmail);
        final EditText etPassword = (EditText) dialogView.findViewById(R.id.textInputEditTextPassword);

        builder.setView(dialogView)
                .setTitle("Title")
                .setPositiveButton("share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String user = etUsername.getText().toString();
                        int kwh = Integer.parseInt(etEmail.getText().toString());
                        int usageTime = Integer.parseInt(etPassword.getText().toString());

                        mListener.onDialogPositiveClick(AddDeviceDialog.this, user,kwh,usageTime);

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNegativeClick(AddDeviceDialog.this);
                        AddDeviceDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}