## The Main Components of your Contentful Data

The power of OrgTrac and your project using it is the ability to easily create and modify the content that will show in it. We are able to do this using Contentful to create and modify the content we imported from the OrgTrac sample project. There are five major pieces we will use to accomplish the task of converting the data in our applications Contentful space into the data we want in our application. We discuss what the pieces are and how their appear in both Contentful and the application as well as show how all the pieces fit together allowing you to customize your organizations application data.

**The five major pieces are:**
* Assets
* Pages - _Loading, Landing, Main_
* Elements - _Image, Link, Text, YouTube Video_
* Templates - _Article, Contact Info, Location, Profile, Web_
* Reference Link

### Assets
***
The only asset currently available in OrgTrac is an image. You'll be able to upload images in Contentful that can then be used in the Loading Page, Image Element, and Profile Template. While you can upload any size image keep in mind that the application will have to download these images so keep that in mind and choose images that are not too large.

Below is how the Media asset named `Android` looks in Contentful, this is how all assets will appear when adding them. We will walk through this process in more detail in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_asset_image.png)

### The Loading Page
***
The Loading Page is the first screen that users of your application will see. There should only ever be one Loading Page called `Page - Loading` that was imported into your project from OrgTrac, you should update this Loading Page and never create your own.

Below is how the content named `Page - Loading` looks in Contentful, this is how it appears when modifying it and the associated screen in the Android application. We will walk through the process of editing it in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_page_loading.png)

### The Landing Page
***
The Landing Page is the second screen that users of your application will see and is the default entry point for the rest of the application's screens (Defined by the Main Pages). There should only ever be one Landing Page called `Page - Landing` that was imported into your project from OrgTrac, you should update this Landing Page and never create your own.

Below is how the content named `Page - Landing` looks in Contentful, this is how it appears when modifying it and the associated screen in the Android application. We will walk through the process of editing it in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_page_landing.png)

### The Main Page
***
Main Pages define all screens in the application that are not the Loading or Landing screens and are access through the Landing Page. There is no limit to how many Main Pages you can have but ideally you will have 3-10 pages that way you have enough pages to display information about your organization without providing too many pages which might overwhelm the user. Main Pages are simply a collection of Elements and Templates that will be displayed in the application.

Below is how the content named `Page - Main - All Content` looks in Contentful with the associated screen in the Android application. This is how a Main Page will look when creating or modifying one. We will walk through the process of creating and editing main Pages in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_page_main.png)

### The Elements
***
Below is an example of the Image Element showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Image Element. Creating and modifying this and all elements is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_element_image.png)

Below is an example of the Link Element showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Link Element. Creating and modifying this and all elements is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_element_link.png)

Below is an example of the Text Element showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Text Element. Creating and modifying this and all elements is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_element_text.png)

Below is an example of the YouTube Element showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the YouTube Element. Creating and modifying this and all elements is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_element_youtube.png)

### The Templates
***
Below is an example of the Article Template showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Article Template. Creating and modifying this and all templates is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_template_article.png)

Below is an example of the Contact Info Template showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Contact Info Template. Creating and modifying this and all templates is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_template_contact.png)

Below is an example of the Location Template showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Location Template. Creating and modifying this and all templates is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_template_location.png)

Below is an example of the Profile Template showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Profile Template. Creating and modifying this and all templates is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_template_profile.png)

Below is an example of the Web Template showing how it looks in Contentful and in the Android application. This is what you will see we creating or modifying the Web Template. Creating and modifying this and all templates is done the same way. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_template_web.png)

### The Reference Link
***
The Reference Link is used in Contentful to link Elements and Templates to the Main Page we want to show them in. For each Element and Template we create we will also need to create a Reference Link. Each Main Page is a list of Reference Links that correspond to the content we want displayed on it.

Below is an example of the Reference Link showing how it looks in Contentful. This is what you will see when creating or modifying a Reference Link. We will walk through this process in the _Bringing the Pieces Together_ section below.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_reference.png)

### Bringing the Pieces Together
***
**Adding Assets**
In order to add assets to Contentful simply navigate to the _Media_ tab and click _Add asset_. You'll be able to add assets this way choosing the _Single asset_ or _Multiple assets_ options, _Single asset_ is shown. I recommend using PNG images but JPEG images will also work.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_add_asset.png)

Once you have chosen _Single asset_ you will see the form as shown previously in the **Assets** section. Fill in the fields and select the image you wish to upload. Once you are done click the _Publish_ button on the right under the STATUS heading. Now this asset will be available for use on the Loading Page, Image Element, and Profile Template.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_add_asset_publish.png)

