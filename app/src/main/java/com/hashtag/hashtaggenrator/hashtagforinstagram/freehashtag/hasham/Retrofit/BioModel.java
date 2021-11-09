package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Retrofit;

public class BioModel {

    private String id;
    private String Classic;
    private String Tranding;
    private String Killer;


    public BioModel(String id, String classic, String tranding, String killer) {
        this.id = id;
        Classic = classic;
        Tranding = tranding;
        Killer = killer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassic() {
        return Classic;
    }

    public void setClassic(String classic) {
        Classic = classic;
    }

    public String getTranding() {
        return Tranding;
    }

    public void setTranding(String tranding) {
        Tranding = tranding;
    }

    public String getKiller() {
        return Killer;
    }

    public void setKiller(String killer) {
        Killer = killer;
    }
}
