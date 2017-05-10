# CheckAppID
The android library checks for the application id that matches the application id on the server

## Screenshot
<img src="https://raw.githubusercontent.com/hu2di/CheckAppID/master/Screenshot/screenshot.png">

## SDK Support
Support from SDK version 14 onwards

## JSON on Server
```json
{ "data":[
	{"package":"com.blogspot.hu2di.test1"},
	{"package":"com.blogspot.hu2di.test2"},
	{"package":"com.blogspot.hu2di.test3"}
]}
```

## Download
JitPack:<br>
Step 1. Add the JitPack repository to your build file<br>
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency
```groovy
dependencies {
    compile 'com.github.hu2di:CheckAppID:1.0.3'
}
```

## Example
Add in your activity to check every application is opened
```java
new CheckAppID(this,
                "https://yourServer/yourFile.json", //Example: https://raw.githubusercontent.com/hu2di/CheckAppID/master/Server/CheckAppIds.json
                "your-email@gmail.com")
                .execute();
```
Add in your activity to check every day once
```java
new CheckAppID(this,
                "https://yourServer/yourFile.json", //Example: https://raw.githubusercontent.com/hu2di/CheckAppID/master/Server/CheckAppIds.json
                "your-email@gmail.com")
                .executeDayByDay();
```

## About
Created by HuyHung Dinh<br>
GitHub: https://github.com/hu2di<br>
Email: hebitaxy@gmail.com
