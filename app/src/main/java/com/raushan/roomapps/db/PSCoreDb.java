package com.raushan.roomapps.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.raushan.roomapps.db.common.Converters;
import com.raushan.roomapps.viewobject.AboutUs;
import com.raushan.roomapps.viewobject.Blog;
import com.raushan.roomapps.viewobject.ChatHistory;
import com.raushan.roomapps.viewobject.ChatHistoryMap;
import com.raushan.roomapps.viewobject.City;
import com.raushan.roomapps.viewobject.CityMap;
import com.raushan.roomapps.viewobject.DeletedObject;
import com.raushan.roomapps.viewobject.Image;
import com.raushan.roomapps.viewobject.Item;
import com.raushan.roomapps.viewobject.ItemCategory;
import com.raushan.roomapps.viewobject.ItemCollection;
import com.raushan.roomapps.viewobject.ItemCollectionHeader;
import com.raushan.roomapps.viewobject.ItemCondition;
import com.raushan.roomapps.viewobject.ItemCurrency;
import com.raushan.roomapps.viewobject.ItemDealOption;
import com.raushan.roomapps.viewobject.ItemFavourite;
import com.raushan.roomapps.viewobject.ItemFromFollower;
import com.raushan.roomapps.viewobject.ItemHistory;
import com.raushan.roomapps.viewobject.ItemLocation;
import com.raushan.roomapps.viewobject.ItemMap;
import com.raushan.roomapps.viewobject.ItemPriceType;
import com.raushan.roomapps.viewobject.ItemSpecs;
import com.raushan.roomapps.viewobject.ItemSubCategory;
import com.raushan.roomapps.viewobject.ItemType;
import com.raushan.roomapps.viewobject.Noti;
import com.raushan.roomapps.viewobject.PSAppInfo;
import com.raushan.roomapps.viewobject.PSAppSetting;
import com.raushan.roomapps.viewobject.PSAppVersion;
import com.raushan.roomapps.viewobject.PSCount;
import com.raushan.roomapps.viewobject.Rating;
import com.raushan.roomapps.viewobject.User;
import com.raushan.roomapps.viewobject.UserLogin;
import com.raushan.roomapps.viewobject.UserMap;
import com.raushan.roomapps.viewobject.messageHolder.Message;


/**
 * Created by Panacea-Soft on 11/20/17.
 * Contact Email : teamps.is.cool@gmail.com
 */

@Database(entities = {
        Image.class,
        User.class,
        UserLogin.class,
        AboutUs.class,
        ItemFavourite.class,
        Noti.class,
        ItemHistory.class,
        Blog.class,
        Rating.class,
        PSAppInfo.class,
        PSAppVersion.class,
        DeletedObject.class,
        City.class,
        CityMap.class,
        Item.class,
        ItemMap.class,
        ItemCategory.class,
        ItemCollectionHeader.class,
        ItemCollection.class,
        ItemSubCategory.class,
        ItemSpecs.class,
        ItemCurrency.class,
        ItemPriceType.class,
        ItemType.class,
        ItemLocation.class,
        ItemDealOption.class,
        ItemCondition.class,
        ItemFromFollower.class,
        Message.class,
        ChatHistory.class,
        ChatHistoryMap.class,
        PSAppSetting.class,
        UserMap.class,
        PSCount.class


}, version = 4, exportSchema = false)
// app version 1.7 = db version 4
// app version 1.6 = db version 4
// app version 1.5 = db version 4
// app version 1.4 = db version 3
// app version 1.3 = db version 3
// app version 1.2 = db version 2
// app version 1.0 = db version 1


@TypeConverters({Converters.class})

public abstract class PSCoreDb extends RoomDatabase {

    abstract public UserDao userDao();

    abstract public UserMapDao userMapDao();

    abstract public HistoryDao historyDao();

    abstract public SpecsDao specsDao();

    abstract public AboutUsDao aboutUsDao();

    abstract public ImageDao imageDao();

    abstract public ItemDealOptionDao itemDealOptionDao();

    abstract public ItemConditionDao itemConditionDao();

    abstract public ItemLocationDao itemLocationDao();

    abstract public ItemCurrencyDao itemCurrencyDao();

    abstract public ItemPriceTypeDao itemPriceTypeDao();

    abstract public ItemTypeDao itemTypeDao();

    abstract public RatingDao ratingDao();

    abstract public NotificationDao notificationDao();

    abstract public BlogDao blogDao();

    abstract public PSAppInfoDao psAppInfoDao();

    abstract public PSAppVersionDao psAppVersionDao();

    abstract public DeletedObjectDao deletedObjectDao();

    abstract public CityDao cityDao();

    abstract public CityMapDao cityMapDao();

    abstract public ItemDao itemDao();

    abstract public ItemMapDao itemMapDao();

    abstract public ItemCategoryDao itemCategoryDao();

    abstract public ItemCollectionHeaderDao itemCollectionHeaderDao();

    abstract public ItemSubCategoryDao itemSubCategoryDao();

    abstract public ChatHistoryDao chatHistoryDao();

    abstract public MessageDao messageDao();

    abstract public PSCountDao psCountDao();


//    /**
//     * Migrate from:
//     * version 1 - using Room
//     * to
//     * version 2 - using Room where the {@link } has an extra field: addedDateStr
//     */
//    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE news "
//                    + " ADD COLUMN addedDateStr INTEGER NOT NULL DEFAULT 0");
//        }
//    };

    /* More migration write here */
}