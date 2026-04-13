package ra.model;

import java.util.List;

public class Combo {
    private List<String> itemList;
    private String bannerPath;

    public Combo() {}

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }
}