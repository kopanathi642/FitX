package com.example.fitx // Make sure this package name is correct

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat // <-- ADD THIS IMPORT
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
// ... add other imports if needed

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is the new, correct way to go edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.dashboard)

        // Find the chart and set it up
        val timingChart: LineChart = findViewById(R.id.timingChart)
        setupChart(timingChart)

        // Setup all four progress cards
        setupProgressCards()
    }

    private fun setupChart(chart: LineChart) {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 4f))
        entries.add(Entry(1f, 8f))
        entries.add(Entry(2f, 6f))
        entries.add(Entry(3f, 2f))
        entries.add(Entry(4f, 7f))
        entries.add(Entry(5f, 5f))

        val dataSet = LineDataSet(entries, "Workout Duration")
        dataSet.color = Color.GREEN
        dataSet.valueTextColor = Color.WHITE
        dataSet.setDrawCircles(false)
        dataSet.setDrawValues(false)
        dataSet.lineWidth = 3f
        dataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        dataSet.setDrawFilled(true)
        dataSet.fillColor = Color.GREEN
        dataSet.fillAlpha = 80

        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.description.isEnabled = false
        chart.legend.isEnabled = false
        chart.xAxis.isEnabled = false
        chart.axisLeft.textColor = Color.WHITE
        chart.axisRight.isEnabled = false
        chart.invalidate() // refresh
    }

    private fun setupProgressCards() {
        // Correctly reference the card IDs from your activity_home.xml
        val stepsCard = findViewById<View>(R.id.steps_card)
        val caloriesCard = findViewById<View>(R.id.calories_card)
        val waterCard = findViewById<View>(R.id.water_card)
        val minutesCard = findViewById<View>(R.id.minutes_card)

        // Card 1: Steps
        updateProgressCard(
            cardView = stepsCard,
            iconRes = R.drawable.ic_steps, // We will create this icon
            valueText = "8,500 / 10,000",
            labelText = "Steps",
            percentage = 85,
            progressDrawableRes = R.drawable.circular_progress_bar_green
        )

        // Card 2: Calories Burned
        updateProgressCard(
            cardView = caloriesCard,
            iconRes = R.drawable.ic_flame, // We will create this icon
            valueText = "500 / 600 cal",
            labelText = "Calories Burned",
            percentage = 83,
            progressDrawableRes = R.drawable.circular_progress_bar_orange
        )

        // Card 3: Water Intake
        updateProgressCard(
            cardView = waterCard,
            iconRes = R.drawable.ic_water_drop, // We will create this icon
            valueText = "2.5 / 4 L",
            labelText = "Water Intake",
            percentage = 62,
            progressDrawableRes = R.drawable.circular_progress_bar_blue
        )

        // Card 4: Active Minutes
        updateProgressCard(
            cardView = minutesCard,
            iconRes = R.drawable.ic_runner, // We will create this icon
            valueText = "45 / 60 min",
            labelText = "Active Minutes",
            percentage = 75,
            progressDrawableRes = R.drawable.circular_progress_bar_green
        )
    }

    private fun updateProgressCard(cardView: View, iconRes: Int, valueText: String, labelText: String, percentage: Int, progressDrawableRes: Int) {
        val icon = cardView.findViewById<ImageView>(R.id.progress_icon)
        val value = cardView.findViewById<TextView>(R.id.progress_value)
        val label = cardView.findViewById<TextView>(R.id.progress_label)
        val percentageText = cardView.findViewById<TextView>(R.id.progress_percentage)
        val progressBar = cardView.findViewById<ProgressBar>(R.id.progress_bar)

        icon.setImageResource(iconRes)
        value.text = valueText
        label.text = labelText
        percentageText.text = "$percentage%"
        progressBar.progress = percentage
        progressBar.progressDrawable = ContextCompat.getDrawable(this, progressDrawableRes)
    }
}

