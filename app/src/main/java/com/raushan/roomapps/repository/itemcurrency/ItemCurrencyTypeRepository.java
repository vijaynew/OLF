package com.raushan.roomapps.repository.itemcurrency;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.raushan.roomapps.AppExecutors;
import com.raushan.roomapps.Config;
import com.raushan.roomapps.api.ApiResponse;
import com.raushan.roomapps.api.PSApiService;
import com.raushan.roomapps.db.ItemCurrencyDao;
import com.raushan.roomapps.db.PSCoreDb;
import com.raushan.roomapps.repository.common.NetworkBoundResource;
import com.raushan.roomapps.repository.common.PSRepository;
import com.raushan.roomapps.utils.Utils;
import com.raushan.roomapps.viewobject.ItemCurrency;
import com.raushan.roomapps.viewobject.common.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ItemCurrencyTypeRepository extends PSRepository {
    private ItemCurrencyDao itemCurrencyDao;

    @Inject
    ItemCurrencyTypeRepository(PSApiService psApiService, AppExecutors appExecutors, PSCoreDb db, ItemCurrencyDao itemCurrencyDao) {

        super(psApiService, appExecutors, db);
        this.itemCurrencyDao = itemCurrencyDao;
    }

    public LiveData<Resource<List<ItemCurrency>>> getAllItemCurrencyList(String limit, String offset) {

        return new NetworkBoundResource<List<ItemCurrency>, List<ItemCurrency>>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull List<ItemCurrency> itemTypeList) {
                Utils.psLog("SaveCallResult of getAllCategoriesWithUserId");


                try {
                    db.beginTransaction();

                    itemCurrencyDao.deleteAllItemCurrency();

                    itemCurrencyDao.insertAll(itemTypeList);

                    db.setTransactionSuccessful();

                } catch (Exception e) {
                    Utils.psErrorLog("Error in doing transaction of getAllCategoriesWithUserId", e);
                } finally {
                    db.endTransaction();
                }
            }


            @Override
            protected boolean shouldFetch(@Nullable List<ItemCurrency> data) {

                return connectivity.isConnected();
            }

            @NonNull
            @Override
            protected LiveData<List<ItemCurrency>> loadFromDb() {

                Utils.psLog("Load From Db (All Categories)");

                return itemCurrencyDao.getAllItemCurrency();

            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<ItemCurrency>>> createCall() {
                Utils.psLog("Call Get All Categories webservice.");

                return psApiService.getItemCurrencyTypeList(Config.API_KEY,limit, offset);
            }

            @Override
            protected void onFetchFailed(String message) {
                Utils.psLog("Fetch Failed of About Us");
            }

        }.asLiveData();
    }


}