package com.example.restapipractice.presentation.mapper;

import com.example.restapipractice.data.model.Category;
import com.example.restapipractice.data.network.response.CategoryResponse;
import com.example.restapipractice.presentation.viewmodel.CategoryVM;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static List<CategoryVM> transform(CategoryResponse response){
        List<CategoryVM> categoryVMList = new ArrayList<>();
        List<Category> categoryList = response.getCategoryList();
        CategoryVM categoryVM;
        for( Category category:categoryList){
            categoryVM = new CategoryVM();
            categoryVM.setId(category.getId());
            categoryVM.setName(category.getName());
            categoryVM.setPublishedAt(category.getPublishedAt());
            categoryVM.setDescription(category.getDescriptionEng());
            categoryVM.setImageUrl(category.getImageUrl());
            categoryVMList.add(categoryVM);
        }
        return categoryVMList;
    }
}
