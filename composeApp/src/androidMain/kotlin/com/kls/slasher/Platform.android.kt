package com.kls.slasher

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val ios: Boolean = false
}

actual fun getPlatform(): Platform = AndroidPlatform()