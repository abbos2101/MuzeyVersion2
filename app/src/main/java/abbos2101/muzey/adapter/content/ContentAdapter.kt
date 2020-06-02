package abbos2101.muzey.adapter.content

import abbos2101.muzey.R
import abbos2101.muzey.database.model.ContentModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {
    class ViewHolder : RecyclerView.ViewHolder {
        var img: ImageView? = null
        var tv: TextView? = null

        constructor(itemView: View) : super(itemView) {
            this.img = itemView.findViewById(R.id.item_content_img)
            this.tv = itemView.findViewById(R.id.item_content_tv)
        }
    }

    private var list: ArrayList<ContentModel> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contentHolder = ContentHolder(list)
        contentHolder.bindHolder(holder, position)
    }
}