package abbos2101.muzey.ui

import abbos.uzeu.database.DatabaseProvider
import abbos2101.Stroitelstvo.database.model.MainModel
import android.content.Context

class MainPresenter(
    val ctx: Context
) {
    private val mainAction by lazy { ctx as MainAction }
    private val database by lazy { DatabaseProvider.instance(ctx).databaseDao() }
    private var language_id = 0

    fun loadData(lang_id: Int) {
        if (lang_id != this.language_id) {
            this.language_id = lang_id
            val newList = database.loadMainList(lang_id)
            mainAction.onUpdateList(newList as ArrayList<MainModel>)
        }
    }

    fun itemClick(){

    }
}