package com.example.restapipractice.data.realm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

public class SchemaMigration implements RealmMigration {
    public static final int SCHEMA_VERSION = 0;

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

    }
}
