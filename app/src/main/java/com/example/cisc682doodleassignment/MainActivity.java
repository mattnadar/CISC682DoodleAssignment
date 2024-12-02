package com.example.cisc682doodleassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodleView = findViewById(R.id.doodleView);

        // Clear Button
        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(v -> doodleView.clearCanvas());

        // Color Button
        Button colorButton = findViewById(R.id.colorButton);
        colorButton.setOnClickListener(v -> showColorPickerDialog());

        // Brush Size SeekBar
        SeekBar brushSizeSeekBar = findViewById(R.id.brushSizeSeekBar);
        brushSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                doodleView.setBrushSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Opacity SeekBar
        SeekBar opacitySeekBar = findViewById(R.id.opacitySeekBar);
        opacitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                doodleView.setOpacity(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private void showColorPickerDialog() {
        // Predefined color options
        String[] colors = {"Red", "Green", "Blue", "Black", "Yellow"};
        int[] colorValues = {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.YELLOW};

        // AlertDialog for color selection
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a Color");
        builder.setItems(colors, (dialog, which) -> {
            // Set the color based on selection
            doodleView.setColor(colorValues[which]);
        });
        builder.create().show();
    }
}
