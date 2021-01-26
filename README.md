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
}
```

## Feature List
- [x] [Check NFC Hardware](#convert-time-format).
- [x] [Start NFC Tagging](#convert-time-format) Open Dialog And Start Tagging.
- [x] [End NFC Tagging](#convert-time-format) Get Result.

---
## USE

### CheckNFCHardware.

use `CheckNFCHardware` will return `true` if NFC available.
> **Java**
```java
if (NFCTool.CheckNFCHardware(MainActivity.this)){
    Toast.makeText(this, "NFC Support", Toast.LENGTH_SHORT).show();
} else {
    Toast.makeText(this, "NFC Not Support", Toast.LENGTH_SHORT).show();
}
```

### StartNFCTagging.

If device have the NFC write this code
> **Java**
```java
new StartNFCTagging(MainActivity.this);
```
Example:
```java
if (NFCTool.CheckNFCHardware(MainActivity.this)){
    new StartNFCTagging(MainActivity.this);
}
```

### Combine **CheckNFCHardware** and **StartNFCTagging**
```java
findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new StartNFCTagging(MainActivity.this, new NFCErrorCallBack() {
            @Override
            public void onNotSupport(String msg) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
});
```

### End NFC Tagging

`@Override` funcion `onNewIntent` from `AppCompatActivity` in your activity.
```java
@Override
protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    new EndNFCTagging(intent).observer(new NFCCallBack() {
        @Override
        public void callBack(String idHex, String idReversedHex, String idDec, String idReversedDec) {
            Log.d(TAG, "checkForm: " + idHex);
            Log.d(TAG, "checkForm: " + idReversedHex);
            Log.d(TAG, "checkForm: " + idDec);
            Log.d(TAG, "checkForm: " + idReversedDec);
        }
    });
}
```

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
