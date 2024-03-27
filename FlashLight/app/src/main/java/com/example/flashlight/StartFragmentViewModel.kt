package com.example.flashlight

import android.hardware.camera2.CameraManager
import android.widget.FrameLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartFragmentViewModel : ViewModel() {
    lateinit var fl: FrameLayout
    lateinit var cameraManager: CameraManager
    lateinit var cameraId: String
    var state: MutableLiveData<Boolean> = MutableLiveData(false)
}