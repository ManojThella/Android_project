package com.app.furnitureworld.custom

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText
import java.util.*

class CEditText : AppCompatEditText {
    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {
        init()
    }

    fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val txt = Objects.requireNonNull(text).toString()
                if (txt.length > 0 && (txt.substring(0).equals(" ", ignoreCase = true) ||
                                txt.substring(0).equals(".", ignoreCase = true) ||
                                txt.substring(0).equals("'", ignoreCase = true) ||
                                txt.substring(0).equals("_", ignoreCase = true) ||
                                txt.substring(0).equals("@", ignoreCase = true))) {
                    setText("")
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        /*        Drawable x = getResources().getDrawable(R.drawable.n_ic_cross_icon);
        x.setBounds(0, 0, x.getIntrinsicWidth(), x.getIntrinsicHeight());
        setCompoundDrawables(null, null, x, null);*/
    }

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
            // setCursorVisible(false);
            //  clearFocus();
        }
        return super.onKeyPreIme(keyCode, event)
    }

    fun setCursorAndFocusEnable(state: Boolean) {
        isCursorVisible = state
        // setFocusable(state);
    }
}