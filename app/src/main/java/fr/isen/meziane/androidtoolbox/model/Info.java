package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Info{
  @SerializedName("seed")
  @Expose
  private String seed;
  @SerializedName("page")
  @Expose
  private String page;
  @SerializedName("results")
  @Expose
  private String results;
  @SerializedName("version")
  @Expose
  private String version;
  public void setSeed(String seed){
   this.seed=seed;
  }
  public String getSeed(){
   return seed;
  }
  public void setPage(String page){
   this.page=page;
  }
  public String getPage(){
   return page;
  }
  public void setResults(String results){
   this.results=results;
  }
  public String getResults(){
   return results;
  }
  public void setVersion(String version){
   this.version=version;
  }
  public String getVersion(){
   return version;
  }
}