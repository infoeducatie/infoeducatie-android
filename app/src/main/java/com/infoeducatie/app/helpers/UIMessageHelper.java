package com.infoeducatie.app.helpers;

import android.app.Activity;
import android.widget.Toast;

import com.infoeducatie.app.R;

/**
 * Created by Browsing on 7/11/2015.
 */
public class UIMessageHelper {
    public static void showNetworkErrorMessage(Activity activity) {
        if (activity == null) return;
        Toast.makeText(activity, activity.getString(R.string.msg_con_error), Toast.LENGTH_SHORT).show();
    }
}
