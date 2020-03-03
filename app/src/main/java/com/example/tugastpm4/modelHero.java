package com.example.tugastpm4;

import android.os.Parcel;
import android.os.Parcelable;

public class modelHero implements Parcelable {
    String heroName, heroDetail;
    int heroImages;

    protected modelHero(Parcel in) {
        heroName = in.readString();
        heroDetail = in.readString();
        heroImages = in.readInt();
    }

    public static final Creator<modelHero> CREATOR = new Creator<modelHero>() {
        @Override
        public modelHero createFromParcel(Parcel in) {
            return new modelHero(in);
        }

        @Override
        public modelHero[] newArray(int size) {
            return new modelHero[size];
        }
    };

    public modelHero() {

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDetail() {
        return heroDetail;
    }

    public void setHeroDetail(String heroDetail) {
        this.heroDetail = heroDetail;
    }

    public int getHeroImages() {
        return heroImages;
    }

    public void setHeroImages(int heroImages) {
        this.heroImages = heroImages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroName);
        dest.writeString(heroDetail);
        dest.writeInt(heroImages);
    }
}
