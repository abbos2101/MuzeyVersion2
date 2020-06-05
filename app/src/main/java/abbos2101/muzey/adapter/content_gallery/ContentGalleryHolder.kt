package abbos2101.muzey.adapter.content_gallery

import abbos2101.muzey.R
import abbos2101.muzey.ui.content.ContentPresenter
import android.view.animation.AnimationUtils
import com.squareup.picasso.Picasso

class ContentGalleryHolder(
    private val presenter: ContentPresenter,
    private val list: ArrayList<String>
) {
    fun bindHolder(holder: ContentGalleryAdapter.ViewHolder, position: Int) {
        val model = list[position]
        Picasso
            .get()
            .load("file:///android_asset/${model}")
            .into(holder.img)
        holder.img?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))
        holder.img?.setOnClickListener { presenter.itemGalleryClick() }
    }
}