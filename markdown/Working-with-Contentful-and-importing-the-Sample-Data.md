We will need to create a space in Contentful that we will use to store all our application data. We will import all the necessary models and sample data from the OrgTrac Contentful space into this space and use the data as the building blocks for our own application. To start off login to Contentful using the account you already created.

### Creating and Preparing the Space
***
The first thing we will need to do is create a new space within Contentful that we will use for your organization. You'll need to click the project menu in the upper left.

![Click Hamburger](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-1.png)

This will show the your spaces menu. You'll need to click _+ Add space_.

![Click App Space](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-2.png)

When prompted with the **Choose the space type** screen be sure to choose the _Free_ tier, you should have 1 available as seen in the screenshot.

![Click Free Space](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-3.png)

When prompted with the **Choose a name** screen simply enter anything that makes sense to you for the name, this can be changed later if needed, choose _Create an empty space_, and then click _Proceed to confirmation_ when done.

![Enter name, no content, proceed](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-4.png)

Great. We are now ready to create the empty space to import the OrgTrac data into, just click _Confirm and create space_

![Enter name, no content, proceed](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-5.png)

### Importing OrgTrac Models and Data
***
In order to import the models and data into our project we will need to create an API token that we will use in conjunction with our space ID to migrate the data. We need to navigate to the APIs section within Contentful, we do this by selecting _API keys_ under the _Settings_ menu.

![launch A P I keys](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-6.png)

Once on the **APIs** screen we'll select the _Content management tokens_ tab and click the _Generate personal token_ button.

![generate personal token](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-7.png)

You will be shown the **Generate Personal Access Token_** dialog. We will enter the _Token name "temp" and then click _Generate_. We are naming the token "temp" since we will delete the token once done importing the data from the OrgTrac space.

![generate temp token](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-8.png)

The next screen will give you the opportunity to copy the token to your clip-board, make sure to hit the copy button and save this token somewhere so you can access it later, then click _Done_. Once you close this dialog you will not be able to copy the token again. If you lose the token don't worry, you can always follow the same steps to create another one.

![copy temp token](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-9.png)

In order to import the models and data into our project we will also need the space id that we will use in conjunction with our API token to migrate the data. We need to navigate to the **General settings** screen within Contentful, we do this by selecting _General settings_ under the _Settings_ menu.

![copy temp token](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-10.png)

On the **General Settings** screen you will find the _Space ID_, save this with the API token for use in the next steps.

![copy temp token](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-11.png)

The last step to import OrgTrac into your project includes installing [node.js](https://nodejs.org/en/download/), [npm](https://www.npmjs.com/get-npm), and [Importing and Exporting Content](https://www.contentful.com/developers/docs/tutorials/general/import-and-export/). You do not need to use these tools beyond installing them, we will simply use the _importer.jar_ application to import OrgTrac's data into your organizations project.

We will launch the application with **Terminal**, or **cmd-line**, using the command _java -jar_ as shown below. You can find _importer.jar_ in the project directory you downloaded OrgTrac to in with GitHub Desktop. When launching the _importer.jar_ from the **terminal** it's easiest to type "java -jar " then open the project directory and drag-and-drop the _importer.jar_ from the folder onto the *terminal*.

![java jar command](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-12.png)

Simply enter you _Space ID_ and _API Token_ you saved earlier, select _Models & Data_, and click _import_.

![importer application](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_working_with/contentful-working-with-13.png)

Once this is complete you will have the OrgTrac data imported into your organization's Contentful space. Go ahead and move on to updating the project in Android Studio.

[**NEXT STEP:** Using Android Studio to update the project for your organization](https://github.com/rojoiii/a-app-orgtrac/wiki/Using-Android-Studio-to-update-the-project-for-your-organization)
