package com.raushan.roomapps.repository.appInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.raushan.roomapps.AppExecutors;
import com.raushan.roomapps.Config;
import com.raushan.roomapps.api.ApiResponse;
import com.raushan.roomapps.api.PSApiService;
import com.raushan.roomapps.db.PSCoreDb;
import com.raushan.roomapps.repository.common.PSRepository;
import com.raushan.roomapps.utils.Constants;
import com.raushan.roomapps.utils.Utils;
import com.raushan.roomapps.viewobject.DeletedObject;
import com.raushan.roomapps.viewobject.PSAppInfo;
import com.raushan.roomapps.viewobject.common.Resource;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Response;

public class AppInfoRepository extends PSRepository {

    @Inject
    AppInfoRepository(PSApiService psApiService, AppExecutors appExecutors, PSCoreDb db) {
        super(psApiService, appExecutors, db);
    }

    public LiveData<Resource<PSAppInfo>> deleteTheSpecificObjects(String startDate, String endDate) {

        final MutableLiveData<Resource<PSAppInfo>> statusLiveData = new MutableLiveData<>();

        appExecutors.networkIO().execute(() -> {

            Response<PSAppInfo> response;

            try {
                response = psApiService.getDeletedHistory(Config.API_KEY, startDate, endDate).execute();

                ApiResponse<PSAppInfo> apiResponse = new ApiResponse<>(response);

                if (apiResponse.isSuccessful()) {

                    try {
                        db.beginTransaction();

                        if (apiResponse.body != null) {

                            if (apiResponse.body.deletedObjects.size() > 0) {
                                for (DeletedObject deletedObject: apiResponse.body.deletedObjects)
                                {
                                    switch (deletedObject.typeName) {
                                        case Constants.APPINFO_NAME_CITY:
                                            db.cityDao().deleteCityById(deletedObject.id);

                                            break;
                                        case Constants.APPINFO_NAME_ITEM:
                                            db.itemDao().deleteItemById(deletedObject.id);
                                            db.historyDao().deleteHistoryItemById(deletedObject.id);

                                            break;
                                        case Constants.APPINFO_NAME_CATEGORY:
                                            db.itemCategoryDao().deleteItemCategoryById(deletedObject.id);
                                            break;
                                    }
                                }
                            }
                        }

                        db.setTransactionSuccessful();
                    } catch (NullPointerException ne) {
                        Utils.psErrorLog("Null Pointer Exception : ", ne);
                    } catch (Exception e) {
                        Utils.psErrorLog("Exception : ", e);
                    } finally {
                        db.endTransaction();
                    }

                    statusLiveData.postValue(Resource.success(apiResponse.body));

                } else {
                    statusLiveData.postValue(Resource.error(apiResponse.errorMessage, null));
                }

            } catch (IOException e) {
                statusLiveData.postValue(Resource.error(e.getMessage(), null));
            }

        });

        return statusLiveData;
    }
}
