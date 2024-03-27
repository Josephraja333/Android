package com.example.flashlight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import com.example.flashlight.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var viewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[StartFragmentViewModel::class.java]

        viewModel.fl = binding.fl
        viewModel.state.observe(viewLifecycleOwner) { newState ->
            if (newState == true) {
                try {
                    viewModel.cameraManager = requireContext().getSystemService(Context.CAMERA_SERVICE) as CameraManager
                    viewModel.cameraId = viewModel.cameraManager.cameraIdList[0]
                    viewModel.cameraManager.setTorchMode(viewModel.cameraId, true)
                    binding.fl.setBackgroundResource(R.drawable.on)
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }
            } else {
                try {
                    viewModel.cameraManager = requireContext().getSystemService(Context.CAMERA_SERVICE) as CameraManager
                    viewModel.cameraId = viewModel.cameraManager.cameraIdList[0]
                    viewModel.cameraManager.setTorchMode(viewModel.cameraId, false)
                    binding.fl.setBackgroundResource(R.drawable.off)
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }
            }
        }

        viewModel.fl.setOnClickListener {
            viewModel.state.value = !(viewModel.state.value ?: false)
        }

        return binding.root
    }
}


