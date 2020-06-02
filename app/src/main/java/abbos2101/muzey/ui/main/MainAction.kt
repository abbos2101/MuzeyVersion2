package abbos2101.muzey.ui.main

import abbos2101.Stroitelstvo.database.model.MainModel
import android.content.Intent

interface MainAction {
    fun onUpdateList(newList: ArrayList<MainModel>)
    fun onStartIntent(intent: Intent)
}