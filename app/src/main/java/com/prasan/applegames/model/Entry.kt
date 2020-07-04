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
    @NonNull @PrimaryKey @ColumnInfo(name = "id") val id:@RawValue ID,
    @field:Json(name = "im:name")val name: @RawValue Icon,
    @field:Json(name = "rights")val rights: @RawValue Icon? = null,
    @field:Json(name = "im:price")val price: @RawValue IMPrice,
    @field:Json(name = "im:image")val image: @RawValue List<IMImage>,
    @field:Json(name = "im:artist")val artist: @RawValue IMArtist,
    @field:Json(name = "title")val title: @RawValue Icon,
    @field:Json(name = "im:releaseDate")val imReleaseDate: @RawValue IMReleaseDate
): Parcelable {

    data class ID (
        @field:Json(name = "attributes")val attributes: IDAttributes
    )

    data class IDAttributes (
        @field:Json(name = "im:id")val imID: String
    )

    data class Icon(
        @field:Json(name = "label")val label: String
    )

    data class IMPrice (
        @field:Json(name = "attributes")val attributes: IMPriceAttributes
    )

    data class IMPriceAttributes (
        @field:Json(name = "amount")val amount: String
    )

    data class IMImage (
        @field:Json(name = "label")val label: String
    )

    data class IMArtist (
        @field:Json(name = "label")val label: String
    )

    data class IMReleaseDate (
        @field:Json(name = "label")val label: String,
        @field:Json(name = "attributes")val attributes: Icon
    )

}
