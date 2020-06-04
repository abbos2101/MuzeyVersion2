package abbos2101.muzey.adapter.content

import abbos2101.muzey.R
import abbos2101.muzey.common.getDrawableFromAssets
import abbos2101.muzey.common.lang_id
import abbos2101.muzey.database.model.ContentModel
import abbos2101.muzey.ui.content.ContentPresenter
import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.squareup.picasso.Picasso

class ContentHolder(
    private val presenter: ContentPresenter,
    private val list: ArrayList<ContentModel>
) {
    fun bindHolder(holder: ContentAdapter.ViewHolder, position: Int) {
        val model = list[position]
        holder.tv?.setVisibility(View.GONE)
        holder.img?.setVisibility(View.GONE)

        if (model.img_assets_url != null) {
            holder.img?.setVisibility(View.VISIBLE)
            val drawableImg = getDrawableFromAssets(presenter.ctx, "${model.img_assets_url}")
            holder.img?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))
            holder.img?.setBackgroundDrawable(drawableImg)
        } else if (model.img_assets_url == null) {
            holder.tv?.setVisibility(View.VISIBLE)
            if (lang_id == 1)
                holder.tv?.setText("${model.uz_tv_text}")
            else if (lang_id == 2)
                holder.tv?.setText("${model.ru_tv_text}")
            else if (lang_id == 3)
                holder.tv?.setText("${model.en_tv_text}")
        }
    }
}