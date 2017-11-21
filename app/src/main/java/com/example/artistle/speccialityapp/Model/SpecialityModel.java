package com.example.artistle.speccialityapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SpecialityModel {

    public class Example {

        @SerializedName("response")
        @Expose
        public List<Response> response = null;

        public List<Response> getResponse() {
            return response;
        }
    }

    public class Response {

        @SerializedName("f_name")
        @Expose
        public String fName;
        @SerializedName("l_name")
        @Expose
        public String lName;
        @SerializedName("birthday")
        @Expose
        public String birthday;
        @SerializedName("avatr_url")
        @Expose
        public String avatrUrl;
        @SerializedName("specialty")
        @Expose
        public List<Specialty> specialty = null;

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
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

        public List<Specialty> getSpecialty() {
            return specialty;
        }

        public void setSpecialty(List<Specialty> specialty) {
            this.specialty = specialty;
        }
    }

    public class Specialty {

        @SerializedName("specialty_id")
        @Expose
        public int specialtyId;
        @SerializedName("name")
        @Expose
        public String name;

        public int getSpecialtyId() {
            return specialtyId;
        }

        public void setSpecialtyId(int specialtyId) {
            this.specialtyId = specialtyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
