package com.raushan.roomapps.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.raushan.roomapps.viewmodel.aboutus.AboutUsViewModel;
import com.raushan.roomapps.viewmodel.apploading.PSAPPLoadingViewModel;
import com.raushan.roomapps.viewmodel.blog.BlogViewModel;
import com.raushan.roomapps.viewmodel.chat.ChatViewModel;
import com.raushan.roomapps.viewmodel.chathistory.ChatHistoryViewModel;
import com.raushan.roomapps.viewmodel.city.CityViewModel;
import com.raushan.roomapps.viewmodel.city.FeaturedCitiesViewModel;
import com.raushan.roomapps.viewmodel.city.PopularCitiesViewModel;
import com.raushan.roomapps.viewmodel.city.RecentCitiesViewModel;
import com.raushan.roomapps.viewmodel.clearalldata.ClearAllDataViewModel;
import com.raushan.roomapps.viewmodel.common.NotificationViewModel;
import com.raushan.roomapps.viewmodel.common.PSNewsViewModelFactory;
import com.raushan.roomapps.viewmodel.contactus.ContactUsViewModel;
import com.raushan.roomapps.viewmodel.homelist.HomeTrendingCategoryListViewModel;
import com.raushan.roomapps.viewmodel.image.ImageViewModel;
import com.raushan.roomapps.viewmodel.item.FavouriteViewModel;
import com.raushan.roomapps.viewmodel.item.HistoryViewModel;
import com.raushan.roomapps.viewmodel.item.PopularItemViewModel;
import com.raushan.roomapps.viewmodel.item.RecentItemViewModel;
import com.raushan.roomapps.viewmodel.item.SpecsViewModel;
import com.raushan.roomapps.viewmodel.item.TouchCountViewModel;
import com.raushan.roomapps.viewmodel.itemcategory.ItemCategoryViewModel;
import com.raushan.roomapps.viewmodel.itemcondition.ItemConditionViewModel;
import com.raushan.roomapps.viewmodel.itemcurrency.ItemCurrencyViewModel;
import com.raushan.roomapps.viewmodel.itemdealoption.ItemDealOptionViewModel;
import com.raushan.roomapps.viewmodel.itemfromfollower.ItemFromFollowerViewModel;
import com.raushan.roomapps.viewmodel.itemlocation.ItemLocationViewModel;
import com.raushan.roomapps.viewmodel.itempricetype.ItemPriceTypeViewModel;
import com.raushan.roomapps.viewmodel.itemsubcategory.ItemSubCategoryViewModel;
import com.raushan.roomapps.viewmodel.itemtype.ItemTypeViewModel;
import com.raushan.roomapps.viewmodel.notification.NotificationsViewModel;
import com.raushan.roomapps.viewmodel.psappinfo.PSAppInfoViewModel;
import com.raushan.roomapps.viewmodel.pscount.PSCountViewModel;
import com.raushan.roomapps.viewmodel.rating.RatingViewModel;
import com.raushan.roomapps.viewmodel.user.UserViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Panacea-Soft on 11/16/17.
 * Contact Email : teamps.is.cool@gmail.com
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(PSNewsViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AboutUsViewModel.class)
    abstract ViewModel bindAboutUsViewModel(AboutUsViewModel aboutUsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemLocationViewModel.class)
    abstract ViewModel bindItemLocationViewModel(ItemLocationViewModel itemLocationViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemDealOptionViewModel.class)
    abstract ViewModel bindItemDealOptionViewModel(ItemDealOptionViewModel itemDealOptionViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemConditionViewModel.class)
    abstract ViewModel bindItemConditionViewModel(ItemConditionViewModel itemConditionViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ImageViewModel.class)
    abstract ViewModel bindImageViewModel(ImageViewModel imageViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemTypeViewModel.class)
    abstract ViewModel bindItemTypeViewModel(ItemTypeViewModel itemTypeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RatingViewModel.class)
    abstract ViewModel bindRatingViewModel(RatingViewModel ratingViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel.class)
    abstract ViewModel bindNotificationViewModel(NotificationViewModel notificationViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemFromFollowerViewModel.class)
    abstract ViewModel bindItemFromFollowerViewModel(ItemFromFollowerViewModel itemFromFollowerViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemPriceTypeViewModel.class)
    abstract ViewModel bindItemPriceTypeViewModel(ItemPriceTypeViewModel itemPriceTypeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemCurrencyViewModel.class)
    abstract ViewModel bindItemCurrencyViewModel(ItemCurrencyViewModel itemCurrencyViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(ContactUsViewModel.class)
    abstract ViewModel bindContactUsViewModel(ContactUsViewModel contactUsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FavouriteViewModel.class)
    abstract ViewModel bindFavouriteViewModel(FavouriteViewModel favouriteViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TouchCountViewModel.class)
    abstract ViewModel bindTouchCountViewModel(TouchCountViewModel touchCountViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SpecsViewModel.class)
    abstract ViewModel bindProductSpecsViewModel(SpecsViewModel specsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel.class)
    abstract ViewModel bindHistoryProductViewModel(HistoryViewModel historyViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemCategoryViewModel.class)
    abstract ViewModel bindCityCategoryViewModel(ItemCategoryViewModel itemCategoryViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel.class)
    abstract ViewModel bindNotificationListViewModel(NotificationsViewModel notificationListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HomeTrendingCategoryListViewModel.class)
    abstract ViewModel bindHomeTrendingCategoryListViewModel(HomeTrendingCategoryListViewModel transactionListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BlogViewModel.class)
    abstract ViewModel bindNewsFeedViewModel(BlogViewModel blogViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PSAppInfoViewModel.class)
    abstract ViewModel bindPSAppInfoViewModel(PSAppInfoViewModel psAppInfoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ClearAllDataViewModel.class)
    abstract ViewModel bindClearAllDataViewModel(ClearAllDataViewModel clearAllDataViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CityViewModel.class)
    abstract ViewModel bindCityViewModel(CityViewModel cityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(com.raushan.roomapps.viewmodel.item.ItemViewModel.class)
    abstract ViewModel bindItemViewModel(com.raushan.roomapps.viewmodel.item.ItemViewModel itemViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PopularItemViewModel.class)
    abstract ViewModel bindPopularItemViewModel(PopularItemViewModel popularItemViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RecentItemViewModel.class)
    abstract ViewModel bindRecentItemViewModel(RecentItemViewModel recentItemViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PSAPPLoadingViewModel.class)
    abstract ViewModel bindPSAPPLoadingViewModel(PSAPPLoadingViewModel psappLoadingViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PopularCitiesViewModel.class)
    abstract ViewModel bindPopularCitiesViewModel(PopularCitiesViewModel popularCitiesViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FeaturedCitiesViewModel.class)
    abstract ViewModel bindFeaturedCitiesViewModel(FeaturedCitiesViewModel featuredCitiesViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RecentCitiesViewModel.class)
    abstract ViewModel bindRecentCitiesViewModel(RecentCitiesViewModel recentCitiesViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ItemSubCategoryViewModel.class)
    abstract ViewModel bindItemSubCategoryViewModel(ItemSubCategoryViewModel itemSubCategoryViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel.class)
    abstract ViewModel bindChatViewModel(ChatViewModel chatViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ChatHistoryViewModel.class)
    abstract ViewModel bindSellerViewModel(ChatHistoryViewModel chatHistoryViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PSCountViewModel.class)
    abstract ViewModel bindPSCountViewModel(PSCountViewModel psCountViewModel);

}


