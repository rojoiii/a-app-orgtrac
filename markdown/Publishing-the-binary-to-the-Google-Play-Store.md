We are finally at the last step, publishing the application to the Google Play Store. At this point there are a few things you need to insure you have ready. First is you will want to log into your Google account and go to the [Google Play Console](https://play.google.com/apps/publish) where we will be walking through the process of creating a Google Play Store listing and uploading our signed binary file.

This is quite a long process and will take some time to complete but we will walk through each step. Now, let's get to it!

### Pulblishing in the Google Play Store
***
When we log into the Google Play Console for the first time we'll land on the default Dashboard landing page. To get the process started we will click _PUBLISH AN ANDROID APP ON GOOGLE PLAY_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_01.png)

This will cause a the **Create application** dialog to show. Leave the _Default language_ as is. The _Title_ field is what will be displayed in the Google Play Store as the name of your application. Simply enter what you wish to use and click _CREATE_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_02.png)

Now you will be taken to the **Store listing** section of the Google Play Console. You'll notice that the value you entered on the **Create application** dialog is populated in the _Title_ field here. Enter your application's _Short description_ and _Full description_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_03.png)

We will now need to scroll until we are able to see the _Graphic Assets_ sub-section. Within this section we will upload a minimum of two _Screenshots_ of the application, a _Hi-res icon_, and a _Feature Graphic_. Follow the directions [here](https://developer.android.com/studio/debug/am-screenshot) to create the screenshots. I recommend you take a screenshot of the Landing Page and up to 7 screenshots of the most interesting/useful Main Pages. You are free to create the graphics for the _Hi-res icon_ and _Feature Graphic_. Within the project directory I have created a template images for both that you can modify and save as well as a default template for both. These can be found under `[Project Directory]/images/store/`. The template images are named `hi_res_icon.png` and `feature_graphic.png`. The default images are named `hi_res_icon_android.png` and `feature_graphic_android.png`. You will also notice there are two screenshot examples, `screenshot_landing_screen.png` and `screenshot_main_screen.png`, feel free to use any of these images, including the screenshots, just keep in mind that the screenshots, icon, and feature graphics should match your application. You can change these later.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_04.png)

Once you have created, modified, and/or selected all the required images you should see something like this.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_05.png)

We will now need to scroll until we are able to see the _Categorization_ sub-section, we may need to scroll more to see the _Contact details_ and _Privacy Policy_ sub-sections as well. Under _Categorization_ you will need to select an _Application type_ and _Category_ that best fit your application, since this may change depending on your organization it is up to you to choose the values that best fit. Under _Contact details_ under a _Website_ if you have one and enter an _Email_ that is appropriate. Under _Privacy Policy_ we will simple check _Not Submitting a privacy policy URL at this time_, if you already have one available enter it's URL. Click _SAVE DRAFT_ so we can continue to the next section.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_06.png)

We will now navigate to the **App releases** section. We will want to click the menu 'hamburger' on the upper left to show the sidebar if it is hidden and select _App releases_. Throughout the rest of this wiki page I will keep the sidebar closed, only opening it to navigate between sections, then close it again. You are free to keep it open or close it, simply click the menu 'hamburger' to open/close it as needed.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_07.png)

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_09.png)

Now you will be on the **App releases** section of the Google Play Console. Here we will click _Manage_ under the _Production_ sub-section.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_10.png)

On the next screen we will click _CREATE RELEASE_ to launch the process of defining our application release.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_11.png)

On the next screen we will begin defining our application release. The first thing we will do is click _OPT-OUT_ for the _App Signing by Google Play_. This is a feature will not be making use of at the moment for this project.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_12.png)

You will be prompted with the **Opting out of Google Play App Signing** dialog, simply click _CONFIRM_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_13.png)

It's now time to upload the signed application binary we generated earlier, we will do this by clicking _Browse Files_ under the _Android App Bundles and APKs to add_. Navigate to, and select, the signed application binary you generated, the file location should look like this: `[Project Directory]/app/release/app-release.apk`

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_14.png)