**Editing Loading and Landing Page**
In order to edit the Loading and Landing page we will need to open the one we wish to edit within the _Content_ tab. You can filter the list to the content you wish to edit by selecting that content type next to the search bar, this applies to all pages, elements, templates and Reference links.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_content_tab.png)

You can also filter the list to the content you wish to edit by selecting that type in the sidebar, this also applies to all pages, elements, templates and Reference links.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_content_sidebar.png)

Once you see the page you wish to edit simply click it to launch into editing it. When editing all content in the future you will follow these same steps, going to the _Content_ tab, narrowing the items shown if necessary, and clicking them to go into edit mode.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_content_select.png)

When editing the **Landing Page** you will be able to select or de-select the Main Pages associated with it. This is the list of the Main Pages the application will have available and is defined as _Pages_. Each one of these pages will correspond to a button on the application landing page that you can click to see the Main Page associated with it. You can select any, and as many, Main Pages as you want to to show and be visible in the application. Select all the main pages you want to show and rearrange their order if you wish to do so. The process of creating and modifying Main Pages is discussed later.

Edit the values you wish to modify then click the _Publish_ button on the right under the STATUS heading to save your updates, changes must be published in order to see them in your application. Sometimes you will make changes and not see them in the application. This usually happens with your changes are saved but not published. Simply navigate back the the content you were changing (if you left) and make sure the changes are published. The status might list _DRAFT_ or _UNPUBLISHED_ if this occurs.

**Adding/Editing Elements and Templates**
In order to edit an existing Element or Template follow the same steps we did when editing the Loading and Landing pages. In short, navigate to the _Content_ tab and filter to the content you wish to edit.

Creating new Elements and Templates is just like editing them except instead of selecting the content you wish to edit you will elect to create a new one. To do this navigate to the _Content_ tab and click _Add entry_. You'll be able to choose the specific content you wish to create which will launch you into editing the content.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_add_content.png)

Since you will need to create a Reference Link for each Element and Template you create in order to use it in a Main Page and show it in the application it is best that we create the Reference Link for each one as we create them. To begin this process save (or Copy for later pasting) the _SLUG_ value at the bottom of the content you are creating. This value is defined for all content in Contentful. Once you have saved or copied this value continue to the next section _Adding Reference Links_.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/contentful_screenshots/contentful_screen_content_slug.png)

**Adding Reference Links**
Now that we have created our Element or Template we will use the _SLUG_ from that piece of content to create a Reference Link that we can use in building the Main Pages that drive our application.

The process is just like creating any other content piece, will create a new one by navigating to the _Content_ tab, click _Add entry_, then choose _Link - Reference_. Give the Reference Link a descriptive _Name_, select the appropriate type of content you are linking to for _Linked Type_ and paste the _SLUG_ value you copied from the content you created into _Linked Slug_. Once done click the _Publish_ button on the right under the STATUS heading to save the Reference Link, it's now ready to be used in building Main Pages.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_reference.png)

**Making Main Pages Using Your Element and Template Reference Links**
Once you have created all the content (Elements and Templates) you want to display and their Reference Links the last thing to go through is the process of editing and creating the Main Pages that will use them. In order to edit an existing Main Page follow the same steps we did when editing the Loading Page, Landing pages, elements, and templates. In short, navigate to the _Content_ tab and filter to the content you wish to edit.

Creating new Main Page is just like editing them except instead of selecting the content you wish to edit you will elect to create a new one. To do this navigate to the _Content_ tab and click _Add entry_. You'll be able to choose _Page - Main_ which will launch you into editing the page.

Under _Name_ define a descriptive name that uniquely identifies this page and the content you will be adding to it, the _Name_ field is only shown in Contentful so it can be as short or as long as you wish. Keeping it long/descriptive will help you to identify this page compared to others later one. The _Title_ field will be shown in the application on the button in the Landing Page and on the screen toolbar when you select to view this page in the application. _Title_ should be short and sweet while being intuitive to the user.

Last is the _Content_. This is the list of all the content you want to show on the screen for this page, the available choices are the Reference Links you created for each element and template. Select all the content you want to show and rearrange their order if you wish to do so. Once done click the _Publish_ button on the right under the STATUS heading to save the Main Page, it's now ready to be used in Landing Page.

![TBD](https://github.com/rojoiii/a-app-orgtrac/blob/develop/images/updating_content/content_page_main.png)

[**NEXT STEP:** Generating the Signature Certificate and Application Binary](https://github.com/rojoiii/a-app-orgtrac/wiki/Generating-the-Signature-Certificate-and-Application-Binary)
