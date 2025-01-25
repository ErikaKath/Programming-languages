package com.co.gatosapp.logica.models;

public class ClsCatFav {
    String id;
    String image_id;
    String apiKey= "live_tCfn6M8jSEvgTBBfo6FHfPN9cy2Nzjv3EqpPVBcaxOT1NEzRsokoy0NJmowDdqMf";
    ClsImagex imagex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ClsImagex getImagex() {
        return imagex;
    }

    public void setImagex(ClsImagex imagex) {
        this.imagex = imagex;
    }
}
