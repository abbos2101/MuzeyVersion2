package abbos2101.muzey.ui.content

import abbos2101.muzey.database.model.ContentModel

interface ContentAction {
    fun onUpdateList(newList: ArrayList<ContentModel>)
}