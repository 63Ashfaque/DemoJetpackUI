package com.ashfaque.demojetpackui.core

import android.content.Context
import android.widget.Toast


fun showToast(context:Context,message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun isValidEmail(email: String): Boolean {
    if(email.isEmpty())
    {
        return false
    }
    val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$")
    return email.matches(emailRegex)
}

fun isValidMobile(mobile:String):Boolean
{
    if(mobile.isEmpty())
    { return false }
    return mobile.length >= 10
}

fun isValidLength(mString:String,mLength:Int):Boolean
{
    if(mString.isEmpty())
    {
        return false
    }
    return mString.length==mLength
}
