package com.gzeinnumer.mylibnfcreader.helper;

public interface NFCCallBack {
    void callBack(String idHex, String idReversedHex, String idDec, String idReversedDec);
}
