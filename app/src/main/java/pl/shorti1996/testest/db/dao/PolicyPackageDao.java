package pl.shorti1996.testest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import pl.shorti1996.testest.db.DateConverter;
import pl.shorti1996.testest.db.entity.PolicyPackage;

@Dao
@TypeConverters(DateConverter.class)
public interface PolicyPackageDao {

    @Query("SELECT * FROM PolicyPackage")
    LiveData<PolicyPackage> getAllLiveData();

    @Query("SELECT * FROM PolicyPackage WHERE id = :id")
    PolicyPackage getPolicyById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PolicyPackage policyPackage);
}
