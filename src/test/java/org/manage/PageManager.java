package org.manage;

import org.pages.AdactinLogin;
import org.pages.BookHotel;
import org.pages.BookingConfirmation;
import org.pages.SearchHotel;
import org.pages.SelectHotel;

public class PageManager {
	
	private static AdactinLogin loginPage;
	private static SearchHotel hotelSearch;
	private static SelectHotel hotelSelect;
	private static BookHotel hotelBooking;
	private static BookingConfirmation confirmBooking;

	public static AdactinLogin getAdactinLogin() {

		if (loginPage == null) {

			loginPage = new AdactinLogin();

		}

		return loginPage;
	}

	public static SearchHotel getSearchHotel() {
		
		if (hotelSearch == null) {
			
			hotelSearch = new SearchHotel();
			
		}
		
		return hotelSearch;
	}

	public static SelectHotel getSelectHotel() {
		
		if (hotelSelect == null) {
			
			hotelSelect = new SelectHotel();
			
		}
		
		return hotelSelect;
	}

	public static BookHotel getBookHotel() {
		
		if (hotelBooking == null) {
			
			hotelBooking = new BookHotel();
			
		}
		
		return hotelBooking;
	}

	public static BookingConfirmation getBookingConfirmation() {
		
		if (confirmBooking == null) {
			
			confirmBooking = new BookingConfirmation();
			
		}
		
		return confirmBooking;
	}

}
