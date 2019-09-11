package com.raushan.roomapps.viewmodel.itemdealoption;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.raushan.roomapps.repository.itemdealoption.ItemDealOptionRepository;
import com.raushan.roomapps.utils.AbsentLiveData;
import com.raushan.roomapps.utils.Utils;
import com.raushan.roomapps.viewmodel.common.PSViewModel;
import com.raushan.roomapps.viewobject.ItemDealOption;
import com.raushan.roomapps.viewobject.common.Resource;
import com.raushan.roomapps.viewobject.holder.CategoryParameterHolder;

import java.util.List;

import javax.inject.Inject;

public class ItemDealOptionViewModel extends PSViewModel {


    //region Variables

    private final LiveData<Resource<List<ItemDealOption>>> itemTypeListData;
    private MutableLiveData<ItemDealOptionViewModel.TmpDataHolder> itemTypeListObj = new MutableLiveData<>();

    public CategoryParameterHolder categoryParameterHolder = new CategoryParameterHolder();

    //endregion

    //region Constructors

    @Inject
    ItemDealOptionViewModel(ItemDealOptionRepository repository) {

        Utils.psLog("ItemDealOptionViewModel");

        itemTypeListData = Transformations.switchMap(itemTypeListObj, obj -> {
            if (obj == null) {
                return AbsentLiveData.create();
            }

            Utils.psLog("ItemDealOptionViewModel : categories");
            return repository.getAllItemDealOptionList(obj.limit, obj.offset);
        });

    }

    //endregion

    public void setItemDealOptionListObj(String limit, String offset) {
        if (!isLoading) {
            TmpDataHolder tmpDataHolder = new TmpDataHolder();
            tmpDataHolder.offset = offset;
            tmpDataHolder.limit = limit;
            itemTypeListObj.setValue(tmpDataHolder);

            // start loading
            setLoadingState(true);
        }
    }

    public LiveData<Resource<List<ItemDealOption>>> getItemDealOptionListData() {
        return itemTypeListData;
    }


    class TmpDataHolder {
        public String limit = "";
        public String offset = "";
        public String cityId = "";
    }
}
