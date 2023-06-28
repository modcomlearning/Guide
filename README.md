# Guide to Created Android App - Front End/Client App
This guide will help understand on how to organize your projects , especially a project that involves a Many Modules that must 
interact to bring the final Output. 

App architecture decides the quality of implementation and development time of mobile app hence important to have proper structure for your Android Applications.

In Most cases putting different components separately could improve code undustanding, resuse and maitainability.
Before Proceeding, we recomend you go through below Link.

https://github.com/codepath/android_guides/wiki/Organizing-your-Source-Files

Now, Lets Look at different components that you may require.

**Activities** -  An activity is one screen of an app. In that way the activity is very similar to a window in the Windows operating system. The most specific block of the user interface is the activity. An Android app contains activities, meaning one or more screens. Examples: Login screen, sign up screen, and home screen.

![image](https://github.com/modcomlearning/Guide/assets/66998462/3ea54da4-2141-4abd-a08f-0a22c1acbd10)
https://developer.android.com/guide/components/activities/intro-activities

**Fragments** - A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments can't live on their own. They must be hosted by an activity or sometimes another fragment.
https://developer.android.com/guide/fragments


**Fragments vs Activities**
Fragment and Activity are two different components that can be used to create an Android app. Fragments are great for creating a more dynamic user interface and for creating reusable components. Activities are great for creating the entry point for an app and for managing the Fragments and their interactions.


**Adapters** - Adapters in Android are a bridge between the Adapter View (e.g. ListView, Recycler View, Grid View) and the underlying data for that view. This is a crucial concept in Android architecture and is also required for Android Certification.

An adapter basically connects the User Interfaces and the Data Source.

![image](https://github.com/modcomlearning/Guide/assets/66998462/fb217a29-6b82-4b74-9d1e-3d0a795a5f1c)
https://data-flair.training/blogs/android-adapters/

**Models**  - Your model would usually be a set of classes that hold your data, 
In this example case, probably an Item class having a name, name of Person and other properties like age, heigth etc.
The model can get data from a JSOn response and pass it to the Adapters.

**Networking** - Android Networking module lets your application connect to the internet or any other local network and allows you to perform network operations, i.e connect to an API etc.

**Services** - Services in Android are a special component that facilitates an application to run in the background in order to perform long-running operation tasks. ie, GPS tracking Module that runs in the background.

helpers - Helper is a Java class which includes basic error handling, some helper functions etc. Helper class contains functions that help in assisting the program. This Class intends to give quick implementation of basic functions such that programmers do not have to implement again and again.

A helper method is used to perform a particular repetitive task common across multiple classes. This keeps us from repeating the same piece of code in different classes again n again. Whereas the class-specific methods define its behaviour, the helper methods assist in that process. i.e a function to decrypt variables which is used in almost all classes culd bel put in a helper class to help anytime we need to decrypt something.






