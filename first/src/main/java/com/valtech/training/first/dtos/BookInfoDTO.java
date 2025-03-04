package com.valtech.training.first.dtos;
 
public class BookInfoDTO {
	 // DTO Data Transfer Object
		private String PublisherName;
		private int price;
		
		
		public BookInfoDTO(String publisherName, int price) {
			super();
			PublisherName = publisherName;
			this.price = price;
		}
		public String getPublisherName() {
			return PublisherName;
		}
		public void setPublisherName(String publisherName) {
			PublisherName = publisherName;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "BookInfoDTO [PublisherName=" + PublisherName + ", price=" + price + "]";
		}
		
		
	
}
 
 