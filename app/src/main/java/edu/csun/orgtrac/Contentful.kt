package edu.csun.orgtrac

import com.contentful.vault.ContentType
import com.contentful.vault.Field
import com.contentful.vault.Resource
import com.contentful.vault.Space

@Space(
    value = "cfexampleapi",
    models = [

    ],
    locales = ["en-us"],
    dbVersion = 1
)
class Space

class Model {
    @ContentType("pageLoading")
    data class LoadingPage(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("pageLanding")
    data class LandingPage(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("pageMain")
    data class MainPage(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("templateWeb")
    data class WebTemplate(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("templateProfile")
    data class ProfileTemplate(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("templateLocation")
    data class LocationTemplate(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("templateArticle")
    data class ArticleTemplate(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("templateContactInfo")
    data class ContactInfoTemplate(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("elementText")
    data class TextElement(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("elementImage")
    data class ImageElement(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("elementYouTubeVideo")
    data class YoutubeElement(
        @Field @JvmField var slug: String? = null
    ) : Resource()

    @ContentType("elementLink")
    data class LinkElement(
        @Field @JvmField var slug: String? = null
    ) : Resource()
}