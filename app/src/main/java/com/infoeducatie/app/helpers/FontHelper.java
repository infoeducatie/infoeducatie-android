package com.infoeducatie.app.helpers;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Browsing on 7/7/2015.
 */
public class FontHelper {
    /* this class will take care of fonts */
    public static Typeface SHADOWS_INTO_LIGHT;
    public static Typeface ROBOTO_REGULAR;
    public static Typeface ROBOTO_BOLD;
    public static Typeface ROBOTO_CONDENSED;
    public static Typeface ROBOTO_THIN;
    public static Typeface LATO_BOLD;
    public static Typeface LATO_LIGHT;
    public static Typeface LATO_REGULAR;


    public static void load(Context context) {
        SHADOWS_INTO_LIGHT = Typeface.createFromAsset(context.getAssets(), "ShadowsIntoLight.ttf");
        ROBOTO_REGULAR = Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        ROBOTO_CONDENSED = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
        ROBOTO_THIN = Typeface.createFromAsset(context.getAssets(), "Roboto-Thin.ttf");
        ROBOTO_BOLD = Typeface.createFromAsset(context.getAssets(), "Roboto-Bold.ttf");
        LATO_BOLD = Typeface.createFromAsset(context.getAssets(), "lato-bold-webfont.ttf");
        LATO_LIGHT = Typeface.createFromAsset(context.getAssets(), "lato-light-webfont.ttf");
        LATO_REGULAR = Typeface.createFromAsset(context.getAssets(), "lato-regular-webfont.ttf");
    }
}
