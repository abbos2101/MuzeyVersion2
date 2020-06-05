package abbos2101.muzey.ui.view

import abbos2101.muzey.R
import abbos2101.muzey.adapter.view.CustomSwipeAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view.*


class ViewActivity : AppCompatActivity() {
    private val list by lazy { intent.getStringArrayListExtra("list") }
    private val adapter: CustomSwipeAdapter by lazy { CustomSwipeAdapter(this, list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        imgpaper.setAdapter(adapter)
        view_img_back.setOnClickListener { finish() }
    }
}