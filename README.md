<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibUtils/blob/master/preview/bg.jpg"/>
</p>

<h1 align="center">
    MyLibUtils
</h1>

<p align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Koltin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>NFC Reader.</p>
</p>

---
## Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:MyLibNFCReader:version'

  //required
  implementation 'com.github.gzeinnumer:MyLibDialogFragment:1.0.1'
  implementation 'com.github.gzeinnumer:MyLibDialog:2.2.1'
  implementation 'com.github.gzeinnumer:MyLibStyle:0.1.5'
}
```

## Feature List
- [x] [Check NFC Hardware (Type 1)](#check-nfc-hardware-type-1).
- [x] [Start NFC Tagging (Type 1)](#start-nfc-tagging-type-1) Open Dialog And Start Tagging.
- [x] [Combine CheckNFCHardware and StartNFCTagging (Type 2)](#combine-checknfchardware-and-startnfctagging-type-2) .
- [x] [End NFC Tagging](#convert-time-format) Get Result.

---
## USE

### Permission
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest >

    <uses-feature android:name="android.hardware.nfc" />
    <uses-permission android:name="android.permission.NFC" />

    <application>
    </application>

</manifest>
```

---
### Check NFC Hardware (Type 1)

use `CheckNFCHardware` will return `true` if NFC available.
> **Java**
```java
if (NFCTool.CheckNFCHardware(MainActivity.this)){
    Toast.makeText(this, "NFC Support", Toast.LENGTH_SHORT).show();
} else {
    Toast.makeText(this, "NFC Not Support", Toast.LENGTH_SHORT).show();
}
```

### Start NFC Tagging (Type 1)

If device have the NFC, run this code
> **Java**
```java
if (NFCTool.CheckNFCHardware(MainActivity.this)){
    new StartNFCTagging(MainActivity.this);
}
```

**Note :** Please make sure your divice have **NFC** feature before run `StartNFCTagging();`

---
### Combine [CheckNFCHardware](#check-nfc-hardware-type-1) and [StartNFCTagging](#start-nfc-tagging-type-1) (Type 2)
```java
new StartNFCTagging(MainActivity.this, new NFCErrorCallBack() {
    @Override
    public void onNotSupport(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
});
```

---
### End NFC Tagging

`@Override` funcion `onNewIntent` from `AppCompatActivity` in your activity. and use `EndNFCTagging` to get result.
```java
@Override
protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    new EndNFCTagging(intent, getSupportFragmentManager()).observer(new NFCCallBack() {
        @Override
        public void callBack(String idHex, String idReversedHex, String idDec, String idReversedDec) {
            Log.d(TAG, "onNewIntent: Hexadecimal Code          " + idHex);
            Log.d(TAG, "onNewIntent: Reversed Hexadecimal Code " + idReversedHex);
            Log.d(TAG, "onNewIntent: Decimal Code              " + idDec);
            Log.d(TAG, "onNewIntent: Reversed Decimal Code     " + idReversedDec);
        }
    });
}
```

Preview :
|<img src="https://github.com/gzeinnumer/MyLibNFCReader/blob/master/preview/example1.jpg" width="300"/>|<img src="https://github.com/gzeinnumer/MyLibNFCReader/blob/master/preview/example2.jpg" width="300"/>|<img src="https://github.com/gzeinnumer/MyLibNFCReader/blob/master/preview/example3.jpg" width="300"/>|
|---|---|---|
|Dialog Tagging|NFC feature not found in divice|Result|
---

### Customize

You can change design of the `Dialog Tagging`.
1. Make `default_tagging_dialog.xml` in `res/layout`
2. Copy this code root [default_tagging_dialog.xml](https://github.com/gzeinnumer/MyLibNFCReader/blob/master/lib/src/main/res/layout/default_tagging_dialog.xml)
3. Just Customize it

---

### Version
- **1.0.0**
  - First Release

---

### Contribution
You can sent your constibution to `branche` `open-pull`.

---

```
Copyright 2020 M. Fadli Zein
```
