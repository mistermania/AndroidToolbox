package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Id{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("value")
  @Expose
  private String value;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setValue(String value){
   this.value=value;
  }
  public String getValue(){
   return value;
  }
}