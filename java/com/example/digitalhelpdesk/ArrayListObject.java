package com.example.digitalhelpdesk;

public class ArrayListObject {
    private String mString;
    private int mImageId;
    private int mMediaPlayerId;

    public ArrayListObject(String string, int imageId) {
        mString = string;
        mImageId = imageId;
    }
    public ArrayListObject(String string, int imageId, int mediaPlayerId) {
        mString = string;
        mImageId = imageId;
        mMediaPlayerId = mediaPlayerId;
    }

    public String getString() {
        return mString;
    }

    public int getImgId() {
        return mImageId;
    }

    public int getMediaPlayerId() {
        return mMediaPlayerId;
    }
}
