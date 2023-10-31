import java.time.LocalDate;
import java.util.Scanner;  
import java.time.format.DateTimeFormatter;

public class Store { 
	Items[] raspberries= new Items[10];
	int rasCount=0; //tracks the amount of raspberries in the store
	Items[] Downy= new Items[5];
	int soapCount=0;//tracks the amount of downy in the store
	Items[] Tropicana= new Items[7];
	int juiceCount=0;//tracks the amount of tropicana in the store
	
	public void createProduct(String product, String name) {
		//String product, String name, LocalDate date, int time
		Scanner input = new Scanner(System.in);
		if(name.equals("") || product.equals("")) {
			System.out.println("ProductID and ProductName are required to create a product. The other arguments take default values.");
		}else {
			System.out.println("Would you like to provide the date and time for markdown?");
			String answer =input.nextLine();
			if(answer.equals("no")) {
				defaultCreateProduct(product,name);
			}else {
				System.out.println("What is the expiration date? Please provide in this format: DD-MMM-YYYY. Example: 30 Oct 2023");
				String date=input.nextLine();
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
				LocalDate dateUpdated=LocalDate.parse(date, dateTimeFormatter);
				System.out.println("What is the time duration for the markdown date");
				int time=input.nextInt();
				input.nextLine();
				
				if(name.equals("raspberries")) {
					//checks if raspberries have reached their max
					if(rasCount == 10) {
						System.out.println("We are unable to create another raspberry because the product has reached its maximum");
					}else{
						//checks if the product name is unique by comparing it to every product ID in the raspberry category
						String status;
						status=validateID(product);
						if( status != null) {
							System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
						}
						if(status == null) {
							//if productName is unique, the instance for that object is created and is saved in the store
							Items fruit = new Items();
							fruit.ProductName= name;
							fruit.ProductID = product;
							fruit.ExpiryDate = dateUpdated;
							fruit.MarkdownDate = fruit.ExpiryDate.minusDays(time);
							raspberries[rasCount]=fruit;
							rasCount++;
							System.out.println("ProductName with the ProductID created successfully");
		
						}
					}
				}
				if(name.equals("Downy") || name.equals("downy")) {
					//checks if Downy have reached their max
					if(soapCount == 5) {
						System.out.println("We are unable to create another Downy because the product has reached its maximum");
					}else {
						//checks if the product name is unique by comparing it to every product ID in the Downy category
						String status;
						status=validateID(product);
						if( status != null) {
							System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
						}
						if(status == null) {
							Items soap = new Items();
							soap.ProductName= name;
							soap.ProductID = product;
							soap.ExpiryDate = dateUpdated;
							soap.MarkdownDate = soap.ExpiryDate.minusDays(time);
							Downy[soapCount]=soap;
							soapCount++;
							System.out.println("ProductName with the ProductID created successfully");
						}
					}
				}
				if(name.equals("Tropicana") || name.equals("tropicana")) {
					//checks if Tropicana have reached their max
					if(juiceCount == 7) {
						System.out.println("We are unable to create another Tropicana because the product has reached its maximum");
					}else{
						//checks if the product name is unique by comparing it to every product ID in the Downy category
						String status;
						status=validateID(product);
						if( status != null) {
							System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
						}
						if(status == null) {
							//if productName is unique, the instance for that object is created and is saved in the store
							Items juice = new Items();
							juice.ProductName= name;
							juice.ProductID = product;
							juice.ExpiryDate = dateUpdated;
							juice.MarkdownDate = juice.ExpiryDate.minusDays(time);
							Tropicana[juiceCount]=juice;
							juiceCount++;
							System.out.println("ProductName with the ProductID created successfully");
		
							}
					}
				}
			}
		}
	}
	
