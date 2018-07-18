package com.example.lenovo.tanamanobat;

/**
 * Created by Lenovo on 18/07/2018.
 */

public class ModelPenyakit {
    private String Penyakit;

    public ModelPenyakit(String Penyakit){
        this.Penyakit = Penyakit;
    }

    public void setPenyakit(String penyakit) {
        Penyakit = penyakit;
    }

    public String getPenyakit() {
        return Penyakit;
    }
}
