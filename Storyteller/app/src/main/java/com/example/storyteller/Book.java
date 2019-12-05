package com.example.storyteller;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Book implements Parcelable {

    private String Category = "placeholder";
    private String Description;
    private int Thumbnail ;

    private String Name;
    private String DisplayName;
    private String Pronouns;
    private String Birthday;
    private String Relationship;
    private String Hometown;
    private String CurrResidence;

    public Book() {
    }

    public Book(String name, String displayName, String pronouns, String birthday, String relationship, String hometown, String currResidence, int thumbnail) {
        Name = name;
        DisplayName = displayName;
        Pronouns = pronouns;
        Birthday = birthday;
        Relationship = relationship;
        Hometown = hometown;
        CurrResidence = currResidence;
        Thumbnail = thumbnail;

        setDescription();
    }

    public Book(Parcel source) {
        Name = source.readString();
        DisplayName = source.readString();
        Description = source.readString();
        Thumbnail = source.readInt();
    }

    public String getName() {
        return Name;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public String getPronouns() {
        return Pronouns;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setDescription() {
        StringBuilder str = new StringBuilder();
        str.append(Name);
        str.append(" was born on ");
        str.append(Birthday);
        str.append(" in ");
        str.append(Hometown);
        str.append(". ");
        str.append(getSingularPronoun(true));
        str.append(" currently lives in ");
        str.append(CurrResidence);
        str.append(".");

        Description = str.toString();
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getSingularPronoun(boolean capital) {
        String str;
        if (Pronouns.equals("he/him/his")) {
            str = "he";
        } else if (Pronouns.equals("she/her/hers")) {
            str = "she";
        } else {
            str = "they";
        }

        if (capital) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        } else {
            return str;
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(Name);
        dest.writeString(DisplayName);
        dest.writeString(Description);
        dest.writeInt(Thumbnail);
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }

        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }
    };
}