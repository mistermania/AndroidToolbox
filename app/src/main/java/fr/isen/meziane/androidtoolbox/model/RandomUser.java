package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class RandomUser{
  @SerializedName("results")
  @Expose
  private List<Results> results;
  @SerializedName("info")
  @Expose
  private Info info;
  public void setResults(List<Results> results){
   this.results=results;
  }
  public List<Results> getResults(){
   return results;
  }
  public void setInfo(Info info){
   this.info=info;
  }
  public Info getInfo(){
   return info;
  }
}