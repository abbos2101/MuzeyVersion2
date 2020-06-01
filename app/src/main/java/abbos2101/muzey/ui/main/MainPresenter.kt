package abbos2101.muzey.ui.main

import android.content.Context

class MainPresenter(
    private val ctx: Context
) {
    private val mainAction by lazy { ctx as MainAction }
    
}