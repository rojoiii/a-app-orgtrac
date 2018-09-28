package edu.csun.orgtrac.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.activity_landing_item.view.landing_card_title
import javax.inject.Inject

class LandingActivity : AppCompatActivity() {
    @Inject lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        setSupportActionBar(toolbar)
        component.inject(this)

        title = dataManager.landingPage?.title

        landing_content.removeAllViews()
        dataManager.landingPage?.pages?.forEach { mainPage ->
            val itemView = layoutInflater.inflate(R.layout.activity_landing_item, landing_content, false)

            itemView.landing_card_title.text = mainPage.title
            itemView.setOnClickListener {
                startActivity(MainActivity.newIntent(this, mainPage.slug.orEmpty()))
            }

            landing_content.addView(itemView)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, LandingActivity::class.java)
    }
}
