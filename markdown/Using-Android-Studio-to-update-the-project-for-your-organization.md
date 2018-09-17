We will be using Android Studio to run the OrgTrac application and to run your organization's application once we have updated all the appropriate configuration files. We will need to update a few things in order to convert the OrgTrac application into you own. The required updates we will need to do include updating the package name, application name, and Contentful keys. Optionally we can also update the application colors, error messaging, and application icon.

Before we get started we will first need to open Android Studio and configure it to run the OrgTrac application. Once we've done that and verified that we can run the OrgTrac application we will walk through the updates to make the project into our organization's application.

### Open OrgTrac in Android Studio
***
We will start with opening Android Studio and configuring it to work properly with our project. Launch Android Studio from the location it was installed in. You will be prompted to complete installation. Simply choose the option that applies to you, likely _Do not import settings_ and click _OK_.

![Import Settings](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_01.png)

From here Android Studio will begin the Setup Wizard Process, let's walk through it.

On the **Welcome** screen we will simply click _Next_.

![Wizard Welcome](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_02.png)

On the **Install Type** screen we will choose just choose the _Standard_ installation and click _Next_.

![Wizard Install Type](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_03.png)

On the **Select UI Theme** screen simply pick the theme you like most, I prefer the _Darcula_, and click _Next_.

![Wizard Select UI Theme](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_04.png)

On the **Verify Settings** screen simply click _Finish_, it should look similar to this.

![Wizard Verify Settings](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_05.png)

Clicking _Finish_ on the **Verify Settings** will begin to download all the libraries and components needed by Android Studio. When the process begins you'll see the **Downloading Components** screen, once this process finishes you will simply click _Finish_ to continue.

![Wizard Verify Settings](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_06.png)

Now you are ready to use Android Studio and will be prompted with the **Welcome to Android Studio** screen. Here you will select the _Open an existing Android Studio project_ option, navigate to the folder you downloaded the project to using GitHub Desktop.

![Welcome to Android Studio](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_07.png)

Now you will land on the **Project Screen** in Android Studio, this will actually be the main screen you will use while within Android Studio. However, for the time being we still need to update the project in order to use Android Studio to Run and Update OrgTrac. We'll do this by clicking the _Install Build Tools 28.0.2 and sync project_ text to initiate installing the needed build tools. The portion with _28.0.2_ may change when OrgTrac is updated so don't worry if this version number does not match what you see. Additionally, you can hide the _What's New_ panel by clicking the hide panel button.

![OrgTrac Project Screen](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_08.png)

When prompted with the **License Agreement** Screen you will need to click the _android-sdk-license_, _Accept_, then _Next_ to accept the agreement and continue.

![License Agreement](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_09.png)

Once the **Component Installer** completes you'll be able to click _Finish_ to continue.

![Component Installation](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_10.png)

You may be prompted with the _Android Gradle Plugin Update Recommended_ dialog, if so you'll want to update to the latest, just click _Update_ and Android Studio will make the appropriate adjustments.

![Gradle Plugin Update](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_11.png)

### Run OrgTrac in Android Studio
***
Now that we have Android Studio completely setup we'll be able to launch the OrgTrac application. We'll start by clicking _Run selected configuration_ button in Android Studio.

![Android Studio - Launch Emulator](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_12a.png)

This will launch the **Select Deployment Target** dialog. This is where we will be able to choose an Emulator to run the application on. But first we will need to configure an Emulator to use. In order to start the process of creating an emulator click _Create New Virtual Device_.

![Select Deployment Target](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_17.png)

On the **Select Hardware** screen we will choose the emulator configuration we want to use. Since I am a fan of Google and the Phones they produce we will create an emulator for a Google Pixel 2 XL phone then click _Next_.

![Select Hardware Target](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_18.png)

On the **System Image** screen we will need to select the _Pie_ option to download the system image allowing us to launch the emulator.

![Select Hardware Target](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_19.png)

This will start another **License Agreement** screen, we'll select the license, _Accept_, then _Next_ to accept the agreement and continue.

![License Agreement](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_20.png)

Once the **Component Installer** completes you'll be able to click _Finish_ to continue and go back to the **System Image** screen.

![Component Installation](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_21.png)

Now that we are back on the **System Image** screen with the _Pie_ image selected we will be able to select _Next_ and continue setting up the emulator.

![Component Installation](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_22.png)

The last part of setting up the emulator is on the **Android Virtual Device (AVD)** screen. The default settings on this screen are fine so just click _Finish_.

![Component Installation](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_23.png)

Once we've completed this we'll be taken back to the **Select Deployment Target** where we will now be able to select _Pixel XL 2 API 28_ and click _OK_.

![Select Deployment Target](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_24.png)

