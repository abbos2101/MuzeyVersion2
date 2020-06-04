package abbos2101.muzey.ui.content

import abbos.uzeu.database.DatabaseProvider
import abbos2101.muzey.common.common_model
import abbos2101.muzey.common.common_position
import abbos2101.muzey.common.isAssetExists
import abbos2101.muzey.database.model.ContentModel
import android.content.Context

class ContentPresenter(
    val ctx: Context
) {
    private val contentAction by lazy { ctx as ContentAction }

    fun loadMainData() {
        val list = ArrayList<ContentModel>()
        if (common_model != null) {
            list.add(
                ContentModel(
                    null, common_model!!.uz_text, common_model!!.ru_text, common_model!!.en_text
                )
            )
        }
        var img = 1
        while (true) {
            val imgAssetsUrl = "image/items/item${common_position + 1}/main/img${img}.jpg"
            if (isAssetExists(ctx, imgAssetsUrl)) {
                list.add(ContentModel(imgAssetsUrl, "", "", ""))
                img++
            } else break
        }
        contentAction.onUpdateMainList(list)
    }

    fun loadGalleryData() {
        val list: ArrayList<String> = ArrayList()
        var img = 1
        while (true) {
            val imgAssetsUrl = "image/items/item${common_position + 1}/gallery/img${img}.jpg"
            if (isAssetExists(ctx, imgAssetsUrl)) {
                list.add(imgAssetsUrl)
                img++
            } else break
        }
        contentAction.onUpdateGalleryList(list)
    }

    fun updateCountView() {
        common_model!!.count_view++
        DatabaseProvider.instance(ctx).databaseDao().updateMainList(common_model!!)
    }

    fun setVisibleGallery(visible: Int) {
        contentAction.onVisibleGallery(visible)
    }
}