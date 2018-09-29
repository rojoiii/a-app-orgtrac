package edu.csun.orgtrac.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.toast
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.OrgTrac
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import kotlinx.android.synthetic.main.activity_landing.landing_content
import kotlinx.android.synthetic.main.activity_landing.toolbar
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
                mainPage.content?.let { content ->
                    if (content.isNotEmpty()) {
                        if (content.size == 1 && content.first() is OrgTrac.Model.Content.Template.Web) {
                            CustomTabsIntent.Builder()
                                .setToolbarColor(resources.getColor(R.color.colorAccent))
                                .build()
                                .launchUrl(this, Uri.parse((content.first() as OrgTrac.Model.Content.Template.Web).url))
                        } else {
                            startActivity(MainActivity.newIntent(this, mainPage.slug.orEmpty()))
                        }
                    } else {
                        toast("Sorry, this screen in not defined yet.")
                    }
                }
            }

            landing_content.addView(itemView)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, LandingActivity::class.java)
    }
}
