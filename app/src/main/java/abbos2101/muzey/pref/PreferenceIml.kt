package net.city.qurulishinspektor.locale.pref

import android.content.SharedPreferences


class PreferenceIml(pref: SharedPreferences) : IPreferenceManager {
    override var password: String by StringPreference(pref, "password")
}