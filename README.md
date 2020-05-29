Medium Link : https://medium.com/@gbisano/understanding-android-dynamic-features-new-meta-992ed1470caf

# AndroidDynamicFeature
Pokedex application that implements Dynamic Feature. This app consist of 3 functionality:
1. See Pokemon List (Dummy data)
2. See Pokemon Detail (Dummy data)
3. See Onboarding page from Dynamic Feature

## Installation

Install Android Studio 4.+
Clone Project

## Tech Stack
- Kotlin
- Koin (Dependency Injection)
- Navigation Architecture Component

## Screenshot 
![Pokemon List (Dummy Data)](https://i.ibb.co/V2fhqcJ/1.png) ![Pokemon Detail (Dummy Data)](https://i.ibb.co/tBrrPb7/2.png) ![Onboarding Feature - from Dynamic Module](https://i.ibb.co/B67hn5V/3.png)

## Deployment
You have 2 option for deploy your Dynamic Feature app.

- Upload your AAB to Playstore. Or,
- Build an AAB, placed you AAB to `app > build > outputs > apk > debug` , then execute this command `gradlew installApkSplitsForTestDebug`.

When you use the second option, bundletool will create an APK from your AAB then install that base apk to your device and save feature module to SD Card. In result, when the app need feature module, then the app will search that feature module in SD card (it's the same with the app searching for feature module in playstore).

> You may create an issue if you found any or create a pull request.
