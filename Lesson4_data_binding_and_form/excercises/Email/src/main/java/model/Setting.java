package model;

public class Setting {
    private String languages;
    private int sizePage;
    private String spamFilter;
    private String signNature;

    public Setting() {
    }

    public Setting(String languages, int sizePage, String spamFilter, String signNature) {
        this.languages = languages;
        this.sizePage = sizePage;
        this.spamFilter = spamFilter;
        this.signNature = signNature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public String getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(String spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignNature() {
        return signNature;
    }

    public void setSignNature(String signNature) {
        this.signNature = signNature;
    }
}
