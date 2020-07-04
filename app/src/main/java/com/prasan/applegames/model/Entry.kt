package com.prasan.applegames.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
data class Entry(
    @NonNull @PrimaryKey @ColumnInfo(name = "id") val id: ID,
    @field:Json(name = "im:name")val name: Icon,
    @field:Json(name = "rights")val rights: Icon? = null,
    @field:Json(name = "im:price")val price: IMPrice,
    @field:Json(name = "im:image")val image:  List<IMImage>,
    @field:Json(name = "im:artist")val artist: IMArtist,
    @field:Json(name = "title")val title: Icon,
    @field:Json(name = "im:releaseDate")val imReleaseDate: IMReleaseDate
): Parcelable {

    @Parcelize
    data class ID (
        @field:Json(name = "attributes")val attributes: IDAttributes
    ):Parcelable

    @Parcelize
    data class Icon(
        @field:Json(name = "label")val label: String
    ):Parcelable


    @Parcelize
    data class IMPrice (
        @field:Json(name = "attributes")val attributes: IMPriceAttributes
    ):Parcelable

    @Parcelize
    data class IDAttributes (
        @field:Json(name = "im:id")val imID: String
    ):Parcelable

    @Parcelize
    data class IMPriceAttributes (
        @field:Json(name = "amount")val amount: String
    ):Parcelable

    @Parcelize
    data class IMImage (
        @field:Json(name = "label")val label: String
    ):Parcelable

    @Parcelize
    data class IMArtist (
        @field:Json(name = "label")val label: String
    ):Parcelable

    @Parcelize
    data class IMReleaseDate (
        @field:Json(name = "label")val label: String,
        @field:Json(name = "attributes")val attributes: Icon
    ):Parcelable

}
