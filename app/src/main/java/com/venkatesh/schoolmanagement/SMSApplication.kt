package com.venkatesh.schoolmanagement

import android.app.Application
import com.google.firebase.FirebaseApp

class SMSApplication : Application() {

    private val TAG: String = SMSApplication::class.java.simpleName
    private var mInstance: SMSApplication? = null

    companion object {
        lateinit var smsApplication: SMSApplication
        fun getInstance() {
            smsApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        smsApplication = this
        FirebaseApp.initializeApp(applicationContext)
    }

    @Synchronized
    fun getInstance(): SMSApplication? {
        return mInstance
    }

}