package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Picture{
  @SerializedName("thumbnail")
  @Expose
  private String thumbnail;
  @SerializedName("large")
  @Expose
  private String large;
  @SerializedName("medium")
  @Expose
  private String medium;
  public void setThumbnail(String thumbnail){
   this.thumbnail=thumbnail;
  }
  public String getThumbnail(){
   return thumbnail;
  }
  public void setLarge(String large){
   this.large=large;
  }
  public String getLarge(){
   return large;
  }
  public void setMedium(String medium){
   this.medium=medium;
  }
  public String getMedium(){
   return medium;
  }
}