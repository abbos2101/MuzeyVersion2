package abbos2101.muzey.ui.content

import android.content.Context
import android.content.Intent

class ContentPresenter(
    private val ctx: Context
) {
    private val contentAction by lazy { ctx as ContentAction }

    fun loadData(intent: Intent){

    }
}