	public void defaultCreateProduct(String product, String name) {
	//checks if item is a raspberry
		if(name.equals("raspberries") || name.equals("raspberry") ) {
			//checks if raspberries have reached their max
			if(rasCount == 10) {
				System.out.println("We are unable to create another raspberry because the product has reached its maximum");
			}else{
				//checks if the product name is unique
				String status;
				status=validateID(product);
				if( status != null) {
					System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
				}
				if(status == null) {
					//if productName is unique, the instance for that object is created and is saved in the store
					Items fruit = new Items();
					fruit.ProductName= name;
					fruit.ProductID = product;
					raspberries[rasCount]=fruit;
					fruit.setExpiration(); //it is given the default value
					fruit.setMarkdown();//it is given the default value
					raspberries[rasCount] = fruit;
					rasCount++;
					System.out.println("ProductName with the ProductID created successfully");
				}
				}
			}
		if(name.equals("Downy") || name.equals("downy")) {
			//checks if item is a raspberry
			if(soapCount == 5) {
				System.out.println("We are unable to create another Downy because the product has reached its maximum");
			}else {
				//checks if the product name is unique
				String status;
				status=validateID(product);
				if( status != null) {
					System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
				}
				if(status == null) {
					//if productName is unique, the instance for that object is created and is saved in the store
					Items soap = new Items();
					soap.ProductName= name;
					soap.ProductID = product;
					soap.setExpiration(); //it is given the default value
					soap.setMarkdown(); //it is given the default value
					Downy[soapCount]=soap;
					soapCount++;
					System.out.println("ProductName with the ProductID created successfully");
				}
			}
		}
			
		if(name.equals("Tropicana") || name.equals("tropicana")) {
			if(juiceCount == 7) {
				System.out.println("We are unable to create another Tropicana because the product has reached its maximum");
			}else{
				//checks if the product name is unique
				String status;
				status=validateID(product);
				if( status != null) {
					System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
				}
				if(status == null) {
					//if productName is unique, the instance for that object is created and is saved in the store
					Items juice = new Items();
					juice.ProductName= name;
					juice.ProductID = product;
					juice.setExpiration(); //it is given the default value
					juice.setMarkdown(); //it is given the default value
					Tropicana[juiceCount]=juice;
					juiceCount++;
					System.out.println("ProductName with the ProductID created successfully");

				}
			}
		}
				
		
	}
	public void displayProduct(String name, String ID){
		Boolean status=true;
		//checks if the product exists, if not message will get printed
		String created =validateID(ID);
		if( created == null || !name.equals(created)) {
			System.out.println("Productname/ProductID not found");
		}
		//if the product exists, its attributes will get printed
		if( created != null) {
			if(name.equals("raspberries") || name.equals("raspberry")) {
				//prints out the products attributes if name and ID match
				status=printProduct(ID, raspberries, rasCount);
				//if we have the ID but it belongs to a different item name, this will print
				if(status == false) {
					System.out.println("The product name you provided does not match");
				}
			}
			if(name.equals("Downy") || name.equals("downy")) {
				//prints out the products attributes if name and ID match
				status=printProduct(ID, Downy, soapCount);
				//if we have the ID but it belongs to a different item name, this will print
				if(status == false) {
					System.out.println("The product name you provided does not match");
				}
			}
			if(name.equals("Tropicana") || name.equals("tropicana")) {
				//prints out the products attributes if name and ID match
				status=printProduct(ID, Tropicana, juiceCount);
				//if we have the ID but it belongs to a different item name, this will print
				if(status == false) {
					System.out.println("The product name you provided does not match");
				}
			}
		}
		
	}
	
	//prints out the attributes of the product passed in
	public Boolean printProduct(String ID, Items[] array, int count) {
		Boolean status=false;

		for(int i =0; i< count;i++) {
			if(array[i].ProductID.equals(ID)) {
				//once the product ID is found in the array, it will print it the name, ID, expiry date and markdown date
				System.out.println("Product name: "+array[i].ProductName);
				System.out.println("Product ID: "+array[i].ProductID);
				System.out.println("Expiry date: "+array[i].ExpiryDate);
				System.out.println("Markdown date: "+array[i].MarkdownDate);
				status=true;
				break;
			}
		}
		return status;
	}
	
