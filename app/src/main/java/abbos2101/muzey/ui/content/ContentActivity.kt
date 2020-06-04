package abbos2101.muzey.ui.content

import abbos.uzeu.database.DatabaseProvider
import abbos2101.Stroitelstvo.database.model.MainModel
import abbos2101.muzey.R
import abbos2101.muzey.common.common_model
import abbos2101.muzey.common.common_position
import abbos2101.muzey.common.lang_id
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
        setData()
        setEvent()
    }

    private fun init() {
        DatabaseProvider.instance(this).databaseDao().setUpCountView(common_model?._id!!,4)
        Toast.makeText(this, "ok:)", Toast.LENGTH_SHORT).show()
    }

    private fun setEvent() {
        content_img_back.setOnClickListener { finish() }
        content_img_uz.setOnClickListener { }
        content_img_ru.setOnClickListener { }
        content_img_en.setOnClickListener { }
    }

    private fun setData() {
        when (lang_id) {
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
        }
    }
}