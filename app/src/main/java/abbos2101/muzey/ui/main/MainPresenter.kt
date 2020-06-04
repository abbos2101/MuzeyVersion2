package abbos2101.muzey.ui.main

import abbos.uzeu.database.DatabaseProvider
import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.common.common_model
import abbos2101.muzey.common.common_position
import abbos2101.muzey.ui.content.ContentActivity
import android.content.Context
import android.content.Intent

class MainPresenter(
    val ctx: Context
) {
    private val mainAction by lazy { ctx as MainAction }
    private val database by lazy { DatabaseProvider.instance(ctx).databaseDao() }

    fun loadData() {
        val newList = database.loadMainList()
        mainAction.onUpdateList(newList as ArrayList<MainModel>)
    }

    fun itemClick(model: MainModel, possition: Int) {
        common_position = possition
        common_model = model
        val intent = Intent(ctx, ContentActivity::class.java)
        mainAction.onStartIntent(intent)
    }
}