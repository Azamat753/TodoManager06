package com.example.todomanager06.model;

public class ViewPagerModel {
   private String title;
   private String description;
   private int image;

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public int getImage() {
      return image;
   }

   public void setImage(int image) {
      this.image = image;
   }

   public ViewPagerModel(String title, String description, int image) {
      this.title = title;
      this.description = description;
      this.image = image;
   }
}
