package com.karan.firechat.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.widget.Toast


fun Context.showToast(msg : String){
    Toast.makeText(this , msg , Toast.LENGTH_SHORT).show()
}


fun Context.getPrefs(): SharedPreferences {
    return this.getSharedPreferences(PreferenceHelper.PREFS , MODE_PRIVATE)
}
