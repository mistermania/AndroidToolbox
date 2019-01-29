package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Coordinates{
  @SerializedName("latitude")
  @Expose
  private String latitude;
  @SerializedName("longitude")
  @Expose
  private String longitude;
  public void setLatitude(String latitude){
   this.latitude=latitude;
  }
  public String getLatitude(){
   return latitude;
  }
  public void setLongitude(String longitude){
   this.longitude=longitude;
  }
  public String getLongitude(){
   return longitude;
  }
}