	//if no parameters are given
	public void emptyDisplayProduct(){
			//if its a raspberry, prints out the name and product ID
			for(int i =0; i< rasCount; i++) {
				System.out.println("Product name: raspberries");
				System.out.println("Product ID: "+raspberries[i].ProductID);
			}
			//if its a Downy, prints out the name and product ID
			for(int i =0; i< soapCount; i++) {
				System.out.println("Product name: Downy");
				System.out.println("Product ID: "+Downy[i].ProductID);
			}
			//if its a Tropicana, prints out the name and product ID
			for(int i =0; i< juiceCount; i++) {
				System.out.println("Product name: Tropicana");
				System.out.println("Product ID: "+Tropicana[i].ProductID);
			}
		
	}
	
	//checks if the product ID provided is in the system
	public String validateID(String ID) {
		String name=null;
		
		for(int i= 0;i< rasCount;i++) {
			if(ID.equals(raspberries[i].ProductID)) {
				name="raspberries";
				
			}
		}
		for(int i= 0;i< soapCount;i++) {
			if(ID.equals(Downy[i].ProductID)) {
				name="Downy";
			}
		}
		for(int i= 0;i< juiceCount;i++) {
			if(ID.equals(Tropicana[i].ProductID)) {
				name="Tropicana";
			}
		}
		//return the name of the product
		return name;
	}
	
	
	
	
	
	
	public void displayProductToRefill(String product){
		//checks if product exists in the system
		String name=validateID(product);
		if( name == null) {
			System.out.println("Productname/ProductID not found");
		}
		//if we do have the product ID, the code below will run
		if(name != null) {
			if(name.equals("raspberries")) {
				//min for raspberries is 5
				//if one raspberry needs to be replenished
				if(5 - rasCount == 1) {
					System.out.println(5-rasCount+" raspberry need to be replenished");
				}
				//if many raspberries needs to be replenished
				else if(5 - rasCount > 1){
					System.out.println(5-rasCount+" raspberries need to be replenished");
				}
				//if no raspberries need to be replenished
				else {
					System.out.println("No raspberries need to be replenished");
				}
			}
			if(name.equals("Downy")) {
				//min for Downy is 2
				if(soapCount < 2) {
					//if many Downy's needs to be replenished
					System.out.println(2-soapCount+" Downy need to be replenished");
				}
				//if no Downy's need to be replenished
				else {
					System.out.println("No Downy need to be replenished");
				}
			}
			if(name.equals("Tropicana")) {
				//min for Tropicana is 6
				if(juiceCount < 6) {
					//if many Tropicana needs to be replenished
					System.out.println(6-juiceCount+" Tropicana need to be replenished");
				}
				//if no Tropicana need to be replenished
				else{
					System.out.println("No Tropicana need to be replenished");
				}
				
			}
		
		}
	}
	//if no parameters are given
	public void displayProductToRefill(){
		//if one raspberry needs to be replenished
		if(5 - rasCount == 1) {
			System.out.println(5-rasCount+" raspberry need to be replenished");
		}
		//if many raspberries needs to be replenished
		else if(5 - rasCount > 1){
			System.out.println(5-rasCount+" raspberries need to be replenished");
		}
		//if no raspberries need to be replenished
		else {
			System.out.println("No raspberries need to be replenished");
		}
		//if many Downy's needs to be replenished
		if(soapCount < 2) {
			System.out.println(2-soapCount+" Downy need to be replenished");
		}
		//if no Downy's need to be replenished
		else {
			System.out.println("No Downy need to be replenished");
		}
		//if many Tropicana needs to be replenished
		if(juiceCount < 6) {
			System.out.println(6-juiceCount+" Tropicana need to be replenished");
		}
		//if no Tropicana need to be replenished
		else{
			System.out.println("No Tropicana need to be replenished");
		}
		
	}
	public void displayProductCount(String ID) {
		String name=validateID(ID);
		if( name == null) {
			System.out.println("Productname/ProductID not found");
		}
		if(name != null) {
			if(name.equals("raspberries")) {
				System.out.println("The number of raspberries: "+rasCount);
			}
			if(name.equals("Downy")) {
				System.out.println("The number of Downy: "+soapCount);
			}
			if(name.equals("Tropicana")) {
				System.out.println("The number of Tropicana: "+juiceCount);
			}
		}
	}
	public void displayProductCount() {
		System.out.println("The number of each product:");
		System.out.println("raspberries: "+rasCount);
		System.out.println("Downy: "+soapCount);
		System.out.println("Tropicana: "+juiceCount);
	
	}
	public void displayProductsExpiryDate(String ID){
		String name=validateID(ID);
		if( name == null) {
			System.out.println("Productname/ProductID not found");
		}
		if(name != null) {
			//checks if ID belongs to raspberries
			if(name.equals("raspberries") || name.equals("raspberry")) {
				printExpiry(ID, raspberries,rasCount);
			}
			
			//checks if ID belongs to Downy
			if(name.equals("Downy") || name.equals("downy")) {
				printExpiry(ID, Downy,soapCount);
			}
			//checks if ID belongs to Tropicana
			if(name.equals("Tropicana") || name.equals("tropicana")) {
				printExpiry(ID, Tropicana,juiceCount);
			}
		}
	}
	//prints out the expiration date of the item
	public void printExpiry(String ID, Items[] array, int count) {
		for(int i= 0;i< count;i++) {
			if(ID.equals(array[i].ProductID)) {
				System.out.println("The Expiry date of "+ID+" is "+array[i].ExpiryDate);
				break;
			}
		}
		
	}
	public void displayProductsExpiryDate(){
		//prints expiration date of raspberries items
		for(int i= 0;i< rasCount;i++) {
			System.out.println("The Expiry date of "+raspberries[i].ProductID+" is "+raspberries[i].ExpiryDate);
		}
		//prints expiration date of Downy items
		for(int i= 0;i< soapCount;i++) {
			System.out.println("The Expiry date of "+Downy[i].ProductID+" is "+Downy[i].ExpiryDate);
		}
		//prints expiration date of Tropicana items
		for(int i= 0;i< juiceCount;i++) {
			System.out.println("The Expiry date of "+Tropicana[i].ProductID+" is "+Tropicana[i].ExpiryDate);
		}
		
		
	}
	public void displayExpiredProducts(){
		Boolean status=false;
		//if there are no products
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}else {
			//checks if any raspberries are expired
			status=printExpired(raspberries,rasCount);
			
			//checks if any Downy are expired
			status=printExpired(Downy,soapCount);
			
			//checks if any Tropicana are expired
			status=printExpired(Tropicana,juiceCount);
			
			if(status == false) {
				System.out.println("No products are expired");
			}
		
		}
	}
	//prints any items that are expired, if anything gets printed returns value true
	public Boolean printExpired(Items[] array, int count) {
		Boolean status=false;
		for(int i= 0;i< count;i++) {
			if(array[i].ExpiryDate.equals(LocalDate.now()) || array[i].ExpiryDate.isBefore(LocalDate.now())) {
				System.out.println("THIS PRODUCT IS EXPIRED");
				System.out.println("Product Name: "+ array[i].ProductName);
				System.out.println("Product ID: "+ array[i].ProductID);
				System.out.println("EXPIRATION DATE: "+ array[i].ExpiryDate);
				status=true;
			}
		}
		return status;
	}
	
	public void displayProductsInMarkDown(){
		Boolean status=false;
		//if there are no products
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}else {
		   //checks if raspberries are past their markdown date
			status=printInMarkdown(raspberries, rasCount);
			
		    //checks if Downy are past their markdown date
			status=printInMarkdown(Downy, soapCount);
			
		    //checks if Tropicana are past their markdown date
			status=printInMarkdown(Tropicana, juiceCount);
			if(status == false) {
				System.out.println("No products are past their markdown date");
			}
		
		}
	}
	//prints items that are past their markdown date, if any are printed true is returned
	public Boolean printInMarkdown(Items[] array, int count) {
		Boolean status=false;
		for(int i= 0;i< count;i++) {
			if(array[i].MarkdownDate.isBefore(LocalDate.now())) {
				System.out.println("This product is past its markdown date");
				System.out.println("Product Name: "+ array[i].ProductName);
				System.out.println("Product ID: "+ array[i].ProductID);
				System.out.println("Markdown date: "+ array[i].MarkdownDate);
				status = true;
			}
		}
		return status;
	}
	public void displayProductsForMarkDown(){
		Boolean status=false;
		//if there are no products
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}else {
			//checks if raspberries have any due in a week
			status=printForMarkdown(raspberries, rasCount);
			
			//checks if Downy have any due in a week
			status=printForMarkdown(Downy, soapCount);	

			//checks if Tropicana have any due in a week
			status=printForMarkdown(Tropicana, juiceCount);	
			
			if(status == false) {
				System.out.println("No products markdown date is in a week");
			}
		
		}
		
	}
	//prints out items whose markdown date is in a week, if any are printed true is returned
	public Boolean printForMarkdown(Items[] array, int count) {
		Boolean status=false;
		for(int i= 0;i< count;i++) {
			if(array[i].MarkdownDate.isEqual(LocalDate.now().plusDays(7))) {
				System.out.println("This product's markdown date is in a week");
				System.out.println("Product Name: "+ array[i].ProductName);
				System.out.println("Product ID: "+ array[i].ProductID);
				System.out.println("Markdown date: "+ array[i].MarkdownDate);
				status = true;
			}
		}
		return status;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Store store = new Store();
		Boolean on = true;
		while(on) {
			System.out.println("What would you like to do?");
			System.out.println("1: Create a product");
			System.out.println("2: Display a product");
			System.out.println("3: Display products that need to be refilled");
			System.out.println("4: Display product count");
			System.out.println("5: Display product expiration date");
			System.out.println("6: Display all expired products");
			System.out.println("7: Display products past the markdown date");
			System.out.println("8: Display products whose markdown date is in a week");
			System.out.println("9: Log out");
			int choice = input.nextInt();
			String name;
			String product;
			input.nextLine();
			if(choice == 1) {
				System.out.println("What product would you like to initalize: raspberries, Downy or Tropicana");
				name=input.nextLine();
				System.out.println("What is the product ID? Example: 25871");
				product=input.nextLine();
				store.createProduct(product,name);
				continue;
			}	if(choice == 6) {
				store.displayExpiredProducts();
				continue;
			}
			if(choice == 7) {
				store.displayProductsInMarkDown();
				continue;
			}
			if(choice == 8) {
				store.displayProductsForMarkDown();
				continue;
			}
			if(choice == 9 ) {
				System.out.println("Goodbye!");
				on = false;
				continue;
			}
			if(store.rasCount ==0 && store.soapCount==0 && store.juiceCount==0 ) {
				System.out.println("Sorry we don't have any products");
				continue;
			}else {
				if(choice == 2) {
					System.out.println("Would you like to provide the name and ID of the product");
					String answer = input.nextLine();
					if(answer.equals("no")){
						store.emptyDisplayProduct();
					}else {
						System.out.println("What is the name of the product?");
						name = input.nextLine();
						System.out.println("What is the ID of the product?");
						String ID = input.nextLine();
						store.displayProduct(name,ID);
					}
				}if(choice == 3) {
					System.out.println("Would you like to provide the product ID?");
					String answer = input.nextLine();
					if(answer.equals("no")) {
						store.displayProductToRefill();
					}else {
						System.out.println("What is the the ID of the product?");
						product = input.nextLine();
						store.displayProductToRefill(product);
					}
				}if(choice == 4) {
					System.out.println("Would you like to provide a product ID?");
					String answer = input.nextLine();
					if(answer.equals("no")) {
						store.displayProductCount();
					}else {
						System.out.println("What is the the ID of the product?");
						product = input.nextLine();
						store.displayProductCount(product);
					}
				}
				if(choice == 5) {
					System.out.println("Would you like to provide the product ID?");
					String answer = input.nextLine();
					if(answer.equals("no")) {
						store.displayProductsExpiryDate();
					}else {
						System.out.println("What is the the ID of the product?");
						product = input.nextLine();
						store.displayProductsExpiryDate(product);
					}
				}
			}
		}
		
		
	}
	public class Items{
		String ProductID;
		String ProductName;
		LocalDate ExpiryDate;
		LocalDate MarkdownDate;
		
		public void setExpiration(){
			ExpiryDate= LocalDate.now().plusMonths(3);//default value is 3 months
		}
		public void setMarkdown() {
			MarkdownDate= ExpiryDate.minusDays(6);// default value is 6 days
		}
	}

}
