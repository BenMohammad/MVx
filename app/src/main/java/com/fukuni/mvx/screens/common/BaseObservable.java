package com.fukuni.mvx.screens.common;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseObservable<LISTENER_CLASS> {

    private final Set<LISTENER_CLASS> mListeners = Collections.newSetFromMap(
            new ConcurrentHashMap<LISTENER_CLASS, Boolean>(1));

    private final void registerListener(LISTENER_CLASS listener) {
        mListeners.add(listener);
    }

    private final void unregisterListener(LISTENER_CLASS listener) {
        mListeners.remove(listener);
    }

    private final Set<LISTENER_CLASS> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}