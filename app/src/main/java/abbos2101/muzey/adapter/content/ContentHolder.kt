package abbos2101.muzey.adapter.content

import abbos2101.muzey.database.model.ContentModel
import android.view.View

class ContentHolder(
    private val list: ArrayList<ContentModel>
) {
    fun bindHolder(holder: ContentAdapter.ViewHolder, position: Int) {
        val model = list[position]
        if (model.img_assets_url.isNotEmpty()) {
            holder.tv?.setVisibility(View.GONE)
//            val drawableImg = getDrawableFromAssets(presenter.ctx, "${model.item_image}")
//            holder.img?.setBackgroundDrawable(drawableImg)
        } else if (model.tv_text.isNotEmpty()) {
            holder.img?.setVisibility(View.GONE)
            holder.tv?.setText("${model.tv_text}")
        }
    }
}