package abbos2101.muzey.adapter.gallery

import abbos2101.muzey.R
import abbos2101.muzey.adapter.content_gallery.ContentGalleryAdapter
import abbos2101.muzey.ui.content.ContentPresenter
import abbos2101.muzey.ui.gallery.GalleryPresenter
import android.view.animation.AnimationUtils
import com.squareup.picasso.Picasso

class GalleryHolder(
    private val presenter: GalleryPresenter,
    private val list: ArrayList<String>
) {
    fun bindHolder(holder: GalleryAdapter.ViewHolder, position: Int) {
        val model = list[position]
        Picasso
            .get()
            .load("file:///android_asset/${model}")
            .into(holder.img)
        holder.img?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))
    }
}