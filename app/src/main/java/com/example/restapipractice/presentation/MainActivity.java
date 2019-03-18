package com.example.restapipractice.presentation;


import android.os.Bundle;
import android.util.TypedValue;

import com.example.restapipractice.ApplicationComponent;
import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;
import com.example.restapipractice.presentation.viewmodel.CategoryVM;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements MainActivityContract.View{

    private List<CategoryVM> mCategoryVMList = new ArrayList<>();
    @BindView(R.id.chip_group)
    ChipGroup mChipGroup;

    private MainActivityContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        retrieveCategory();
    }

    private void initPresenter(){
        mPresenter = new MainActivityPresenter(
                ApplicationComponent.provideCategory(),
                this
        );
    }

    private void retrieveCategory(){
        mPresenter.retrieveCategory();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.choose_cat_title);
    }

    @Override
    public void showChipCategory(List<CategoryVM> categoryVMList) {
        mCategoryVMList = categoryVMList;
        for(CategoryVM categoryVM : mCategoryVMList){
            addChipCategory(categoryVM.getName());
        }
    }

    @Override
    public void showFailedErrorMessage(String errorMessage) {

    }

    private void addChipCategory(String category){
        Chip chip = new Chip(this);
        setChipAttribute(chip);
        chip.setText(category);
        chip.setOnCheckedChangeListener((view, isChecked) ->{

        });
    mChipGroup.addView(chip);
    }

    private void setChipAttribute(Chip chip) {
        chip.setLayoutParams(new ChipGroup.LayoutParams(
                ChipGroup.LayoutParams.WRAP_CONTENT, ChipGroup.LayoutParams.WRAP_CONTENT));
        chip.setTextSize(
                TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.font_size_m));
        chip.setChipCornerRadius(getResources().getDimension(R.dimen.chip_radius));
        chip.setChipStrokeWidth(getResources().getDimension(R.dimen.chip_stroke));
        chip.setChipStrokeColor(getResources().getColorStateList(R.color.selector_chip_stroke));
        chip.setChipBackgroundColor(getResources().getColorStateList(R.color.selector_chip));
        chip.setTextColor(getResources().getColorStateList(R.color.selector_chip_text));
        chip.setCheckedIconEnabled(false);
        chip.setCheckedIcon(null);
        chip.setCheckable(true);
        chip.setClickable(true);
        chip.setFocusable(true);
    }

}
