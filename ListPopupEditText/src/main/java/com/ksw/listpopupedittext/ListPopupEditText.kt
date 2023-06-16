package com.ksw.listpopupedittext

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.ListPopupWindow
import androidx.core.content.ContextCompat

public class ListPopupEditTextKotlin (context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    private val popupWindow: ListPopupWindow = ListPopupWindow(context)
    private var arrowDownDrawable: Drawable? = null
    private var arrowLeftDrawable: Drawable? = null
    private val listValue:ArrayList<String>? = null
    private val adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1)
    private val DRAWABLE_LEFT = 0;
    private val DRAWABLE_TOP = 1;
    private val DRAWABLE_RIGHT = 2;
    private val DRAWABLE_BOTTOM = 3;

    init {
        popupWindow.setAdapter(adapter)
        popupWindow.anchorView = this
        popupWindow.verticalOffset = height; // 与EditText下边缘对齐
        popupWindow.setDropDownGravity(Gravity.BOTTOM);  // 距离底部
        popupWindow.setOnItemClickListener { _, _, position, _ ->
            setText(adapter.getItem(position))
            setCompoundDrawablesWithIntrinsicBounds(null, null, arrowLeftDrawable, null)
            popupWindow.dismiss()
        }

        popupWindow.setOnDismissListener {
            setCompoundDrawablesWithIntrinsicBounds(null, null, arrowLeftDrawable, null)
        }

        arrowDownDrawable = ContextCompat.getDrawable(context, R.drawable.arrow_to_down)
        arrowLeftDrawable = ContextCompat.getDrawable(context, R.drawable.arrow_to_left)

        setCompoundDrawablesWithIntrinsicBounds(null, null, arrowLeftDrawable, null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_UP && adapter.count > 0) {
            if (event.x >= (width - compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                // your action here
                if(popupWindow.isShowing){
                    popupWindow.dismiss()
                    setCompoundDrawablesWithIntrinsicBounds(null, null, arrowLeftDrawable, null)
                }
                else{
                    setCompoundDrawablesWithIntrinsicBounds(null, null, arrowDownDrawable, null)
                    popupWindow.show()

                }
                return false
            }
        }
        setCompoundDrawablesWithIntrinsicBounds(null, null, arrowLeftDrawable, null)
        return super.onTouchEvent(event)
    }

    fun setItems(items: List<String>) {
        adapter.clear()
        adapter.addAll(items)
    }

}