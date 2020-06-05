package abbos2101.muzey.ui.main

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.adapter.main.MainAdapter
import abbos2101.muzey.common.lang_en
import abbos2101.muzey.common.lang_ru
import abbos2101.muzey.common.lang_uz
import abbos2101.muzey.ui.gallery.GalleryActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainAction {
    private val presenter by lazy { MainPresenter(this) }
    private val adapter by lazy { MainAdapter(presenter) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        hideNavigationBar()
    }

    private fun init() {
        main_rv.adapter = adapter
        main_img_uz.setOnClickListener {
            adapter.setLanguage(lang_uz)
            main_tv_title.text = "O'ZBEKISTON TARIXI DAVLAT MUZEYINING TOSHKENT MUZEYI FILIALI"
        }
        main_img_ru.setOnClickListener {
            adapter.setLanguage(lang_ru)
            main_tv_title.text =
                "ФИЛИАЛ МУЗЕЯ ТАШКЕНТА ГОСУДАРСТВЕННОГО МУЗЕЯ ИСТОРИИ УЗБЕКИСТАНА"
        }
        main_img_en.setOnClickListener {
            adapter.setLanguage(lang_en)
            main_tv_title.text =
                "BRANCH OF MUSEUM OF TASHKENT OF THE STATE MUSEUM OF HISTORY OF UZBEKISTAN"
        }
        main_img_gallery.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }
        if (!isMyLauncherDefault())
            showSelectLauncher()
    }

    private fun isMyLauncherDefault(): Boolean {
        val localPackageManager = packageManager
        val intent = Intent("android.intent.action.MAIN")
        intent.addCategory("android.intent.category.HOME")
        val str = localPackageManager.resolveActivity(
            intent,
            PackageManager.MATCH_DEFAULT_ONLY
        ).activityInfo.packageName
        return str == packageName
    }

    private fun showSelectLauncher() {
        val startMain = Intent(Intent.ACTION_MAIN)
        startMain.addCategory(Intent.CATEGORY_HOME)
        startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(startMain)
    }

    private fun hideNavigationBar() {
        val decorView: View = this.window.decorView
        val uiOptions: Int = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        decorView.setSystemUiVisibility(uiOptions)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return false
    }

    override fun onUpdateList(newList: ArrayList<MainModel>) {
        adapter.setNewList(newList)
    }

    override fun onStartIntent(intent: Intent) {
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadData()
    }
}