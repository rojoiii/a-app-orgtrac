package edu.csun.orgtrac

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import edu.csun.orgtrac.injection.AppComponent

val Context.component: AppComponent
    get() = (applicationContext as OrgTracApplication).appComponent

fun Context.launchUrl(url: String){
    CustomTabsIntent.Builder()
        .setToolbarColor(resources.getColor(R.color.colorAccent))
        .build()
        .launchUrl(this, Uri.parse(url))
}