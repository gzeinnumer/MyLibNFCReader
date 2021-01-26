package com.gzeinnumer.mylibnfcreader.helper;

import android.app.Activity;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;

public class NFCTool {
    public static boolean CheckNFCHardware(Activity activity) {
        NfcManager manager = (NfcManager) activity.getSystemService(Context.NFC_SERVICE);
        NfcAdapter adapter = manager.getDefaultAdapter();
        if (adapter != null && adapter.isEnabled())
            return true;
        else
            return adapter != null && !adapter.isEnabled();
    }
}
