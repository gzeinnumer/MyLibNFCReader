package com.gzeinnumer.mylibnfcreader.lib;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.gzeinnumer.mylibdialog.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.mylibnfcreader.R;

class DialogActiveNFC {

    public DialogActiveNFC(Activity activity) {
        new ConfirmDialog(((FragmentActivity) activity)
                .getSupportFragmentManager())
                .setBtnOkTitleColor(ContextCompat.getColor(activity.getApplicationContext(), R.color.colorPrimary))
                .setBtnCancelTitleColor(ContextCompat.getColor(activity.getApplicationContext(), R.color.colorPrimary))
                .setTitle("Warning")
                .setContent("NFC not active, enable NFC now?")
                .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed() {
                        activity.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                    }
                }).show();
    }
}
