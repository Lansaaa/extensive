package com.lansa.extensive.extensive.extensions

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns


fun ContentResolver.getFileName(fileUri: Uri): String {
    var name = ""
    val returnCursor = query(fileUri, null, null, null, null)
    if (returnCursor != null) {
        val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor.moveToFirst()
        name = returnCursor.getString(nameIndex)
        returnCursor.close()
    }
    return name
}