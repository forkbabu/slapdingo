package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: SchemaManager */
final /* synthetic */ class SchemaManager$$Lambda$2 implements SchemaManager.Migration {
    private static final SchemaManager$$Lambda$2 instance = new SchemaManager$$Lambda$2();

    private SchemaManager$$Lambda$2() {
    }

    public static SchemaManager.Migration lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$1(sQLiteDatabase);
    }
}
