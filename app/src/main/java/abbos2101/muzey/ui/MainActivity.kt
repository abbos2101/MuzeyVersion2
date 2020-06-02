package abbos2101.muzey.ui

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.adapter.MainAdapter
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
    }

    private fun init() {
        main_rv.adapter = adapter
        presenter.loadData()
    }

    override fun onUpdateList(newList: ArrayList<MainModel>) {
        adapter.setNewList(newList)
    }
}