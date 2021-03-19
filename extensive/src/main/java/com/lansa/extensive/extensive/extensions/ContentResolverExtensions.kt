package com.lansa.extensive.extensive.extensions

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns


fun ContentResolver.getFileName(fileUri: Uri): String {
    val returnCursor = query(fileUri, null, null, null, null)
    return if (returnCursor != null) {
        val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor.moveToFirst()
        val toReturn = returnCursor.getString(nameIndex)
        returnCursor.close()
        toReturn
    } else {
        ""
    }
}