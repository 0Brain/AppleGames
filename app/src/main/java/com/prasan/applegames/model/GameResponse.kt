package com.prasan.applegames.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class GameResponse(@Json(name = "feed") val feed: Feed) {
    @JsonClass(generateAdapter = true)
    data class Feed(
        @Json(name = "author") val author: Author,
        @Json(name = "entry") val entry: List<Entry>,
        @Json(name = "updated") val updated: Updated,
        @Json(name = "rights") val rights: RightsFeed,
        @Json(name = "title") val title: Title,
        @Json(name = "icon") val icon: Icon,
        @Json(name = "link") val link: List<Link>,
        @Json(name = "id") val id: Id
    )

    @JsonClass(generateAdapter = true)
    data class Author(
        @Json(name = "name") val name: Name,
        @Json(name = "uri") val uri: Uri
    )

    @JsonClass(generateAdapter = true)
    data class Updated(
        @Json(name = "label") val label: String
    )

    @JsonClass(generateAdapter = true)
    data class RightsFeed(
        @Json(name = "label") val label: String
    )

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Title(
        @Json(name = "label") val label: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    data class Icon(
        @Json(name = "label") val label: String
    )

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Link(
        @Json(name = "attributes") val attributes: AttributesLink
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesLink(
        @Json(name = "rel") val rel: String,
        @Json(name = "type") val type: String?=null,
        @Json(name = "href") val href: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    data class Name(
        @Json(name = "label") val label: String
    )

    @JsonClass(generateAdapter = true)
    data class Uri(
        @Json(name = "label") val label: String
    )

    @JsonClass(generateAdapter = true)
    @Entity
    @Parcelize
    data class Entry(
        @PrimaryKey @Json(name = "im:name") val name: NameEntry,
        @Json(name = "rights") val rights: Rights?=null,
        @Json(name = "im:price") val price: Price,
        @Json(name = "im:image") val image: List<Image>,
        @Json(name = "im:artist") val artist: Artist,
        @Json(name = "title") val title: Title,
        @Json(name = "link") val link: Link,
        @Json(name = "id") val id: Id,
        @Json(name = "im:contentType") val contentType: ContentType,
        @Json(name = "category") val category: Category,
        @Json(name = "im:releaseDate") val releaseDate: ReleaseDate
    ):Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Id(
        @Json(name = "label") val label: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class NameEntry(
        @Json(name = "label") val label: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Rights(
        @Json(name = "label") val label: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Price(
        @Json(name = "label") val label: String,
        @Json(name = "attributes") val attributes: AttributesPrice
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesPrice(
        @Json(name = "amount") val amount: String,
        @Json(name = "currency") val currency: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Image(
        @Json(name = "label") val label: String,
        @Json(name = "attributes") val attributes: AttributesImage
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesImage(
        @Json(name = "height") val height: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Artist(
        @Json(name = "label") val label: String,
        @Json(name = "attributes") val attributes: AttributesArtist?=null
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesArtist(
        @Json(name = "href") val url: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class ContentType(
        @Json(name = "attributes") val attributes: AttributesContentType
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesContentType(
        @Json(name = "term") val term: String,
        @Json(name = "label") val label: String
    ) : Parcelable


    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Category(
        @Json(name = "attributes") val attributes: AttributesCategory
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesCategory(
        @Json(name = "im:id") val id: String,
        @Json(name = "term") val term: String,
        @Json(name = "scheme") val scheme: String,
        @Json(name = "label") val label: String
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class ReleaseDate(
        @Json(name = "label") val label: String,
        @Json(name = "attributes") val attributes: AttributesRelease
    ) : Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AttributesRelease(
        @Json(name = "label") val label: String
    ) : Parcelable

}