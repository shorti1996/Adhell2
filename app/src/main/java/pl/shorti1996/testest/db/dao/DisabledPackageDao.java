package pl.shorti1996.testest.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import pl.shorti1996.testest.db.DateConverter;
import pl.shorti1996.testest.db.entity.DisabledPackage;

import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface DisabledPackageDao {

    @Query("SELECT * FROM DisabledPackage")
    List<DisabledPackage> getAll();

    @Insert
    void insertAll(List<DisabledPackage> disabledPackages);
}
