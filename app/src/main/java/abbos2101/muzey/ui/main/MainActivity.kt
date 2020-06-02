package abbos2101.muzey.ui.main

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.adapter.main.MainAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAction {
    private val presenter by lazy { MainPresenter(this) }
    private val adapter by lazy { MainAdapter(presenter) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setEvent()
    }

    private fun init() {
        main_rv.adapter = adapter
        presenter.loadData()
    }

    private fun setEvent() {
        main_img_uz.setOnClickListener { adapter.setLanguage(1) }
        main_img_ru.setOnClickListener { adapter.setLanguage(2) }
        main_img_en.setOnClickListener { adapter.setLanguage(3) }
    }

    override fun onUpdateList(newList: ArrayList<MainModel>) {
        adapter.setNewList(newList)
    }

    override fun onStartIntent(intent: Intent) {
        startActivity(intent)
    }
}