package com.example.artistle.speccialityapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artistle on 20.11.17.
 */

public class SpecialityModel {

        @SerializedName("f_name")
        @Expose
        private String fName;
        @SerializedName("l_name")
        @Expose
        private String lName;
        @SerializedName("birthday")
        @Expose
        private String birthday;
        @SerializedName("avatr_url")
        @Expose
        private String avatrUrl;

        public String getFName() {
            return fName;
        }

        public void setFName(String fName) {
            this.fName = fName;
        }

        public String getLName() {
            return lName;
        }

        public void setLName(String lName) {
            this.lName = lName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAvatrUrl() {
            return avatrUrl;
        }

        public void setAvatrUrl(String avatrUrl) {
            this.avatrUrl = avatrUrl;
        }

}
