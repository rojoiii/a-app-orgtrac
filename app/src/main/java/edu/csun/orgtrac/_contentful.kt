package edu.csun.orgtrac

import com.contentful.vault.Asset
import com.contentful.vault.ContentType
import com.contentful.vault.Field
import com.contentful.vault.Resource
import com.contentful.vault.Space

@Space(
    value = "re77qk2q3c1m",
    models = [
        Contentful.Model.LoadingPage::class,
        Contentful.Model.LandingPage::class,
        Contentful.Model.MainPage::class,
        Contentful.Model.WebTemplate::class,
        Contentful.Model.ProfileTemplate::class,
        Contentful.Model.LocationTemplate::class,
        Contentful.Model.ArticleTemplate::class,
        Contentful.Model.ContactInfoTemplate::class,
        Contentful.Model.TextElement::class,
        Contentful.Model.ImageElement::class,
        Contentful.Model.YoutubeElement::class,
        Contentful.Model.LinkElement::class,
        Contentful.Model.LinkReference::class
    ],
    locales = ["en-US"],
    dbVersion = 1
)
class Space
class Contentful{
    class Model {
        @ContentType("pageLoading")
        data class LoadingPage(
            @Field("name") @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var image: Asset? = null,
            @Field @JvmField var message: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("pageLanding")
        data class LandingPage(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var pages: List<MainPage>? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("pageMain")
        data class MainPage(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var content: List<LinkReference>? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("templateWeb")
        data class WebTemplate(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var url: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("templateProfile")
        data class ProfileTemplate(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var image: Asset? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var description: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("templateLocation")
        data class LocationTemplate(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var address: String? = null,
            @Field @JvmField var latitude: Double? = null,
            @Field @JvmField var longitude: Double? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("templateArticle")
        data class ArticleTemplate(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var createdBy: String? = null,
            @Field @JvmField var description: String? = null,
            @Field @JvmField var url: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("templateContactInfo")
        data class ContactInfoTemplate(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var email: String? = null,
            @Field @JvmField var description: String? = null,
            @Field @JvmField var facebookTag: String? = null,
            @Field @JvmField var twitterTag: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("elementText")
        data class TextElement(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var text: String? = null,
            @Field @JvmField var fontStyle: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("elementImage")
        data class ImageElement(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var image: Asset? = null,
            @Field @JvmField var description: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("elementYouTubeVideo")
        data class YoutubeElement(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var title: String? = null,
            @Field @JvmField var url: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("elementLink")
        data class LinkElement(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var displayText: String? = null,
            @Field @JvmField var url: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()

        @ContentType("linkReference")
        data class LinkReference(
            @Field @JvmField var name: String? = null,
            @Field @JvmField var linkedType: String? = null,
            @Field @JvmField var linkedSlug: String? = null,
            @Field @JvmField var slug: String? = null
        ) : Resource()
    }
}
