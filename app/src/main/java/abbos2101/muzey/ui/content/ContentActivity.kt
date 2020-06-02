package abbos2101.muzey.ui.content

import abbos2101.muzey.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
        setEvent()
    }

    private fun init() {

    }

    private fun setEvent() {
        content_img_back.setOnClickListener { finish() }
        content_img_uz.setOnClickListener {  }
        content_img_ru.setOnClickListener {  }
        content_img_en.setOnClickListener {  }
    }
}