This will cause the launch of the emulator. Once the emulator is fully loaded the OrgTrac application will be installed on it and launched automatically.

![OrgTrac Application](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_25.png)

Awesome!! Now you are ready to update OrgTrac for your own organization!

### Make Required Changes for Our Organization
***
Now we are ready to make OrgTrac our own! We'll need to change several files in order to do this so we will start by opening all these files in Android Studio. The files we will be opening are _build.gradle (Module: app)_, _strings.xml_, _contentful.xml_, and _colors.xml_. Just double click each to open them in new tabs in Android Studio.

![Android Studio - Select Files](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_12b.png)

The first file we will need to change is the _build.gradle (Module: app)_ file. We need to change `applicationId`, this is the unique package name that the Google Play Store will use to distinguish the organization’s application from all the other applications in the store. This value must be changed and must be unique. Typically it's a reverse url, for example if OrgTrac had a website url hosted on CSUN it might be 'orgtrac.csun.edu' so the `applicationId` would be 'edu.csun.orgtrac' as it is for the OrgTrac application. This value and what it should be is more or less arbitrary, simply needing to be unique, but by convention follows this example.

![build.gradle (Module: app)](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_13a.png)

Once you update the <applicationId> an action bar with _Sync Now_ will appear. You need to click this to cause Android Studio to update the project accordingly for you organization's application. This process can take a little time so be patience and wait for Android Studio to complete the Sync process before continuing.

![build.gradle (Module: app) Sync](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_13b.png)

The next file we will need to change is the _string.xml_ file. We need to change `app_name`, this is the name that the user will see under the icon once the application is installed. This is normally a short name consisting of 10 or less characters. The value for `app_name` can be as long as you want but should be kept short so the user can see it, if it's too long it will be cut off in the application tray.

![string.xml](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_14a.png)

The last file we will need to change is the _contentful.xml_ file. We need to change `cf_cda_token` and `cf_space_id`, these are the values that the application uses to synchronize the data from the Contentful API with the application.

![contentful.xml](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_15.png)

In order to get these files we will need to go back to Contentful and click _API keys_ under _Settings_.

![click A P I keys under settings](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_26.png)

On the _APIs_ screen under the _Content delivery / preview tokens_ tab click _Example Key 1_

![content delivery choices](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_27.png)

We will use the values on the _Example Key 1_ screen to update the corresponding values in the _contentful.xml_ file in Android Studio.

![content delivery choices](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_28.png)

Now you are done. Believe it or not OrgTrac is now completely your own. If you want to make the optional changes just continue to the next step _**Make Optional Changes for Our Organization**_. If you really just want to see your organizations application work head to the _**Run Your Organization's Application in Android Studio!!**_ section below.

### Make Optional Changes for Our Organization
***

Updating your application colors is pretty straight forward but the level of customization is currently limited. There are three colors values you can change: `colorPrimary`, `colorPrimaryDark>`, and `colorAccent`. These must be hexidecimal values and are in the _colors.xml_ file. Have fun changing the colors and seeing how the application looks when you run it.

![colors.xml](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_16.png)

Additionally, you can change the text shown when the application encounters an error. These values are found in the _strings.xml_ file after the `app_name` value you changed earlier.

![string.xml](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_14b.png)

These values are shown in the application like the image below. Feel free to update them with you own attitude and style if you wish to do so.

![application error message](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_29.png)

Every application has an application icon. We can create our own using the **Configure Image Asset** wizard. We will launch it by right clicking _res_, choosing _New_ then _Image Asset_.

![Launch Image Asset Wizard](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_30.png)

Once in the **Configure Image Asset** wizard go about creating your own application icon by modifying the values in the _Foreground Layer_, _Background Layer_, and _Legacy_ tabs. Once you like what you see click _Next_, on the following screen click _Finish_. When you run your application again from Android Studio using the **Select Deployment Target** dialog the new version of the application including the new application icon will be installed on the emulator you chose.

![Launch Image Asset Wizard](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_31.png)

### Run Your Organization's Application in Android Studio!!
***

Now that you have made all the changes required to make OrgTrac your own, and maybe some of the optional changes as well, we can now launch it! As we did with OrgTrac we will launch our application by clicking Run selected configuration button in Android Studio.

![Android Studio - Launch Emulator](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_12a.png)

We'll be taken to the **Select Deployment Target** where we will select _Pixel XL 2 API 28_ and click _OK_.

![Select Deployment Target](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/using_as/using_as_24.png)

Well look at that! Now you are actually running your application!

[**NEXT STEP:** Using Contentful to Update your Application Data](https://github.com/rojoiii/a-app-orgtrac/wiki/Using-Contentful-to-Update-your-Application-Data)
