package com.fukuni.mvx.screens.common.messagedisplayer;

import android.content.Context;
import android.widget.Toast;

public class MessagesDisplayer {

    private final Context context;

    public MessagesDisplayer(Context context) {
        this.context = context;
    }

    public void showUSeCaseError() {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
    }
}
