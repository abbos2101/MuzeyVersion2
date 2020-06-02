package abbos2101.muzey.adapter.main

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.common.getDrawableFromAssets
import abbos2101.muzey.common.getRating
import abbos2101.muzey.common.lang_id
import abbos2101.muzey.ui.main.MainPresenter
import android.view.animation.AnimationUtils

class MainHolder(
    private val presenter: MainPresenter,
    private val list: ArrayList<MainModel>
) {

    fun bindHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val model = list[position]
        val rating = getRating(model.count_like, model.count_dislike)
        val drawableImg = getDrawableFromAssets(presenter.ctx, "${model.item_image}")

        holder.img?.setBackgroundDrawable(drawableImg)
        holder.rb?.rating = rating
        holder.ll?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))
        holder.ll?.setOnClickListener { presenter.itemClick(model, position) }
        holder.tv_countview?.setText("${model.count_view}")

        when (lang_id) {
            1 -> {
                holder.tv_title?.setText("${model.uz_title}")
                holder.tv_description?.setText("${model.uz_description}")
            }
            2 -> {
                holder.tv_title?.setText("${model.ru_title}")
                holder.tv_description?.setText("${model.ru_description}")
            }
            3 -> {
                holder.tv_title?.setText("${model.en_title}")
                holder.tv_description?.setText("${model.en_description}")
            }
        }
    }
}