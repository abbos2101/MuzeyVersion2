package abbos2101.muzey.ui.gallery

import abbos2101.muzey.R
import abbos2101.muzey.adapter.gallery.GalleryAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity(), GalleryAction {
    private val presenter by lazy { GalleryPresenter(this) }
    private val adapter by lazy { GalleryAdapter(presenter) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        init()
    }

    private fun init() {
        gallery_rv.adapter = adapter
        presenter.loadGallery()
        gallery_img_back.setOnClickListener { finish() }
        gallery_img_pin.setOnClickListener {
            getPackageManager().clearPackagePreferredActivities(getPackageName())
            finish()
        }
    }

    override fun onUpdateList(newList: ArrayList<String>) {
        adapter.setNewList(newList)
    }
}