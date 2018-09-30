package edu.csun.orgtrac.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.toast
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.OrgTrac
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import edu.csun.orgtrac.launchUrl
import kotlinx.android.synthetic.main.activity_landing.landing_content
import kotlinx.android.synthetic.main.activity_landing.toolbar
import kotlinx.android.synthetic.main.activity_landing_item.view.landing_card_image
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
            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.content)

            mainPage.content?.let { content ->
                if (content.size == 1) {
                    when (content.first()) {
                        is OrgTrac.Model.Content.Template.Web -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.internet)
                        }
                        is OrgTrac.Model.Content.Template.Profile -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.profile)
                        }
                        is OrgTrac.Model.Content.Template.Location -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.location)
                        }
                        is OrgTrac.Model.Content.Template.Article -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.article)
                        }
                        is OrgTrac.Model.Content.Template.ContactInfo -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.contact)
                        }
                        is OrgTrac.Model.Content.Element.Youtube -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.youtube)
                        }
                        is OrgTrac.Model.Content.Element.Link -> {
                            itemView.landing_card_image.background = ContextCompat.getDrawable(this, R.mipmap.internet)
                        }
                    }
                }
            }

            itemView.setOnClickListener {
                mainPage.content?.let { content ->
                    if (content.isNotEmpty()) {
                        if (content.size == 1 && content.first() is OrgTrac.Model.Content.Template.Web) {
                            launchUrl((content.first() as OrgTrac.Model.Content.Template.Web).url.orEmpty())
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
