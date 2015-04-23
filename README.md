# android-study-app
Android Studio files for the study-app

DO THIS IF FIRST TIME TO ADD THE FACEBOOK SDK:
Add Facebook SDK to Your Project
To use Facebook SDK in a project, add it as a build dependency and import it.
1. Go to Android Studio | New Project | Minimum SDK
2. Select "API 9: Android 2.3" or higher and create your new project.
3. After you create a new project, open
your_app | build.gradle
4. Add this to build.gradle before dependencies:
repositories { mavenCentral() }
5. Build your project. Now you can import com.facebook.FacebookSdk into your app.
You may need to add compile 'com.facebook.android:facebook-android-sdk:4.0.0' to your build.gradle dependencies and rebuild.
