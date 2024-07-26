Feature: validating order id functionality of adactin hotel application

	Scenario Outline: validating hotel booking with different rooms
		Given user is on Adactin Hotel application on chrome browser
		When user enters "<username>" and "<password>"
		And user clicks on login button
		When user selects "<location>", "<hotels>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
		And user clicks on search button
		When user selects a hotel
		And user clicks on continue button
		When user enters "<firstName>", "<lastName>", "<billingAddress>", "<ccNumber>", "<cardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
		And user clicks on book now button
		Then user validates the order id
		

		
		Examples:
		|username|password|location|hotels|roomType|numberOfRooms|checkInDate|checkOutDate|adultsPerRoom|childrenPerRoom|firstName|lastName|billingAddress|ccNumber|cardType|expiryMonth|expiryYear|cvvNumber|
		|dk161087|test123456|Sydney|Hotel Creek|Standard|2 - Two|26/07/2024|28/07/2024|2 - Two|1 - One|Dilip|Kumar|Chennai|5454545454545450|Master Card|October|2026|456|
		|dk161087|test123456|Melbourne|Hotel Sunshine|Double|3 - Three|23/07/2024|25/07/2024|3 - Three|2 - Two|Arun|Vignesh|Bangalore|5544554455445540|VISA|November|2028|678|
		|dk161087|test123456|Adelaide|Hotel Hervey|Deluxe|4 - Four|21/07/2024|23/07/2024|2 - Two|3 - Three|Ashok|Selva|Mumbai|5554555455545550|American Express|May|2027|567|
		|dk161087|test123456|New York|Hotel Cornice|Standard|3 - Three|23/07/2024|25/07/2024|1 - One|2 - Two|Vishnu|Bala|Delhi|5555444455554440|Master Card|April|2025|345|
		|dk161087|test123456|Paris|Hotel Sunshine|Super Deluxe|2 - Two|22/07/2024|24/07/2024|3 - Three|1 - One|Shiva|Kumar|Hyderabad|5544554455444455|Other|June|2026|234|

