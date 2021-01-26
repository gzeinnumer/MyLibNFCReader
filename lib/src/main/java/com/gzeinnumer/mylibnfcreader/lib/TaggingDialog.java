package com.gzeinnumer.mylibnfcreader.lib;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gzeinnumer.mylibdialogfragment.MyLibDialog;
import com.gzeinnumer.mylibnfcreader.R;

class TaggingDialog extends MyLibDialog {

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private Activity activity;

    public static TaggingDialog newInstance(Activity activity) {
        return new TaggingDialog(activity);
    }

    public TaggingDialog(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tagging_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Error if no NFC found in this device
        nfcAdapter = NfcAdapter.getDefaultAdapter(requireActivity());
//        if (nfcAdapter == null) {
//        }

        // Pending Intent
        pendingIntent = PendingIntent.getActivity(requireContext(), 0, new Intent(requireContext(), activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

    }

    @Override
    public void onPause() {
        super.onPause();

        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(requireActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!nfcAdapter.isEnabled()) {
            new StartNFCTagging(requireActivity(), null);
        } else {
            nfcAdapter.enableForegroundDispatch(requireActivity(), pendingIntent, null, null);
        }
    }
}
