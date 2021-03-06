package me.looorielovbb.boom.data.bean.zhihu;


import java.util.List;



public class HomeListBean {
   private String title;

    /**
     * type = 0是表示标题 1表示文字加一张图片 2：3张图片 3：2张图片 4：2图片+1张图片
     */
    public static final int TITLE = 0;
    public static final int DAILY = 1;
    public static final int HOT = 2;
    public static final int THEME = 3;
    public static final int SECTION = 4;

    private int type;

    private StoriesBean dailyList;

    private List<RecentBean> hotList;

    private List<ThemeListBean.OthersBean> themeList;

    private List<SectionListBean.DataBean> sectionList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public StoriesBean getDailyList() {
        return dailyList;
    }

    public void setDailyList(StoriesBean dailyList) {
        this.dailyList = dailyList;
    }

    public List<RecentBean> getHotList() {
        return hotList;
    }

    public void setHotList(List<RecentBean> hotList) {
        this.hotList = hotList;
    }

    public List<ThemeListBean.OthersBean> getThemeList() {
        return themeList;
    }

    public void setThemeList(List<ThemeListBean.OthersBean> themeList) {
        this.themeList = themeList;
    }

    public List<SectionListBean.DataBean> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionListBean.DataBean> sectionList) {
        this.sectionList = sectionList;
    }

    @Override
    public String toString() {
        return "HomeListBean{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", dailyList=" + dailyList +
                ", hotList=" + hotList +
                ", themeList=" + themeList +
                ", sectionList=" + sectionList +
                '}';
    }
}
