package com.fungo.player.dao

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Pinger
 * @since 2018/9/29 下午7:43
 */
data class VideoEntity(val videoName: String, val videoDuration: Long, val videoPath: String, val videoThumbPath: String) : Parcelable {

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(videoName)
        dest?.writeLong(videoDuration)
        dest?.writeString(videoPath)
        dest?.writeString(videoThumbPath)

    }

    override fun describeContents(): Int {
        return 0
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString())

    companion object CREATOR : Parcelable.Creator<VideoEntity> {
        override fun createFromParcel(parcel: Parcel): VideoEntity {
            return VideoEntity(parcel)
        }

        override fun newArray(size: Int): Array<VideoEntity?> {
            return arrayOfNulls(size)
        }
    }
}