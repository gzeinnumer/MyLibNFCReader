package com.gzeinnumer.mylibnfcreader.helper;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;

public class NFCBuilder {
    private NFCCallBack nfcCallBack;
    private final Intent intent;

    public NFCBuilder(Intent intent) {
        this.intent = intent;
    }

    public void observer(NFCCallBack nfcCallBack) {
        this.nfcCallBack = nfcCallBack;
        resolveIntent();
    }

    private void resolveIntent() {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {

            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String idHex = UtilsConverter.getIdHex(tag);
            String idHexReversed = UtilsConverter.getIdReversedHex(tag);
            String idDec = UtilsConverter.getIdDec(tag);
            String idDecReversed = UtilsConverter.getIdReversedDec(tag);
            nfcCallBack.callBack(idHex, idHexReversed, idDec, idDecReversed);
        }
    }
}
