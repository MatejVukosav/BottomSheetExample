package com.example.vuki.bottomsheetexample;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vuki.bottomsheetexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnExpand.setOnClickListener(this);
        binding.btnCollapse.setOnClickListener(this);
        binding.btnHide.setOnClickListener(this);
        binding.btnDialog.setOnClickListener(this);



        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetMain.designBottomSheet);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    binding.bottomSheetMain.txtBottomSheet.setText("Collapse me!");
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    binding.bottomSheetMain.txtBottomSheet.setText("Expande me!");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_expand:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.btn_collapse:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.btn_hide:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.btn_dialog:
                new MyBottomSheetDialogFragment().show(getSupportFragmentManager(), "sample");
                break;

        }
    }
}
