package com.applex.snaplingo.LinkPreview;

public interface ResponseListener {
    void onData(MetaData metaData);

    void onError(Exception exc);
}
