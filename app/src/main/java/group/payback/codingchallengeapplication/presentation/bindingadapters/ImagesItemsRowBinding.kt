package group.payback.codingchallengeapplication.presentation.bindingadapters

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import group.payback.codingchallengeapplication.R

class ImagesItemsRowBinding {
    companion object {

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
                Log.d("imgerror", imageUrl.toString())
            }
        }

        @BindingAdapter("applyIntToStringText")
        @JvmStatic
        fun applyIntToStringText(view: TextView, area: Double) {
            view.text = area.toString()
        }
    }
}