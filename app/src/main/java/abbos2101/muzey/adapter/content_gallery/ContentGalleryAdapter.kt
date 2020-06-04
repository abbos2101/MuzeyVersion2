package abbos2101.muzey.adapter.content_gallery

import abbos2101.muzey.R
import abbos2101.muzey.adapter.content.ContentHolder
import abbos2101.muzey.ui.content.ContentPresenter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_content_gallery.view.*

class ContentGalleryAdapter(
    private val presenter: ContentPresenter
) : RecyclerView.Adapter<ContentGalleryAdapter.ViewHolder>() {
    class ViewHolder : RecyclerView.ViewHolder {
        var img: ImageView? = null

        constructor(itemView: View) : super(itemView) {
            this.img = itemView.findViewById(R.id.item_content_gallery_img)
        }
    }

    private var list: ArrayList<String> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = this.list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contentGallaryHolder = ContentGalleryHolder(presenter, list)
        contentGallaryHolder.bindHolder(holder, position)
    }

    fun setNewList(newList: ArrayList<String>) {
        this.list = newList
        this.notifyDataSetChanged()
    }
}