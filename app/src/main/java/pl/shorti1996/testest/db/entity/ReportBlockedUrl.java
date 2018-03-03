package pl.shorti1996.testest.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import pl.shorti1996.testest.db.DateConverter;

import java.util.Date;

@Entity(tableName = "ReportBlockedUrl")
@TypeConverters(DateConverter.class)
public class ReportBlockedUrl {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public long id;
    public String url;
    public String packageName;
    public Date blockDate;

    public ReportBlockedUrl() {
    }

    @Ignore
    public ReportBlockedUrl(String url, String packageName, Date blockDate) {
        this.url = url;
        this.packageName = packageName;
        this.blockDate = blockDate;
    }

    @Override
    public String toString() {
        return "ReportBlockedUrl{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", packageName='" + packageName + '\'' +
                ", blockDate=" + blockDate +
                '}';
    }
}
