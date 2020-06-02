package abbos2101.muzey.ui

import abbos2101.Stroitelstvo.database.model.MainModel

interface MainAction {
    fun onUpdateList(newList: ArrayList<MainModel>)
}