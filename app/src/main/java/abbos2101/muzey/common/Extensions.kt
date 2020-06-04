package abbos2101.muzey.common

import android.content.Context
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import java.io.IOException
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

fun isAssetExists(context: Context, pathInAssetsDir: String): Boolean {
    val assetManager: AssetManager = context.getResources().getAssets()
    var inputStream: InputStream? = null
    try {
        inputStream = assetManager.open(pathInAssetsDir)
        if (inputStream != null) {
            return true
        }
    } catch (e: IOException) {
        e.printStackTrace()
        return false
    }
    return false
}