package abbos2101.muzey.adapter.main

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.common.lang_id
import abbos2101.muzey.ui.main.MainPresenter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val presenter: MainPresenter
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder : RecyclerView.ViewHolder {
        var img: ImageView? = null
        var ll: LinearLayout? = null
        var rb: RatingBar? = null
        var tv_title: TextView? = null
        var tv_description: TextView? = null
        var tv_countview: TextView? = null

        constructor(itemView: View) : super(itemView) {
            img = itemView.findViewById(R.id.item_main_img)
            ll = itemView.findViewById(R.id.item_main_ll)
            rb = itemView.findViewById(R.id.item_main_rb)
            tv_title = itemView.findViewById(R.id.item_main_tv_title)
            tv_description = itemView.findViewById(R.id.item_main_tv_description)
            tv_countview = itemView.findViewById(R.id.item_main_tv_countview)
        }
    }

    private var list: ArrayList<MainModel> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mainHolder = MainHolder(presenter, list)
        mainHolder.bindHolder(holder, position)
    }

    fun setNewList(newList: ArrayList<MainModel>) {
        this.list = newList
        this.notifyDataSetChanged()
    }

    fun setLanguage(langId: Int) {
        lang_id = langId
        this.notifyDataSetChanged()
    }
}