package com.example.assignment2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Required class for Hilt to generate needed code for dependency injection
@HiltAndroidApp
class MyApplication : Application()