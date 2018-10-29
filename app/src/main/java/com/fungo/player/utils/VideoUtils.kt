package com.fungo.player.utils

import android.content.Context
import android.database.Cursor
import android.os.Environment
import android.provider.MediaStore
import com.fungo.baselib.utils.LogUtils
import com.fungo.player.dao.VideoEntity
import java.io.File
import java.io.FileFilter

/**
 * @author Pinger
 * @since 2018/9/29 下午7:39
 */
object VideoUtils {


    /**
     * 异步查找视频，在子线程运行
     * 使用系统ContentResolver的方式查询
     */
    fun queryVideoList(context: Context?): List<VideoEntity> {
        val videoList: ArrayList<VideoEntity> = ArrayList()
        if (context != null) {
            try {

                val thumbColumns = arrayOf(MediaStore.Video.Thumbnails.DATA, MediaStore.Video.Thumbnails.VIDEO_ID)
                val mediaColumns = arrayOf(MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DATA, MediaStore.Video.Media.DURATION)


                val cursor: Cursor? = context.contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaColumns, null, null, null)
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        val id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID))

                        val displayName: String = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))

                        val path: String = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))
                        val duration: Long = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION))

                        val thumbCursor: Cursor? = context.contentResolver?.query(
                                MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                                thumbColumns, MediaStore.Video.Thumbnails.VIDEO_ID
                                + "=" + id, null, null)
                        val thumbUrl = if (thumbCursor != null && thumbCursor.moveToFirst()) {
                            thumbCursor.getString(thumbCursor
                                    .getColumnIndex(MediaStore.Video.Thumbnails.DATA))
                        } else ""
                        thumbCursor?.close()

                        val entity = VideoEntity(displayName, duration, path, thumbUrl)

                        videoList.add(entity)
                    }
                    cursor.close()
                }
            } catch (e: Exception) {
                LogUtils.e(e)
            }

        }
        return videoList
    }

    /**
     * 异步查找视频，在子线程运行
     * 查询本地所有文件，找出对应后缀的视频文件
     */

    fun queryVideoList(): List<VideoEntity> {
        val videoList = getVideoFile(ArrayList(), Environment.getExternalStorageDirectory())
        return filterVideo(videoList)
    }


    /**
     * 查找文件
     */
    private fun getVideoFile(videoList: ArrayList<VideoEntity>, file: File): List<VideoEntity> {
        file.listFiles(FileFilter {
            it.usableSpace

            var name: String = it.name

            val index: Int = name.indexOf('.')
            if (index != -1) {
                name = name.substring(index)
                if (name.equals(".mp4")
                        || name.equals(".3gp")
                        || name.equals(".wmv")
                        || name.equals(".ts")
                        || name.equals(".rmvb")
                        || name.equals(".mov")
                        || name.equals(".m4v")
                        || name.equals(".avi")
                        || name.equals(".m3u8")
                        || name.equals(".3gpp")
                        || name.equals(".3gpp2")
                        || name.equals(".mkv")
                        || name.equals(".flv")
                        || name.equals(".divx")
                        || name.equals(".f4v")
                        || name.equals(".rm")
                        || name.equals(".asf")
                        || name.equals(".ram")
                        || name.equals(".mpg")
                        || name.equals(".v8")
                        || name.equals(".swf")
                        || name.equals(".m2v")
                        || name.equals(".asx")
                        || name.equals(".ra")
                        || name.equals(".ndivx")
                        || name.equals(".xvid")) {

                    val videoEntity = VideoEntity(it.name, it.length(), it.path, "")

                    videoList.add(videoEntity)

                    println("----- 视频文件名：" + videoEntity.videoName + " -----")

                    return@FileFilter true
                }
                // 判断是不是目录
            } else if (it.isDirectory) {
                getVideoFile(videoList, it)
            }
            return@FileFilter false
        })
        return videoList
    }

    /**
     * 过滤小于10M的视频文件
     * @param videoEntities
     * @return
     */
    private fun filterVideo(videoEntities: List<VideoEntity>): List<VideoEntity> {
        val newVideos: ArrayList<VideoEntity> = ArrayList()
        videoEntities.forEach {
            val file = File(it.videoPath)
            if (file.exists() && file.isFile && file.length() > 10485760) {
                newVideos.add(it)
            } else {
                LogUtils.e("视频文件太小或者不存在")
            }
        }
        return newVideos
    }


}