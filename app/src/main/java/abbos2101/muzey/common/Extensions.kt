package abbos2101.muzey.common

import android.content.Context
import android.graphics.drawable.Drawable
import java.io.InputStream

fun getDrawableFromAssets(context: Context, path: String?): Drawable? {
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