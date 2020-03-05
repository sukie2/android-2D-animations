package com.sukie2.spine

import android.webkit.JavascriptInterface


public class JSInterface {

    @JavascriptInterface
    fun doEchoTest(echo: String) {
        println(echo)
    }
}