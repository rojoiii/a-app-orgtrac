package edu.csun.orgtrac.activity

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import com.squareup.picasso.Picasso
import edu.csun.orgtrac.DataManager
import edu.csun.orgtrac.OrgTrac
import edu.csun.orgtrac.R
import edu.csun.orgtrac.component
import edu.csun.orgtrac.launchUrl
import kotlinx.android.synthetic.main.activity_main.main_content
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main_article_template_item.view.article_created_by
import kotlinx.android.synthetic.main.activity_main_article_template_item.view.article_description
import kotlinx.android.synthetic.main.activity_main_article_template_item.view.article_title
import kotlinx.android.synthetic.main.activity_main_article_template_item.view.article_url
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_description
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_email
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_facebook
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_facebook_text
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_title
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_twitter
import kotlinx.android.synthetic.main.activity_main_contact_info_template_item.view.contact_info_twitter_text
import kotlinx.android.synthetic.main.activity_main_image_element_item.view.image_image
import kotlinx.android.synthetic.main.activity_main_link_element_item.view.link_title
import kotlinx.android.synthetic.main.activity_main_location_template_item.view.location_address
import kotlinx.android.synthetic.main.activity_main_location_template_item.view.location_image
import kotlinx.android.synthetic.main.activity_main_location_template_item.view.location_title
import kotlinx.android.synthetic.main.activity_main_profile_template_item.view.profile_description
import kotlinx.android.synthetic.main.activity_main_profile_template_item.view.profile_image
import kotlinx.android.synthetic.main.activity_main_profile_template_item.view.profile_title
import kotlinx.android.synthetic.main.activity_main_text_element_item.view.text_title
import kotlinx.android.synthetic.main.activity_main_web_template_item.view.web_title
import kotlinx.android.synthetic.main.activity_main_youtube_video_element_item.view.youtube_video_title
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var dataManager: DataManager
    @Inject lateinit var picasso: Picasso

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
                        launchUrl(content.url.orEmpty())
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.Profile -> {
                    val itemView =
                        layoutInflater.inflate(R.layout.activity_main_profile_template_item, main_content, false)

                    itemView.profile_title.text = content.title
                    itemView.profile_description.text = content.description
                    picasso
                        .load(content.image)
                        .into(itemView.profile_image)
                    itemView.setOnClickListener {
                        // At this time no actions are defined
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.Location -> {
                    val itemView =
                        layoutInflater.inflate(R.layout.activity_main_location_template_item, main_content, false)

                    itemView.location_title.text = content.title
                    itemView.location_address.text = content.address
                    itemView.setOnClickListener {
                        // At this time no actions are defined
                    }

                    if (content.latitude != null && content.longitude != null) {
                        val gmmIntentUri = Uri.parse("geo:${content.latitude},${content.longitude}?q=" + Uri.encode(content.address))
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            itemView.location_image.visibility = VISIBLE
                            itemView.location_image.setOnClickListener {
                                startActivity(mapIntent)
                            }
                        }
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.Article -> {
                    val itemView =
                        layoutInflater.inflate(R.layout.activity_main_article_template_item, main_content, false)

                    itemView.article_title.text = content.title
                    itemView.article_created_by.text = content.createdBy
                    itemView.article_description.text = content.description
                    itemView.article_url.text = content.url
                    itemView.setOnClickListener {
                        // At this time no actions are defined
                    }

                    content.url?.let { url ->
                        itemView.article_url.visibility = VISIBLE
                        itemView.article_url.setOnClickListener {
                            launchUrl(content.url.orEmpty())
                        }
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Template.ContactInfo -> {
                    val itemView =
                        layoutInflater.inflate(R.layout.activity_main_contact_info_template_item, main_content, false)

                    itemView.contact_info_title.text = content.title
                    itemView.contact_info_email.text = content.email
                    itemView.contact_info_description.text = content.description

                    itemView.contact_info_email.setOnClickListener {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "*/*"
                            putExtra(Intent.EXTRA_EMAIL, arrayOf(content.email))
                            putExtra(Intent.EXTRA_SUBJECT, content.title)
                        }
                        if (intent.resolveActivity(packageManager) != null) {
                            startActivity(intent)
                        }
                    }

                    content.facebookTag?.let { facebookTag ->
                        itemView.contact_info_facebook.visibility = VISIBLE
                        itemView.contact_info_facebook_text.text = "@$facebookTag"
                        itemView.contact_info_facebook.setOnClickListener {
                            // Maybe launch in the future
                        }
                    }

                    content.twitterTag?.let { twitterTag ->
                        itemView.contact_info_twitter.visibility = VISIBLE
                        itemView.contact_info_twitter_text.text = "@$twitterTag"
                        itemView.contact_info_twitter.setOnClickListener {
                            // Maybe launch in the future
                        }
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Text -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_text_element_item, main_content, false)

                    itemView.text_title.text = content.text
                    when (content.fontStyle) {
                        "Italic" -> {
                            itemView.text_title.setTypeface(itemView.text_title.getTypeface(), Typeface.ITALIC)
                        }
                        "Bold" -> {
                            itemView.text_title.setTypeface(itemView.text_title.getTypeface(), Typeface.BOLD)
                        }
                        else -> {
                            itemView.text_title.setTypeface(itemView.text_title.getTypeface(), Typeface.NORMAL)
                        }
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Image -> {
                    val itemView =
                        layoutInflater.inflate(R.layout.activity_main_image_element_item, main_content, false)

                    itemView.image_image.contentDescription = content.description
                    picasso
                        .load(content.image)
                        .into(itemView.image_image)
                    itemView.setOnClickListener {
                        // At this time no actions are defined
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Youtube -> {
                    val itemView =
                        layoutInflater.inflate(R.layout.activity_main_youtube_video_element_item, main_content, false)

                    itemView.youtube_video_title.text = content.title
                    content.url?.let { url ->
                        itemView.setOnClickListener {
                            launchUrl(content.url.orEmpty())
                        }
                    }

                    main_content.addView(itemView)
                }
                is OrgTrac.Model.Content.Element.Link -> {
                    val itemView = layoutInflater.inflate(R.layout.activity_main_link_element_item, main_content, false)

                    itemView.link_title.text = content.displayText
                    content.url?.let { url ->
                        itemView.setOnClickListener {
                            launchUrl(content.url.orEmpty())
                        }
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
