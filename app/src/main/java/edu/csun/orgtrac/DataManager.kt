package edu.csun.orgtrac

import com.contentful.vault.SyncConfig
import com.contentful.vault.SyncResult
import com.contentful.vault.Vault
import io.reactivex.Single

class DataManager(val vault: Vault, val syncConfig: SyncConfig) {
    var webTemplates = HashMap<String, OrgTrac.Model.Content.Template.Web>()
    var profileTemplates = HashMap<String, OrgTrac.Model.Content.Template.Profile>()
    var locationTemplates = HashMap<String, OrgTrac.Model.Content.Template.Location>()
    var articleTemplates = HashMap<String, OrgTrac.Model.Content.Template.Article>()
    var contactInfoTemplates = HashMap<String, OrgTrac.Model.Content.Template.ContactInfo>()
    var textElements = HashMap<String, OrgTrac.Model.Content.Element.Text>()
    var imageElements = HashMap<String, OrgTrac.Model.Content.Element.Image>()
    var youtubeVideoElements = HashMap<String, OrgTrac.Model.Content.Element.Youtube>()
    var linkElements = HashMap<String, OrgTrac.Model.Content.Element.Link>()
    var loadingPage: OrgTrac.Model.LoadingPage? = null
    var landingPage: OrgTrac.Model.LandingPage? = null
    var mainPages: HashMap<String, OrgTrac.Model.MainPage> = HashMap()

    fun translateData(): Single<SyncResult> {
        return Single.fromCallable {
            vault.requestSync(syncConfig)
            val syncResult = Vault.observeSyncResults().blockingFirst()

            vault.fetch(Contentful.Model.WebTemplate::class.java).all().forEach { temp ->
                OrgTrac.Model.Content.Template.Web.build(temp)?.let {
                    webTemplates[temp.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.ProfileTemplate::class.java).all().forEach { temp ->
                OrgTrac.Model.Content.Template.Profile.build(temp)?.let {
                    profileTemplates[temp.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.LocationTemplate::class.java).all().forEach { temp ->
                OrgTrac.Model.Content.Template.Location.build(temp)?.let {
                    locationTemplates[temp.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.ArticleTemplate::class.java).all().forEach { temp ->
                OrgTrac.Model.Content.Template.Article.build(temp)?.let {
                    articleTemplates[temp.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.ContactInfoTemplate::class.java).all().forEach { temp ->
                OrgTrac.Model.Content.Template.ContactInfo.build(temp)?.let {
                    contactInfoTemplates[temp.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.TextElement::class.java).all().forEach { ele ->
                OrgTrac.Model.Content.Element.Text.build(ele)?.let {
                    textElements[ele.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.ImageElement::class.java).all().forEach { ele ->
                OrgTrac.Model.Content.Element.Image.build(ele)?.let {
                    imageElements[ele.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.YoutubeElement::class.java).all().forEach { ele ->
                OrgTrac.Model.Content.Element.Youtube.build(ele)?.let {
                    youtubeVideoElements[ele.slug.orEmpty()] = it
                }
            }

            vault.fetch(Contentful.Model.LinkElement::class.java).all().forEach { ele ->
                OrgTrac.Model.Content.Element.Link.build(ele)?.let {
                    linkElements[ele.slug.orEmpty()] = it
                }
            }

            loadingPage = OrgTrac.Model.LoadingPage.build(vault.fetch(Contentful.Model.LoadingPage::class.java).first())
            landingPage = OrgTrac.Model.LandingPage.build(
                vault.fetch(Contentful.Model.LandingPage::class.java).first(),
                webTemplates,
                profileTemplates,
                locationTemplates,
                articleTemplates,
                contactInfoTemplates,
                textElements,
                imageElements,
                youtubeVideoElements,
                linkElements
            )

            vault.fetch(Contentful.Model.MainPage::class.java).all().forEach { page ->
                OrgTrac.Model.MainPage.build(
                    page,
                    webTemplates,
                    profileTemplates,
                    locationTemplates,
                    articleTemplates,
                    contactInfoTemplates,
                    textElements,
                    imageElements,
                    youtubeVideoElements,
                    linkElements
                )?.let {
                    mainPages[page.slug.orEmpty()] = it
                }
            }

            syncResult
        }
    }
}