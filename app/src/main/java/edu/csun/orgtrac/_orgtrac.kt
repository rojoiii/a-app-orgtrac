package edu.csun.orgtrac

import timber.log.Timber

class OrgTrac {
    class Model {
        data class LoadingPage(
            var title: String? = null,
            var image: String? = null,
            var message: String? = null
        ) {
            companion object {
                fun build(loadingPage: Contentful.Model.LoadingPage?): LoadingPage? {
                    if (loadingPage != null) {
                        return LoadingPage(
                            loadingPage.title,
                            loadingPage.image?.url(),
                            loadingPage.message
                        )
                    }

                    return null
                }
            }
        }

        data class LandingPage(
            var title: String? = null,
            var pages: List<MainPage>? = null
        ) {
            companion object {
                fun build(
                    landingPage: Contentful.Model.LandingPage?,
                    webTemplates: HashMap<String, OrgTrac.Model.Content.Template.Web>,
                    profileTemplates: HashMap<String, OrgTrac.Model.Content.Template.Profile>,
                    locationTemplates: HashMap<String, OrgTrac.Model.Content.Template.Location>,
                    articleTemplates: HashMap<String, OrgTrac.Model.Content.Template.Article>,
                    contactInfoTemplates: HashMap<String, OrgTrac.Model.Content.Template.ContactInfo>,
                    textElements: HashMap<String, OrgTrac.Model.Content.Element.Text>,
                    imageElements: HashMap<String, OrgTrac.Model.Content.Element.Image>,
                    youtubeVideoElements: HashMap<String, OrgTrac.Model.Content.Element.Youtube>,
                    linkElements: HashMap<String, OrgTrac.Model.Content.Element.Link>
                ): LandingPage? {
                    if (landingPage != null) {
                        val pages = ArrayList<MainPage>()
                        landingPage.pages?.forEach { mainPage ->
                            val page = MainPage.build(
                                mainPage,
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
                            if (page != null) {
                                pages.add(page)
                            }
                        }

                        return LandingPage(landingPage.title, pages)
                    }

                    return null
                }
            }
        }

        data class MainPage(
            var title: String? = null,
            var content: List<Content>? = null,
            var slug: String? = null
        ) {
            companion object {
                fun build(
                    mainPage: Contentful.Model.MainPage?,
                    webTemplates: HashMap<String, OrgTrac.Model.Content.Template.Web>,
                    profileTemplates: HashMap<String, OrgTrac.Model.Content.Template.Profile>,
                    locationTemplates: HashMap<String, OrgTrac.Model.Content.Template.Location>,
                    articleTemplates: HashMap<String, OrgTrac.Model.Content.Template.Article>,
                    contactInfoTemplates: HashMap<String, OrgTrac.Model.Content.Template.ContactInfo>,
                    textElements: HashMap<String, OrgTrac.Model.Content.Element.Text>,
                    imageElements: HashMap<String, OrgTrac.Model.Content.Element.Image>,
                    youtubeVideoElements: HashMap<String, OrgTrac.Model.Content.Element.Youtube>,
                    linkElements: HashMap<String, OrgTrac.Model.Content.Element.Link>
                ): MainPage? {
                    if (mainPage != null) {
                        val contents = ArrayList<OrgTrac.Model.Content>()

                        mainPage.content?.forEach { linkReference ->
                            val content: Content? = when (linkReference.linkedType) {
                                "Template - Web" -> webTemplates[linkReference.linkedSlug]
                                "Template - Profile" -> profileTemplates[linkReference.linkedSlug]
                                "Template - Location" -> locationTemplates[linkReference.linkedSlug]
                                "Template - Article" -> articleTemplates[linkReference.linkedSlug]
                                "Template - Contact Info" -> contactInfoTemplates[linkReference.linkedSlug]
                                "Element - Text" -> textElements[linkReference.linkedSlug]
                                "Element - Image" -> imageElements[linkReference.linkedSlug]
                                "Element - YouTube Video" -> youtubeVideoElements[linkReference.linkedSlug]
                                "Element - Link" -> linkElements[linkReference.linkedSlug]
                                else -> {
                                    null
                                }
                            }

                            if (content == null) {
                                Timber.d("Error Finding (${linkReference.linkedSlug}) in (${linkReference.linkedType})")
                            }

                            content?.let {
                                contents.add(content)
                            }
                        }

                        return MainPage(
                            mainPage.title,
                            contents,
                            mainPage.slug
                        )
                    }

                    return null
                }
            }
        }

        sealed class Content {
            sealed class Template : Content() {
                data class Web(
                    var title: String? = null,
                    var url: String? = null
                ) : Template() {
                    companion object {
                        fun build(template: Contentful.Model.WebTemplate?): Web? {
                            if (template != null) {
                                return Web(
                                    template.title,
                                    template.url
                                )
                            }

                            return null
                        }
                    }
                }

                data class Profile(
                    var image: String? = null,
                    var title: String? = null,
                    var description: String? = null
                ) : Template() {
                    companion object {
                        fun build(template: Contentful.Model.ProfileTemplate?): Profile? {
                            if (template != null) {
                                return Profile(
                                    template.image?.url(),
                                    template.title,
                                    template.description
                                )
                            }

                            return null
                        }
                    }
                }

                data class Location(
                    var title: String? = null,
                    var address: String? = null,
                    var latitude: Double? = null,
                    var longitude: Double? = null
                ) : Template() {
                    companion object {
                        fun build(template: Contentful.Model.LocationTemplate?): Location? {
                            if (template != null) {
                                return Location(
                                    template.title,
                                    template.address,
                                    template.latitude,
                                    template.longitude
                                )
                            }

                            return null
                        }
                    }
                }

                data class Article(
                    var title: String? = null,
                    var createdBy: String? = null,
                    var description: String? = null,
                    var url: String? = null
                ) : Template() {
                    companion object {
                        fun build(template: Contentful.Model.ArticleTemplate?): Article? {
                            if (template != null) {
                                return Article(
                                    template.title,
                                    template.createdBy,
                                    template.description,
                                    template.url
                                )
                            }

                            return null
                        }
                    }
                }

                data class ContactInfo(
                    var title: String? = null,
                    var email: String? = null,
                    var description: String? = null,
                    var facebookTag: String? = null,
                    var twitterTag: String? = null
                ) : Template() {
                    companion object {
                        fun build(template: Contentful.Model.ContactInfoTemplate?): ContactInfo? {
                            if (template != null) {
                                return ContactInfo(
                                    template.title,
                                    template.email,
                                    template.description,
                                    template.facebookTag,
                                    template.twitterTag
                                )
                            }

                            return null
                        }
                    }
                }
            }

            sealed class Element : Content() {
                data class Text(
                    var text: String? = null,
                    var fontStyle: String? = null
                ) : Element() {
                    companion object {
                        fun build(element: Contentful.Model.TextElement?): Text? {
                            if (element != null) {
                                return Text(
                                    element.text,
                                    element.fontStyle
                                )
                            }

                            return null
                        }
                    }
                }

                data class Image(
                    var image: String? = null,
                    var description: String? = null
                ) : Element() {
                    companion object {
                        fun build(element: Contentful.Model.ImageElement?): Image? {
                            if (element != null) {
                                return Image(
                                    element.image?.url(),
                                    element.description
                                )
                            }

                            return null
                        }
                    }
                }

                data class Youtube(
                    var url: String? = null
                ) : Element() {
                    companion object {
                        fun build(element: Contentful.Model.YoutubeElement?): Youtube? {
                            if (element != null) {
                                return Youtube(
                                    element.url
                                )
                            }

                            return null
                        }
                    }
                }

                data class Link(
                    var displayText: String? = null,
                    var url: String? = null
                ) : Element() {
                    companion object {
                        fun build(element: Contentful.Model.LinkElement?): Link? {
                            if (element != null) {
                                return Link(
                                    element.displayText,
                                    element.url
                                )
                            }

                            return null
                        }
                    }
                }
            }
        }
    }
}