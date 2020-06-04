package abbos2101.muzey.adapter.content_gallery

import abbos2101.muzey.R
import abbos2101.muzey.common.getDrawableFromAssets
import abbos2101.muzey.common.lang_id
import abbos2101.muzey.database.model.ContentModel
import abbos2101.muzey.ui.content.ContentPresenter
import android.view.View
import android.view.animation.AnimationUtils

class ContentGalleryHolder(
    private val presenter: ContentPresenter,
    private val list: ArrayList<String>
) {
    fun bindHolder(holder: ContentGalleryAdapter.ViewHolder, position: Int) {
        val model = list[position]
            val drawableImg = getDrawableFromAssets(presenter.ctx, "${model}")
            holder.img?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))
            holder.img?.setBackgroundDrawable(drawableImg)
    }
}