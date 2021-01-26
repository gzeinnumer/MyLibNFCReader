package com.gzeinnumer.mylibnfcreader.helper;

import android.nfc.Tag;

public interface NFCCallBack {
    void callBack(String idHex, String idReversedHex, String idDec, String idReversedDec);
}
