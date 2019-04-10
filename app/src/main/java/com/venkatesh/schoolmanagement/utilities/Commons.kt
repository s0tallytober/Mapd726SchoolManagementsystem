package com.venkatesh.schoolmanagement.utilities

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import java.util.*


object Commons {
    //Showing alert dialog for validation messages , confirmation messgaes
    fun showAlertDialog(
        context: Context,
        title: String? = null,
        message: String,
        nofOptions: Int = 1,
        positiveButtonText: String = "Ok",
        negativeButtonText: String = "No",
        neutralButtonText: String = "Cancel",
        isCancelable: Boolean = true,
        dialogCallback: DialogCallback? = null
    ) {
        // Initialize a new instance of
        val builder = AlertDialog.Builder(context)

        // Set the alert dialog title
        builder.setTitle(title)

        // Display a message on alert dialog
        builder.setMessage(message)

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton(positiveButtonText) { dialog, which ->
            // Do something when user press the positive button
            dialogCallback?.positiveClick()
        }


        if (nofOptions == 2)
        // Display a negative button on alert dialog
            builder.setNegativeButton(negativeButtonText) { dialog, which ->
                dialogCallback?.negativeClick()
            }

        if (nofOptions == 3)
        // Display a neutral button on alert dialog
            builder.setNeutralButton(neutralButtonText) { _, _ ->
                dialogCallback?.neutralClick()
            }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        dialog.setCancelable(isCancelable)

        // Display the alert dialog on app interface
        dialog.show()

    }

    fun getCurrentDateTime(): String? {
        return java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)
    }

    fun getExtensionFromUri(context: Context, uri: Uri): String? {
        val contentResolver = context.contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri))
    }

    fun getRandomNumber(): Int {
        val min = 10
        val max = 100

        val r = Random()
        return r.nextInt(max - min + 1) + min
    }
}