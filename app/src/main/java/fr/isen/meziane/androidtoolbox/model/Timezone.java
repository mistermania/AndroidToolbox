package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Timezone{
  @SerializedName("offset")
  @Expose
  private String offset;
  @SerializedName("description")
  @Expose
  private String description;
  public void setOffset(String offset){
   this.offset=offset;
  }
  public String getOffset(){
   return offset;
  }
  public void setDescription(String description){
   this.description=description;
  }
  public String getDescription(){
   return description;
  }
}