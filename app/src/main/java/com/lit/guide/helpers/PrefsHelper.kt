package com.lit.guide.helpers

import android.content.Context
import android.content.SharedPreferences
class PrefsHelper {
    companion object {
        fun saveprefs(context: Context, key: String, value: String) {
            val prefs: SharedPreferences = context.getSharedPreferences(
                "storage",
                Context.MODE_PRIVATE
            )
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun getprefs(context: Context, key: String): String {
            val prefs: SharedPreferences = context.getSharedPreferences(
                "storage",
                Context.MODE_PRIVATE
            )

            val value = prefs.getString(key, "")
            return value.toString()
        }
    }

}