Once the APK has been uploaded you will see an entry for it under the _Android App Bundles and APKs to add_ and default values will be added for the _Release name_ and _What's new in this release?_ sections. Leave the _Release name_ value as is and you can update the _What's new in this release?_ value if you would like to. Then click _SAVE_

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_15.png)

Now we will need to navigate to the **Content rating** section. Remember we can access this and other sections through the sidebar by clicking the 'hamburger' menu button in the top right. We will begin the **Content rating** questionnaire by clicking _CONTINUE_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_19.png)

Now you will be walked through the process of rating your organizations application. Since each organization and the content its application will have varies I will not walk through these options. Instead you will need to enter the email you wish to use then read the available options, choose the one that best fits your organization, and proceed to answer the questions accordingly.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_20.png)

Once you answered all the required questions for the category you chose you will need to save the questionnaire by clicking _SAVE QUESTIONNAIRE_ at the bottom of the page.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_21.png)

The last step for Content Rating is to calculate the rating. Once you have saved your questionnaire and are confident in the way you have answered all the questions simply click _CALCULATE RATING_ at the bottom of the page.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_22.png)

Once the rating is calculated you will be shown a content rating summary based on the category you chose and how you answered the questions. The screen will appear similar to the one below. If you seen something that doesn't appear to be correct you can click _GO BACK_ to adjust your choices and answers. Assuming everything is as you would expect click _APPLY RATING_ to save this rating to your store listing.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_23.png)

Now we will need to navigate to the **Pricing & distribution** section. We will start by selecting the countries you want your application available in under the _Countries_ section, I would suggest clicking only the country you are in unless there is an obvious need to select additional countries. Once you select the countries you want your application available in go ahead and click _HIDE COUNTRIES_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_26.png)

Next you will need to select 'Yes' or 'No' accordingly for _Primarily Child-Directed_, just be sure to pick the option that applies best. Under _Contains ads_ select 'No, it has no ads' since the OrgTrac codebase specifically excluded all ad features.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_27.png)

We will ignore the _Device Categories_ and _User programs_ sections. You may have to check _Content guidelines_ and _US Exportlaws_ in the _Consent_ section. Once done click _SAVE DRAFT_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_29.png)

Now we will need to navigate back to the **App releases** section. Once here we'll click _EDIT RELEASE_, this will allow us to complete the release now that we've completed all the required information.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_32.png)

On the next screen scroll down to the bottom and click _REVIEW_, you'll be able to see a summary of the release.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_33.png)

The next screen is the **Confirm rollout to production 0.0.1** screen. This is the final step before the application will be made available on the Google Play Store. Typically the application will roll out in phases, meaning it will become available over time across the countries you selected earlier. Rollouts also do not happen immediately so it may take time before your application is available to everyone. To start the rollout process click the _START ROLLOUT TO PRODUCTION_ button and you application will begin to go live!

`NOTE:` You may have seen a notice on several screens stating that your payment is still processing with wording that starts similarly to "Your payment is under process...". If this message is still showing for you you may need to wait for your payment to complete processing before you can click _START ROLLOUT TO PRODUCTION_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_34.png)

You will get one final confirmation dialog asking if you wish to make the application available to all users on the Play Store. Of course you do! Click _CONFIRM_!

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_35.png)

Holy Molly! Can you believe it? You now have an application going live in the Google Play Store! **CONGRATS!** You will now be able to see the application **Dashboard** where you'll be able to see a lot of interesting information about your application including installs/uninstalls, ratings, crashes, and a bunch more.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/publish/publish_37.png)

**Now you can update your application data in Contentful and see all the changes in the application that is now available in the Google Play store**

**Just go back to the [Using Contentful to Update your Application Data](https://github.com/rojoiii/a-app-orgtrac/wiki/Using-Contentful-to-Update-your-Application-Data) article to remember how to make the application your own!**
