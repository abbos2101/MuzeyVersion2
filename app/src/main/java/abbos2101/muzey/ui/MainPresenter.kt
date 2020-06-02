package abbos2101.muzey.ui

import abbos.uzeu.database.DatabaseProvider
import abbos2101.Stroitelstvo.database.model.MainModel
import android.content.Context

class MainPresenter(
    val ctx: Context
) {
    private val mainAction by lazy { ctx as MainAction }
    private val database by lazy { DatabaseProvider.instance(ctx).databaseDao() }

    fun loadData() {
        val newList = database.loadMainList(1)
        mainAction.onUpdateList(newList as ArrayList<MainModel>)
    }
}