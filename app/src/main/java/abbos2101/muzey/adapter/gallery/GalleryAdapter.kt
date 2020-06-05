package abbos2101.muzey.adapter.gallery

import abbos2101.muzey.R
import abbos2101.muzey.ui.content.ContentPresenter
import abbos2101.muzey.ui.gallery.GalleryPresenter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(
    private val presenter: GalleryPresenter
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    class ViewHolder : RecyclerView.ViewHolder {
        var img: ImageView? = null

        constructor(itemView: View) : super(itemView) {
            this.img = itemView.findViewById(R.id.item_gallery_img)
        }
    }

    private var list: ArrayList<String> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = this.list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gallaryHolder = GalleryHolder(presenter, list)
        gallaryHolder.bindHolder(holder, position)
    }

    fun setNewList(newList: ArrayList<String>) {
        this.list = newList
    }
}