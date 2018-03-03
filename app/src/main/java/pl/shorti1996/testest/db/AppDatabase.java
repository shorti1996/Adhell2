package pl.shorti1996.testest.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import pl.shorti1996.testest.db.dao.AppInfoDao;
import pl.shorti1996.testest.db.dao.AppPermissionDao;
import pl.shorti1996.testest.db.dao.BlockUrlDao;
import pl.shorti1996.testest.db.dao.BlockUrlProviderDao;
import pl.shorti1996.testest.db.dao.DisabledPackageDao;
import pl.shorti1996.testest.db.dao.FirewallWhitelistedPackageDao;
import pl.shorti1996.testest.db.dao.PolicyPackageDao;
import pl.shorti1996.testest.db.dao.ReportBlockedUrlDao;
import pl.shorti1996.testest.db.dao.UserBlockUrlDao;
import pl.shorti1996.testest.db.dao.WhiteUrlDao;
import pl.shorti1996.testest.db.entity.AppInfo;
import pl.shorti1996.testest.db.entity.AppPermission;
import pl.shorti1996.testest.db.entity.BlockUrl;
import pl.shorti1996.testest.db.entity.BlockUrlProvider;
import pl.shorti1996.testest.db.entity.DisabledPackage;
import pl.shorti1996.testest.db.entity.FirewallWhitelistedPackage;
import pl.shorti1996.testest.db.entity.PolicyPackage;
import pl.shorti1996.testest.db.entity.ReportBlockedUrl;
import pl.shorti1996.testest.db.entity.UserBlockUrl;
import pl.shorti1996.testest.db.entity.WhiteUrl;
import pl.shorti1996.testest.db.migration.Migration_14_15;
import pl.shorti1996.testest.db.migration.Migration_15_16;
import pl.shorti1996.testest.db.migration.Migration_16_17;
import pl.shorti1996.testest.db.migration.Migration_17_18;
import pl.shorti1996.testest.db.migration.Migration_18_19;
import pl.shorti1996.testest.db.migration.Migration_19_20;
import pl.shorti1996.testest.db.migration.Migration_20_21;
import pl.shorti1996.testest.db.migration.Migration_21_22;

@Database(entities = {
        AppInfo.class,
        AppPermission.class,
        BlockUrl.class,
        BlockUrlProvider.class,
        DisabledPackage.class,
        FirewallWhitelistedPackage.class,
        PolicyPackage.class,
        ReportBlockedUrl.class,
        UserBlockUrl.class,
        WhiteUrl.class
}, version = 22)
public abstract class AppDatabase extends RoomDatabase {
    private static final Migration MIGRATION_14_15 = new Migration_14_15(14, 15);
    private static final Migration MIGRATION_15_16 = new Migration_15_16(15, 16);
    private static final Migration MIGRATION_16_17 = new Migration_16_17(16, 17);
    private static final Migration MIGRATION_17_18 = new Migration_17_18(17, 18);
    private static final Migration MIGRATION_18_19 = new Migration_18_19(18, 19);
    private static final Migration MIGRATION_19_20 = new Migration_19_20(19, 20);
    private static final Migration MIGRATION_20_21 = new Migration_20_21(20, 21);
    private static final Migration MIGRATION_21_22 = new Migration_21_22(21, 22);
    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "adhell-database")
                            .addMigrations(MIGRATION_14_15)
                            .addMigrations(MIGRATION_15_16)
                            .addMigrations(MIGRATION_16_17)
                            .addMigrations(MIGRATION_17_18)
                            .addMigrations(MIGRATION_18_19)
                            .addMigrations(MIGRATION_19_20)
                            .addMigrations(MIGRATION_20_21)
                            .addMigrations(MIGRATION_21_22)
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract BlockUrlDao blockUrlDao();

    public abstract BlockUrlProviderDao blockUrlProviderDao();

    public abstract ReportBlockedUrlDao reportBlockedUrlDao();

    public abstract AppInfoDao applicationInfoDao();

    public abstract WhiteUrlDao whiteUrlDao();

    public abstract UserBlockUrlDao userBlockUrlDao();

    public abstract PolicyPackageDao policyPackageDao();

    public abstract DisabledPackageDao disabledPackageDao();

    public abstract FirewallWhitelistedPackageDao firewallWhitelistedPackageDao();

    public abstract AppPermissionDao appPermissionDao();

}