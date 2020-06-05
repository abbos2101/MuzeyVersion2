package abbos2101.muzey.ui.gallery

import abbos2101.muzey.common.isAssetExists
import android.content.Context

class GalleryPresenter(
    val ctx: Context
) {
    private val galleryAction by lazy { ctx as GalleryAction }

    fun loadGallery() {
        val list: ArrayList<String> = ArrayList()
        var img = 1
        while (true) {
            val imgAssetsUrl = "image/gallery/img${img}.jpg"
            if (isAssetExists(ctx, imgAssetsUrl)) {
                list.add(imgAssetsUrl)
                img++
            } else break
        }
        galleryAction.onUpdateList(list)
    }
}