package abbos2101.muzey.ui.main

import abbos.uzeu.database.DatabaseProvider
import abbos2101.Stroitelstvo.database.model.MainModel
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

    fun itemClick(model: MainModel, position: Int) {
        val intent = Intent(ctx, ContentActivity::class.java)
            .putExtra("uz_title", "${model.uz_title}")
            .putExtra("uz_description", "${model.uz_description}")
            .putExtra("uz_text", "${model.uz_text}")
            .putExtra("ru_title", "${model.ru_title}")
            .putExtra("ru_description", "${model.ru_description}")
            .putExtra("ru_text", "${model.ru_text}")
            .putExtra("en_title", "${model.en_title}")
            .putExtra("en_description", "${model.en_description}")
            .putExtra("en_text", "${model.en_text}")
            .putExtra("position", "$position")
        mainAction.onStartIntent(intent)
    }
}