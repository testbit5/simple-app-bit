package com.example.restapipractice.presentation.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
//VM=view model
public class CategoryVM implements Parcelable {

    public static final Creator<CategoryVM> CREATOR = new Creator<CategoryVM>(){
        @Override
        public CategoryVM createFromParcel(Parcel source) {
            return new CategoryVM(source);
        }

        @Override
        public CategoryVM[] newArray(int size) {
            return new CategoryVM[size];
        }
    };



    private String mId;
    private String mName;
    private String mDescription;
    private String mPublishedAt;
    private String mImageUrl;

    public CategoryVM() {
    }

    protected CategoryVM(Parcel source){
        mId = source.readString();
        mName = source.readString();
        mDescription = source.readString();
        mPublishedAt = source.readString();
        mImageUrl = source.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mPublishedAt);
        dest.writeString(mImageUrl);

    }

    @Override
    public int describeContents() {
        return 0;
    }

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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
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
