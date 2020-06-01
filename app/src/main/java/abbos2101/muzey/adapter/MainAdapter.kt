package abbos2101.muzey.adapter

import abbos2101.muzey.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView)

        val img: TextView by lazy { itemView.findViewById(R.id.item_main_img) }
        val rb: TextView by lazy { itemView.findViewById(R.id.item_main_rb) }
        val tv_title: TextView by lazy { itemView.findViewById(R.id.item_main_tv_title) }
        val tv_description: TextView by lazy { itemView.findViewById(R.id.item_main_tv_description) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}