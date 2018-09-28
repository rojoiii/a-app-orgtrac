package edu.csun.orgtrac

class OrgTrac{
    class Model{
        data class LoadingPage(
            var name: String? = null,
            var title: String? = null,
            var image: String? = null,
            var message: String? = null
        )
        
        data class LandingPage(
            var name: String? = null,
            var title: String? = null,
            var pages: List<MainPage>? = null
        )
        
        data class MainPage(
            var name: String? = null,
            var title: String? = null,
            var content: List<LinkReference>? = null
        )
        
        data class WebTemplate(
            var name: String? = null,
            var title: String? = null,
            var url: String? = null
        )
        
        data class ProfileTemplate(
            var name: String? = null,
            var image: String? = null,
            var title: String? = null,
            var description: String? = null
        )
        
        data class LocationTemplate(
            var name: String? = null,
            var title: String? = null,
            var address: String? = null,
            var latitude: Double? = null,
            var longitude: Double? = null
        )
        
        data class ArticleTemplate(
            var name: String? = null,
            var title: String? = null,
            var createdBy: String? = null,
            var description: String? = null,
            var url: String? = null
        )
        
        data class ContactInfoTemplate(
            var name: String? = null,
            var title: String? = null,
            var email: String? = null,
            var description: String? = null,
            var facebookTag: String? = null,
            var twitterTag: String? = null
        )
        
        data class TextElement(
            var name: String? = null,
            var text: String? = null,
            var fontStyle: String? = null
        )
        
        data class ImageElement(
            var name: String? = null,
            var image: String? = null,
            var description: String? = null
        )
        
        data class YoutubeElement(
            var name: String? = null,
            var url: String? = null
        )
        
        data class LinkElement(
            var name: String? = null,
            var displayText: String? = null,
            var url: String? = null
        )
        
        data class LinkReference(
            var name: String? = null,
            var linkedType: String? = null,
            var linkedSlug: String? = null
        )
    }
}