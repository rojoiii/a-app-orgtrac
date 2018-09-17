In order to generate the application binary file (.apk) that we will publish to the Google Play Store we need to create a Keystore that we will use in Android Studio to digitally sign the binary file. The keystore file can be stored anywhere but I advise storing the keystore file, keystore password, keystore alias, and keystore alias password in a secure location NOT in the project.

The keystore we use must be useßd every time the application binary is generated. The only way to update the application binary in the Google Play Store requires uploading a new binary signed by the same signature file. It's important to protect this keystore and the data associated with it since it is the only way to update the binary in the store and it can be used nefariously if a bad party gets a hold of it.

We will generate the keystore and binary using Android Studio with our project opened.

### Generating Signature Certificate (The Keystore) and Generating Application Binary
***
The process of building an application binary includes signing it with a keystore. During the process of building the binary we have the ability to create a new keystore or using an existing keystore. The process will always be the same with the exception of the first time where we will create the new keystore. Subsequent binary generation for updates will involve selecting the keystore we created the first time.

We start by selecting _Build_ then choosing _Generate Signed Bundle / APK..._ in the dropdown.

![Build Dropdwon](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_01.png)

We will be shown the **Generate Signed Bundle or APK** dialog. We will start by choosing _APK_ then clicking _Next_.

![Generate Signed Bundle or APK - Choose APK](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_02.png)

The first time around we will need to create our organizaiton's keystore by clicking _Create new..._. If you have already created a keystore previously this screen will already be populated with the correct values or you will need to select _Choose existing_ and enter the values you created in the _Create new..._ steps that follow.

![Generate Signed Bundle or APK - Choose Create New](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_03.png)

We will now see the **New Key Store** dialog. Here we will enter all the required information for the keystore, the majority of the fields are arbitrary and can be anything but you should enter values that match your organization. In _Key store path_ be sure to pick a location that is secure and a name that makes sense to you, the example in the image is a good choice, do not use spaces, and preferably pick a location NOT in the project directory. You can leave _Validity (years)_ at 25 as this is the standard value. _Country Code (XX)_ for the United States of America is 01. The most important parts of this are the _Keystore password_ (first password on the screen), _Alias_, and the _Alias Password_ (second password on the screen). These are the values that you must know when choosing the keystore to sign the application binary with. These values should be saved in a safe location and protected. When you are done filling in the fields click _OK_, this will craete the keystore for you in the location you seleceted in _Key store path_. If there are any issues with what you have entered you will be prompted to make the appropriate changes.

![New Key Store](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_04.png)

Once you have created you new keystore, or selected you existing keystore and entered in the values, you should see **Generate Signed Bundle or APK** screen look similar to the image below. Go ahead and check _Remember passwrods_ then click _Next_.

 ![Generate Signed Bundle or APK - Select Keystore](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_05.png)

We are now at the final step, we will use the default values for _Destination Folder_ and _Build Type_. Check the V2 option for _Signature Versioins_. Now all we have to do is click _Finish_,

![Generate Signed Bundle or APK - Finish](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_06.png)

Android Studio will generate the signed application binary for you in the folder shown in _Destination Folder_ under the sub-folder release, the signed application binary will have the name `app-release.apk`, this is the file we will upload to the Google Play Store.

![Signed application binary location](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_07.png)

Once Android Studio completes generating the signed application binary you may be able to launch directly to the folder containing the `.apk` file by clicking the _locate_ text on the **Generate Signed APK** notification if it is shown.

![Generate Signed APK notification](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/sig_build/sig_build_08.png)

[**NEXT STEP:** Publishing the binary to the Google Play Store](https://github.com/rojoiii/a-app-orgtrac/wiki/Publishing-the-binary-to-the-Google-Play-Store)
