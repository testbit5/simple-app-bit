package com.example.restapipractice.data.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("description_eng")
    private String mDescriptionEng;
    @SerializedName("description_id")
    private String mDescriptionId;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mPublishedAt;
    @SerializedName("image_url")
    private String mImageUrl;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public String getDescriptionEng() {
        return mDescriptionEng;
    }

    public void setDescriptionEng(String descriptionEng) {
        mDescriptionEng = descriptionEng;
    }

    public String getDescriptionId() {
        return mDescriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        mDescriptionId = descriptionId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        mPublishedAt = publishedAt;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
