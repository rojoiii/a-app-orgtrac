package edu.csun.orgtrac.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.OrgTrac
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import kotlinx.android.synthetic.main.activity_landing_item.view.landing_card_title
import kotlinx.android.synthetic.main.activity_main.main_content
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main_article_template_item.view.article_title
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_title
import kotlinx.android.synthetic.main.activity_main_image_element_item.view.image_title
import kotlinx.android.synthetic.main.activity_main_link_element_item.view.link_title
import kotlinx.android.synthetic.main.activity_main_location_template_item.view.location_title
import kotlinx.android.synthetic.main.activity_main_profile_template_item.view.profile_title
import kotlinx.android.synthetic.main.activity_main_text_element_item.view.text_title
import kotlinx.android.synthetic.main.activity_main_web_template_item.view.web_title
import kotlinx.android.synthetic.main.activity_main_youtube_video_element_item.view.youtube_video_title
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        component.inject(this)
        val page = dataManager.mainPages[intent.getStringExtra(EXTRA_SLUG)]

        title = page?.title

        main_content.removeAllViews()
        page?.content?.forEach { content ->
            when (content) {
                is OrgTrac.Model.Content.Template.Web -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_web_template_item, main_content, false)

                    itemView.web_title.text = content.title
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.Profile -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_profile_template_item, main_content, false)

                    itemView.profile_title.text = content.title
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.Location -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_location_template_item, main_content, false)

                    itemView.location_title.text = content.title
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.Article -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_article_template_item, main_content, false)

                    itemView.article_title.text = content.title
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.ContactInfo -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_contact_info_template_item, main_content, false)

                    itemView.contact_info_title.text = content.title
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Text -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_text_element_item, main_content, false)

                    itemView.text_title.text = content.text
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Image -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_image_element_item, main_content, false)

                    itemView.image_title.text = content.description
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Youtube -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_youtube_video_element_item, main_content, false)

                    itemView.youtube_video_title.text = content.url
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Link -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_link_element_item, main_content, false)

                    itemView.link_title.text = content.displayText
                    itemView.setOnClickListener {
                        // TODO: Stuffs
                    }

                    main_content.addView(itemView)
                }
            }
        }
    }

    companion object {
        private const val EXTRA_SLUG = "extra:slug"

        fun newIntent(context: Context, slug: String): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_SLUG, slug)

            return intent
        }
    }
}
