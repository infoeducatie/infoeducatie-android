package com.infoeducatie.app.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;

import com.infoeducatie.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewDialogFragment extends DialogFragment {

    private WebView mWebView;
    private String html;

    public WebViewDialogFragment setHtml(String html) {
        this.html = html;
        if (mWebView != null) {
            mWebView.loadData(html, "text/html", "UTF-8");
        }
        return this;
    }

    public WebViewDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_web_view_dialog, container, false);
        mWebView = (WebView) view.findViewById(R.id.fragment_web_view_dialog_web_view);
        if (html != null) {
            mWebView.loadData(html, "text/html", "UTF-8");
        }
        return view;
    }


}
