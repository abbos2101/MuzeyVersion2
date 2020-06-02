package abbos2101.muzey.adapter

import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.ui.MainPresenter
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.animation.AnimationUtils
import java.io.InputStream

class MainHolder(
    private val presenter: MainPresenter,
    private val list: ArrayList<MainModel>
) {

    fun bindHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val model = list[position]
        val rating = getRating(model.count_like, model.count_dislike)
        val drawableImg = getDrawableFromAssets(presenter.ctx, "${model.item_image}")

        holder.tv_title?.setText("${model.title}")
        holder.tv_description?.setText("${model.description}")
        holder.tv_countview?.setText("${model.count_view}")
        holder.img?.setBackgroundDrawable(drawableImg)
        holder.rb?.rating = rating
        holder.ll?.startAnimation(AnimationUtils.loadAnimation(presenter.ctx, R.anim.alpha))


        //holder.ll?.setOnClickListener { presenter. }
    }

    private fun getDrawableFromAssets(context: Context, path: String?): Drawable? {
        var stream: InputStream? = null
        try {
            stream = context.getAssets().open(path!!)
            return Drawable.createFromStream(stream, null)
        } catch (ignored: Exception) {
        } finally {
            try {
                if (stream != null) {
                    stream.close()
                }
            } catch (ignored: Exception) {
            }
        }
        return null
    }

    private fun getRating(count_like: Int, count_dislike: Int): Float {
        val summ = count_like + count_dislike
        if (summ != 0)
            return (5 * count_like / summ).toFloat()
        return 0F
    }
}