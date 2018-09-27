package edu.csun.orgtrac

import android.content.Context
import edu.csun.orgtrac.injection.AppComponent

val Context.component: AppComponent
    get() = (applicationContext as OrgTracApplication).appComponent