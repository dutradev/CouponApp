package dutradev.com.coupon.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dutradev on 8/23/17.
 */

public class Coupon {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("content")
    public String content;
    @SerializedName("detail")
    public String detail;
    @SerializedName("category")
    public String category;
    @SerializedName("is_hot")
    public Boolean isHot;
    @SerializedName("cover")
    public String cover;
    @SerializedName("shop_id")
    public int shopId;
    @SerializedName("shop_name")
    public String shopName;
    @SerializedName("start_date")
    public String startDate;
    @SerializedName("end_date")
    public String endDate;
    @SerializedName("deal")
    public float deal;
    @SerializedName("address")
    public String address;
    @SerializedName("lng")
    public float lng;
    @SerializedName("lat")
    public float lat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getDeal() {
        return deal;
    }

    public void setDeal(float deal) {
        this.deal = deal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }


}
