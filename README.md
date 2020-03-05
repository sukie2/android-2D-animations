# android-2D-animations
This is an example od demonstrating the utilization of a 2D animation engine in Android. 
Example game uses a WebView to render the animations.

Features
- Render heavy animations.
- Passing events in to the game from Fragment.
- Receive events from the game into the Fragment.

## Where to start?

### Animation creation engine (SPINE)
http://esotericsoftware.com/
Use the above engine to give life to animations, then export it using the same tool. This export will usually consist of 3 files. (a PNG sprite, a JSON file and an .atlas file). 
Then directly import them into your Android project (into assets)

### Android JS runtime (PIXIJS)
Android needs a runtime to read and render the above exports. There are various runtimes available to choose from. You can find them in here. http://esotericsoftware.com/spine-runtimes.
The above example uses PixiJS - https://pixijs.io/examples/#/plugin-spine/pixie.js. 


All sample animation assets are from https://pixijs.io/examples/#/plugin-spine/pixie.js

