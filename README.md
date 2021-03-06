# Andriod ultra smooth game animation with Spine2D and PixiJS

![](spineGif.gif)


Doing heavy animations is tricky in Android, unlike in iOS we do not have a [SpriteKit](https://developer.apple.com/documentation/spritekit) to play around and to use sprites in a memory efficient way. Android's way of doing this is to use [AnimationDrawable](https://developer.android.com/reference/android/graphics/drawable/AnimationDrawable). Basically we need to feed a set of frames (drawables) in to a AnimationDrawable as a sequence to achieve an animation. (ex: jumping, walking). To gain smoothness into one of these animations (ex: walking), it will require around 15-20 different drawables.
```
 <!-- Animation frames, files inside the res/drawable/ folder -->
 <animation-list android:id="@+id/selected" android:oneshot="false">
    <item android:drawable="@drawable/left_walk_00" android:duration="50" />
    <item android:drawable="@drawable/left_walk_01" android:duration="50" />
    <item android:drawable="@drawable/left_walk_02" android:duration="50" />
    <item android:drawable="@drawable/left_walk_03" android:duration="50" />
    <item android:drawable="@drawable/left_walk_04" android:duration="50" />
    <item android:drawable="@drawable/left_walk_05" android:duration="50" />
 </animation-list>
 
```
Problem here is if a simple screen has 5-6 different animations, the screen will be loading mass number of bitmap objects into the memory. Releasing or recycling bitmaps is tricky and your app will likely to go out of memory. (Ex. after repeatedly going back and forth to the animation screen).

Spine to the Rescue.

Spine engine will combine all repeated parts of an animation and export as one image like below so that on the runtime the app does not have to load number of drawable. The Spine runtime (pixijs) will map and stitch the animations on the runtime.

![Image description](https://github.com/sukie2/android-2D-animations/blob/master/app/src/main/assets/pixie.png)

The beauty of this solution is the way it gets rid of the frame by frame animations used with AnimationDrawable class in Android SDK.
This is a sample demonstration of how Spine 2D assets can be used in Android using PixiJS runtime.

## Required components ##
There are 3 main components.
- Spine exports from Spine2D graphics engine. http://esotericsoftware.com/
- Spine runtime of your choice. http://esotericsoftware.com/spine-runtimes. This example uses PixiJS https://www.pixijs.com
- Android/iOS app with a WebView.

## Project structure ##
All the examples are stored in the `assets` folder and loaded into a WebView.

### Native to JavaScript calls
Include this on the Fraagment
```
 button.setOnClickListener {
  webView.loadUrl("javascript:jump()")
 }
```
And then on the Javascript
```
function jump(){
 pixie.state.setAnimation(0, 'jump', false);
 pixie.state.addAnimation(0, 'running', true, 0);
}
```
### JavaScript to Native calls
In Javascript
```
function onTouchStart() {
 JavaScriptInterface.doEchoTest("Hello from JS");
}
```

In native code in Fragment
```
webView.addJavascriptInterface(JSInterface(), "JavaScriptInterface")
```
Then create this class
```
class JSInterface {
    @JavascriptInterface
    fun doEchoTest(echo: String) {
        println(echo)
    }
}
```
# Important: Use an Android device for running/debugging spine. Emulator does not work properly in many cases.

