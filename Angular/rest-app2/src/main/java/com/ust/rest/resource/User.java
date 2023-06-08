package com.ust.rest.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_User")
public class User {
        @Id
        @GeneratedValue
	    private long UserId;
        private String dateTime;
		public long getUserId() {
			return UserId;
		}
		public void setUserId(long userId) {
			UserId = userId;
		}
		public String getDateTime() {
			return dateTime;
		}
		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
	    
	 
}
