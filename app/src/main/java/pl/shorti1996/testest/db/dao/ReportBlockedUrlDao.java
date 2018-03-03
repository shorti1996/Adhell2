package pl.shorti1996.testest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import pl.shorti1996.testest.db.DateConverter;
import pl.shorti1996.testest.db.entity.ReportBlockedUrl;

import java.util.Date;
import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface ReportBlockedUrlDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ReportBlockedUrl reportBlockedUrl);

    @Insert
    void insertAll(List<ReportBlockedUrl> reportBlockedUrls);

    @Query("SELECT * FROM ReportBlockedUrl WHERE blockDate BETWEEN :startDate AND :endDate ORDER BY _id DESC")
    LiveData<List<ReportBlockedUrl>> getReportBlockUrlBetween(Date startDate, Date endDate);

    @Query("DELETE FROM ReportBlockedUrl WHERE blockDate < :blockDate")
    void deleteBefore(Date blockDate);

    @Query("SELECT * FROM ReportBlockedUrl ORDER BY blockDate DESC LIMIT 1")
    ReportBlockedUrl getLastBlockedDomain();

}