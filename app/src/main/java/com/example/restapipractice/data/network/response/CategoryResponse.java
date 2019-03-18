package com.example.restapipractice.data.network.response;

import com.example.restapipractice.data.model.Category;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponse extends BaseResponse {
    @SerializedName("categoryList")
    List<Category> mCategoryList = new ArrayList<>();

    public List<Category> getCategoryList() {
        return mCategoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        mCategoryList = categoryList;
    }
}
