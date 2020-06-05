package abbos2101.muzey.ui.content

import abbos2101.muzey.R
import abbos2101.muzey.adapter.content.ContentAdapter
import abbos2101.muzey.adapter.content_gallery.ContentGalleryAdapter
import abbos2101.muzey.common.*
import abbos2101.muzey.database.model.ContentModel
import abbos2101.muzey.ui.view.ViewActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_content.*
import java.util.*
import kotlin.collections.ArrayList

class ContentActivity : AppCompatActivity(), ContentAction {
    private val presenter by lazy { ContentPresenter(this) }
    private val mainAdapter: ContentAdapter by lazy { ContentAdapter(presenter) }
    private val galleryAdapter: ContentGalleryAdapter by lazy { ContentGalleryAdapter(presenter) }
    private var galleryList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
        setEvent()
    }

    private fun init() {
        content_rv_main.adapter = mainAdapter
        content_rv_gallery.adapter = galleryAdapter
        presenter.loadMainData()
        presenter.updateCountView()
        presenter.loadGalleryData()
    }

    private fun setEvent() {
        content_img_back.setOnClickListener { finish() }
        content_img_uz.setOnClickListener { mainAdapter.setLanguage(lang_uz) }
        content_img_ru.setOnClickListener { mainAdapter.setLanguage(lang_ru) }
        content_img_en.setOnClickListener { mainAdapter.setLanguage(lang_en) }
    }

    override fun onUpdateMainList(newList: ArrayList<ContentModel>) {
        mainAdapter.setNewList(newList)
    }

    override fun onUpdateGalleryList(newList: ArrayList<String>) {
        this.galleryList = newList
        galleryAdapter.setNewList(newList)
    }

    override fun onVisibleGallery(visible: Int) {
        content_rv_gallery.visibility = visible
    }

    override fun onItemGalleryClick(newList: ArrayList<String>) {
        val intent = Intent(this, ViewActivity::class.java).putExtra("list", newList)
        startActivity(intent)
    }
}