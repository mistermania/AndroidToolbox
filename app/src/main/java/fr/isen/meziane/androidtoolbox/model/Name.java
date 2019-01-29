package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Name{
  @SerializedName("last")
  @Expose
  private String last;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("first")
  @Expose
  private String first;
  public void setLast(String last){
   this.last=last;
  }
  public String getLast(){
   return last;
  }
  public void setTitle(String title){
   this.title=title;
  }
  public String getTitle(){
   return title;
  }
  public void setFirst(String first){
   this.first=first;
  }
  public String getFirst(){
   return first;
  }
}