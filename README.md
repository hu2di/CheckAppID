### CheckAppID
The android library checks for the application id that matches the application id on the server

### Screenshot
<img src="https://raw.githubusercontent.com/hu2di/CheckAppID/master/Screenshot/screenshot.png">

### SDK Support
Support from SDK version 14 onwards

### JSON on Server
```json
{ "data":[
	{"package":"com.blogspot.hu2di.test1"},
	{"package":"com.blogspot.hu2di.test2"},
	{"package":"com.blogspot.hu2di.test3"}
]}
```

### Download
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

### Example
Add in your activity to check every application is opened
```java
new CheckAppID(this,
        "https://yourServer/yourFile.json", 
	//Ex: https://raw.githubusercontent.com/hu2di/CheckAppID/master/Server/CheckAppIds.json
        "your-email@gmail.com")
        .execute();
```
Add in your activity to check every day once
```java
new CheckAppID(this,
        "https://yourServer/yourFile.json", 
	//Ex: https://raw.githubusercontent.com/hu2di/CheckAppID/master/Server/CheckAppIds.json
        "your-email@gmail.com")
        .executeDayByDay();
```

### PayPal
 - [**Donate 5 $**](https://www.paypal.me/hungdh/5usd): Thank's for creating this project, here's a coffee (or some beer) for you!
 - [**Donate 10 $**](https://www.paypal.me/hungdh/10usd): Wow, I am stunned. Let me take you to the movies!
 - [**Donate 15 $**](https://www.paypal.me/hungdh/15usd): I really appreciate your work, let's grab some lunch! 
 - [**Donate 25 $**](https://www.paypal.me/hungdh/25usd): That's some awesome stuff you did right there, dinner is on me!
 - [**Donate 50 $**](https://www.paypal.me/hungdh/50usd): I really really want to support this project, great job!
 - [**Donate 100 $**](https://www.paypal.me/hungdh/100usd): You are the man! This project saved me hours (if not days) of struggle and hard work, simply awesome!
 - Of course, you can also [**choose what you want to donate**](https://www.paypal.me/hungdh), all donations are awesome!
 
### About
Created by HuyHung Dinh<br>
GitHub: https://github.com/hu2di<br>
Email: hebitaxy@gmail.com
