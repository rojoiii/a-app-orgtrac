package edu.csun.orgtrac.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        component.inject(this)


    }
}
