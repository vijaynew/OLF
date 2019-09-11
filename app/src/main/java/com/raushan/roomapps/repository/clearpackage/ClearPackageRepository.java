package com.raushan.roomapps.repository.clearpackage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.raushan.roomapps.AppExecutors;
import com.raushan.roomapps.api.PSApiService;
import com.raushan.roomapps.db.PSCoreDb;
import com.raushan.roomapps.repository.common.PSRepository;
import com.raushan.roomapps.utils.Utils;
import com.raushan.roomapps.viewobject.common.Resource;

import javax.inject.Inject;

public class ClearPackageRepository extends PSRepository {

    @Inject
    ClearPackageRepository(PSApiService psApiService, AppExecutors appExecutors, PSCoreDb db) {
        super(psApiService, appExecutors, db);

        Utils.psLog("Inside CityCategoryRepository");
    }

    public LiveData<Resource<Boolean>> clearAllTheData() {

        final MutableLiveData<Resource<Boolean>> statusLiveData = new MutableLiveData<>();

        appExecutors.networkIO().execute(() -> {

            try {
                db.beginTransaction();

                db.cityDao().deleteAll();
                db.itemDao().deleteAll();
                db.blogDao().deleteAll();
                db.deletedObjectDao().deleteAll();
                db.imageDao().deleteTable();
                db.notificationDao().deleteAllNotificationList();
                db.specsDao().deleteAll();
                db.psAppInfoDao().deleteAll();
                db.psAppVersionDao().deleteAll();
                db.ratingDao().deleteAll();
                db.setTransactionSuccessful();
            } catch (NullPointerException ne) {
                Utils.psErrorLog("Null Pointer Exception : ", ne);

                statusLiveData.postValue(Resource.error(ne.getMessage(), false));
            } catch (Exception e) {
                Utils.psErrorLog("Exception : ", e);

                statusLiveData.postValue(Resource.error(e.getMessage(), false));
            } finally {
                db.endTransaction();
            }

            statusLiveData.postValue(Resource.success(true));


        });

        return statusLiveData;
    }

}
