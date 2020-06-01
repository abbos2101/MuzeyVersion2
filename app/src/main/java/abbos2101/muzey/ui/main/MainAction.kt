package abbos2101.muzey.ui.main

import abbos2101.muzey.TmpModel

interface MainAction {
    fun onUpdateList(newList: ArrayList<TmpModel>)
}