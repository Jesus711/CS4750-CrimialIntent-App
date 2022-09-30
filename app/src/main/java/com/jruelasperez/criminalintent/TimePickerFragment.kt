package com.jruelasperez.criminalintent

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

private const val ARG_TIME = "date"

class TimePickerFragment : DialogFragment() {

        interface Callbacks {
            fun onTimeSelected(time: String)
        }

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val timeListener = TimePickerDialog.OnTimeSetListener {
                    _: TimePicker, hour: Int, minute: Int ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)

                val resultTime = calendar.time.toString().subSequence(11, 16) as String
                Log.d(ARG_TIME, resultTime)

                targetFragment?.let {
                        fragment ->
                    (fragment as Callbacks).onTimeSelected(resultTime)
                }
            }
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minutes = calendar.get(Calendar.MINUTE)
            val time = arguments?.getSerializable(ARG_TIME) as String

            return TimePickerDialog(
                requireContext(),
                timeListener,
                hour,
                minutes,
                false
            )
        }

        companion object {
            fun newInstance(time: String): TimePickerFragment {
                val args = Bundle().apply {
                    putSerializable(ARG_TIME, time)
                }
                return TimePickerFragment().apply {
                    arguments = args
                }
            }
        }
    }