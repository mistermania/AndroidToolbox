package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Location{
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("street")
  @Expose
  private String street;
  @SerializedName("timezone")
  @Expose
  private Timezone timezone;
  @SerializedName("postcode")
  @Expose
  private String postcode;
  @SerializedName("coordinates")
  @Expose
  private Coordinates coordinates;
  @SerializedName("state")
  @Expose
  private String state;
  public void setCity(String city){
   this.city=city;
  }
  public String getCity(){
   return city;
  }
  public void setStreet(String street){
   this.street=street;
  }
  public String getStreet(){
   return street;
  }
  public void setTimezone(Timezone timezone){
   this.timezone=timezone;
  }
  public Timezone getTimezone(){
   return timezone;
  }
  public void setPostcode(String postcode){
   this.postcode=postcode;
  }
  public String getPostcode(){
   return postcode;
  }
  public void setCoordinates(Coordinates coordinates){
   this.coordinates=coordinates;
  }
  public Coordinates getCoordinates(){
   return coordinates;
  }
  public void setState(String state){
   this.state=state;
  }
  public String getState(){
   return state;
  }
}