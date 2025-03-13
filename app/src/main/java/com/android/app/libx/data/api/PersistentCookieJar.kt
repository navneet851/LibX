package com.android.app.libx.data.api

import android.content.Context
import android.content.SharedPreferences
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import androidx.core.content.edit

class PersistentCookieJar(context: Context) : CookieJar {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("cookie_prefs", Context.MODE_PRIVATE)

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        sharedPreferences.edit() {
            for (cookie in cookies) {
                putString(url.host, cookie.toString())
            }
        }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val cookies = mutableListOf<Cookie>()
        val cookieString = sharedPreferences.getString(url.host, null)
        if (cookieString != null) {
            cookies.add(Cookie.parse(url, cookieString)!!)
        }
        return cookies
    }
}