package wjayteo.mdp.android.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_settings_simulation.*
import wjayteo.mdp.android.App.Companion.DEFAULT_DELAY
import wjayteo.mdp.android.App.Companion.COVERAGE_LIMIT
import wjayteo.mdp.android.App.Companion.sharedPreferences
import wjayteo.mdp.android.App.Companion.SIM_DELAY
import wjayteo.mdp.android.App.Companion.SIM_MODE
import wjayteo.mdp.android.R
import wjayteo.mdp.android.databinding.FragmentSettingsSimulationBinding
import wjayteo.mdp.android.utils.ActivityUtil

class SettingsFragmentSimulation : Fragment() {

    private var binding: FragmentSettingsSimulationBinding? = null
    private lateinit var activityUtil: ActivityUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsSimulationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityUtil = (activity as SettingsActivity).activityUtil

        simulationSwitch.isChecked = SIM_MODE
        simulationSwitch.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean(getString(R.string.app_pref_simulation_mode), isChecked).apply()
            SIM_MODE = isChecked
            simulationSpeedSeekBar.isEnabled = isChecked
            coverageLimitSeekBar.isEnabled = isChecked
            SIM_DELAY = if (SIM_MODE) 1000L / (sharedPreferences.getInt(getString(R.string.app_pref_simulation_speed), 3) + 1) else DEFAULT_DELAY
            COVERAGE_LIMIT = if (SIM_MODE) sharedPreferences.getInt(getString(R.string.app_pref_simulation_coverage), 100) else 100
            simulationSpeedSeekBar.progress = (1000.0 / SIM_DELAY).toInt() - 1
            coverageLimitSeekBar.progress = COVERAGE_LIMIT
        }

        val progressActual: Int = (1000.0 / SIM_DELAY).toInt()
        simulationSpeedSeekBar.isEnabled = SIM_MODE
        simulationSpeedLabel.text = getString(R.string.simulation_speed_placeholder_aps, progressActual)
        simulationSpeedSeekBar.progress = progressActual - 1
        simulationSpeedSeekBar.incrementProgressBy(1)
        simulationSpeedSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            var progress = 0

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                this.progress = progress
                SIM_DELAY = (1000 / (progress + 1)).toLong()
                simulationSpeedLabel.text = getString(R.string.simulation_speed_placeholder_aps, progress + 1)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                sharedPreferences.edit().putInt(getString(R.string.app_pref_simulation_speed), this.progress).apply()
            }
        })

        coverageLimitSeekBar.isEnabled = SIM_MODE
        coverageLimitLabel.text = getString(R.string.simulation_coverage_placeholder, COVERAGE_LIMIT)
        coverageLimitSeekBar.progress = COVERAGE_LIMIT
        coverageLimitSeekBar.incrementProgressBy(5)
        coverageLimitSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var progressRounded = progress / 5
                progressRounded *= 5
                COVERAGE_LIMIT = progressRounded
                coverageLimitLabel.text = getString(R.string.simulation_coverage_placeholder, COVERAGE_LIMIT)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                sharedPreferences.edit().putInt(getString(R.string.app_pref_simulation_coverage), COVERAGE_LIMIT).apply()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        activityUtil.setTitle(getString(R.string.simulation))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
