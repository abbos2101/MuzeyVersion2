package abbos2101.muzey.adapter.main

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.common.*
import abbos2101.muzey.ui.main.MainPresenter
import android.view.animation.AnimationUtils
import com.squareup.picasso.Picasso

class MainHolder(
    private val presenter: MainPresenter,
    private val list: ArrayList<MainModel>
) {

    fun bindHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val model = list[position]
        Picasso
            .get()
            .load("file:///android_asset/${model.item_image}")
            .into(holder.img)

        holder.ll?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))
        holder.ll?.setOnClickListener { presenter.itemClick(model, position) }
        holder.tv_countview?.setText("${model.count_view}")

        when (lang_id) {
            lang_uz -> {
                holder.tv_title?.setText("${model.uz_title}")
                holder.tv_description?.setText("${model.uz_description}")
            }
            lang_ru -> {
                holder.tv_title?.setText("${model.ru_title}")
                holder.tv_description?.setText("${model.ru_description}")
            }
            lang_en -> {
                holder.tv_title?.setText("${model.en_title}")
                holder.tv_description?.setText("${model.en_description}")
            }
        }
    }
}