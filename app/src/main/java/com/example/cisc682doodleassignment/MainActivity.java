package com.example.cisc682doodleassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodleView = findViewById(R.id.doodleView);

        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(v -> doodleView.clearCanvas());

        Button colorButton = findViewById(R.id.colorButton);
        colorButton.setOnClickListener(v -> showColorMenu(v));

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

    // Show a PopupMenu with color options
    private void showColorMenu(android.view.View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenu().add(0, 1, 0, "Red");
        popupMenu.getMenu().add(0, 2, 0, "Green");
        popupMenu.getMenu().add(0, 3, 0, "Blue");
        popupMenu.getMenu().add(0, 4, 0, "Black");
        popupMenu.getMenu().add(0, 5, 0, "Purple");
        popupMenu.getMenu().add(0, 6, 0, "Yellow");
        popupMenu.getMenu().add(0, 7, 0, "Gray");

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case 1:
                        doodleView.setColor(Color.RED);
                        break;
                    case 2:
                        doodleView.setColor(Color.GREEN);
                        break;
                    case 3:
                        doodleView.setColor(Color.BLUE);
                        break;
                    case 4:
                        doodleView.setColor(Color.BLACK);
                        break;
                    case 5:
                        doodleView.setColor(Color.MAGENTA);
                        break;
                    case 6:
                        doodleView.setColor(Color.YELLOW);
                        break;
                    case 7:
                        doodleView.setColor(Color.GRAY);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

        popupMenu.show();
    }
}
