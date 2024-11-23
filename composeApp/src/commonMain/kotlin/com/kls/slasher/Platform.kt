package com.kls.slasher

interface Platform {
    val name: String
    val ios: Boolean
}

expect fun getPlatform(): Platform