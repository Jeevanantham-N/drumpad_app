package com.jeeva.drumpad;

import android.graphics.drawable.Drawable;

public class DrumPadData {
    private Drawable drawable;
    private String title;

    public DrumPadData(Drawable drawable, String title) {
        this.drawable = drawable;
        this.title = title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
