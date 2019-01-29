package fr.isen.meziane.androidtoolbox.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Results{
  @SerializedName("nat")
  @Expose
  private String nat;
  @SerializedName("gender")
  @Expose
  private String gender;
  @SerializedName("phone")
  @Expose
  private String phone;
  @SerializedName("dob")
  @Expose
  private Dob dob;
  @SerializedName("name")
  @Expose
  private Name name;
  @SerializedName("registered")
  @Expose
  private Registered registered;
  @SerializedName("location")
  @Expose
  private Location location;
  @SerializedName("id")
  @Expose
  private Id id;
  @SerializedName("login")
  @Expose
  private Login login;
  @SerializedName("cell")
  @Expose
  private String cell;
  @SerializedName("email")
  @Expose
  private String email;
  @SerializedName("picture")
  @Expose
  private Picture picture;
  public void setNat(String nat){
   this.nat=nat;
  }
  public String getNat(){
   return nat;
  }
  public void setGender(String gender){
   this.gender=gender;
  }
  public String getGender(){
   return gender;
  }
  public void setPhone(String phone){
   this.phone=phone;
  }
  public String getPhone(){
   return phone;
  }
  public void setDob(Dob dob){
   this.dob=dob;
  }
  public Dob getDob(){
   return dob;
  }
  public void setName(Name name){
   this.name=name;
  }
  public Name getName(){
   return name;
  }
  public void setRegistered(Registered registered){
   this.registered=registered;
  }
  public Registered getRegistered(){
   return registered;
  }
  public void setLocation(Location location){
   this.location=location;
  }
  public Location getLocation(){
   return location;
  }
  public void setId(Id id){
   this.id=id;
  }
  public Id getId(){
   return id;
  }
  public void setLogin(Login login){
   this.login=login;
  }
  public Login getLogin(){
   return login;
  }
  public void setCell(String cell){
   this.cell=cell;
  }
  public String getCell(){
   return cell;
  }
  public void setEmail(String email){
   this.email=email;
  }
  public String getEmail(){
   return email;
  }
  public void setPicture(Picture picture){
   this.picture=picture;
  }
  public Picture getPicture(){
   return picture;
  }
}