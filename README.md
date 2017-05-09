# CheckAppID
The android library checks for the application id that matches the application id on the server
## Screenshot
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
JitPack:
Step 1. Add the JitPack repository to your build file
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
## About
