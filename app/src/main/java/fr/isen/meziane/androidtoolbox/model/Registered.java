package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Registered{
  @SerializedName("date")
  @Expose
  private String date;
  @SerializedName("age")
  @Expose
  private String age;
  public void setDate(String date){
   this.date=date;
  }
  public String getDate(){
   return date;
  }
  public void setAge(String age){
   this.age=age;
  }
  public String getAge(){
   return age;
  }
}