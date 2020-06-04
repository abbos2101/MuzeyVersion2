package abbos2101.muzey.ui.content

import abbos.uzeu.database.DatabaseProvider
import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.adapter.content.ContentAdapter
import abbos2101.muzey.common.*
import abbos2101.muzey.database.model.ContentModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity(), ContentAction {
    private val presenter by lazy { ContentPresenter(this) }
    private val adapter: ContentAdapter by lazy { ContentAdapter(presenter) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
        setEvent()
    }

    private fun init() {
        content_rv.adapter = adapter
        presenter.loadData()
        presenter.updateCountView()
    }

    private fun setEvent() {
        content_img_back.setOnClickListener { finish() }
        content_img_uz.setOnClickListener { adapter.setLanguage(lang_uz) }
        content_img_ru.setOnClickListener { adapter.setLanguage(lang_ru) }
        content_img_en.setOnClickListener { adapter.setLanguage(lang_en) }
    }

    override fun onUpdateList(newList: ArrayList<ContentModel>) {
        adapter.setNewList(newList)
    }
}