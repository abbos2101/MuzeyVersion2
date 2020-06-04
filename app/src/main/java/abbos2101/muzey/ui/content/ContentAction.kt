package abbos2101.muzey.ui.content

import abbos2101.muzey.database.model.ContentModel

interface ContentAction {
    fun onUpdateMainList(newList: ArrayList<ContentModel>)
    fun onUpdateGalleryList(newList: ArrayList<String>)
    fun onVisibleGallery(visible: Int)
}