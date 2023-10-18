import java.time.LocalDate;  


public class Store { 
	Items[] rasberries= new Items[10];
	int rasCount=0; //tracks the amount of raspberries in the store
	Items[] Downy= new Items[5];
	int soapCount=0;//tracks the amount of downy in the store
	Items[] Tropicana= new Items[7];
	int juiceCount=0;//tracks the amount of tropicana in the store
	
	public void createProduct(String product, String name, LocalDate date, int time) {
		if(name == "rasberries") {
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
					fruit.ExpiryDate = date;
					fruit.MarkdownDate = fruit.ExpiryDate.minusDays(time);
					rasberries[rasCount]=fruit;
					rasCount++;
					System.out.println("ProductName with the ProductID created successfully");

				}
			}
		}
		if(name == "Downy") {
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
					soap.ExpiryDate = date;
					soap.MarkdownDate = soap.ExpiryDate.minusDays(time);
					Downy[soapCount]=soap;
					soapCount++;
					System.out.println("ProductName with the ProductID created successfully");
				}
			}
		}
		if(name == "Tropicana") {
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
					juice.ExpiryDate = date;
					juice.MarkdownDate = juice.ExpiryDate.minusDays(time);
					Tropicana[juiceCount]=juice;
					juiceCount++;
					System.out.println("ProductName with the ProductID created successfully");

					}
			}
		}
		
	}
	
	public void createProduct(String product, String name) {
	//checks if item is a rasberry
		if(name == "rasberries") {
			//checks if rasberries have reached their max
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
					rasberries[rasCount]=fruit;
					fruit.setExpiration(); //it is given the default value
					fruit.setMarkdown();//it is given the default value
					rasberries[rasCount] = fruit;
					rasCount++;
					System.out.println("ProductName with the ProductID created successfully");
				}
				}
			}
		if(name == "Downy") {
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
			
		if(name == "Tropicana") {
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
	
	public void createProduct() {
		System.out.println("ProductID and ProductName are required to create a product. The other arguments take default values.");
	}
	
	public void displayProduct(String name, String ID){
		Boolean status=true;
		//checks if the product exists, if not message will get printed
		String created =validateID(ID);
		if( created == null) {
			System.out.println("Productname/ProductID not found");
		}
		//if the product exists, its attributes will get printed
		if( created != null) {
			if(name == "rasberries") {
				//prints out the products attributes if name and ID match
				status=printProduct(ID, rasberries, rasCount);
				//if we have the ID but it belongs to a different item name, this will print
				if(status == false) {
					System.out.println("The product name you provided does not match");
				}
			}
			if(name == "Downy") {
				//prints out the products attributes if name and ID match
				status=printProduct(ID, Downy, soapCount);
				//if we have the ID but it belongs to a different item name, this will print
				if(status == false) {
					System.out.println("The product name you provided does not match");
				}
			}
			if(name == "Tropicana") {
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
			if(array[i].ProductID == ID) {
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
	public void displayProduct(){
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}else {
			//if its a raspberry, prints out the name and product ID
			for(int i =0; i< rasCount; i++) {
				System.out.println("Product name: rasberries");
				System.out.println("Product ID: "+rasberries[i].ProductID);
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
	}
	
	//checks if the product ID provided is in the system
	public String validateID(String ID) {
		String name=null;
		
		for(int i= 0;i< rasCount;i++) {
			if(ID == rasberries[i].ProductID) {
				name="rasberries";
				
			}
		}
		for(int i= 0;i< soapCount;i++) {
			if(ID == Downy[i].ProductID) {
				name="Downy";
			}
		}
		for(int i= 0;i< juiceCount;i++) {
			if(ID == Tropicana[i].ProductID) {
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
			if(name == "rasberries" ) {
				//min for rasberries is 5
				//if one rasberry needs to be replenished
				if(5 - rasCount == 1) {
					System.out.println(5-rasCount+" rasberry need to be replenished");
				}
				//if many rasberries needs to be replenished
				else if(5 - rasCount > 1){
					System.out.println(5-rasCount+" rasberries need to be replenished");
				}
				//if no rasberries need to be replenished
				else {
					System.out.println("No rasberries need to be replenished");
				}
			}
			if(name == "Downy" ) {
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
			if(name == "Tropicana" ) {
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
		//if one rasberry needs to be replenished
		if(5 - rasCount == 1) {
			System.out.println(5-rasCount+" rasberry need to be replenished");
		}
		//if many rasberries needs to be replenished
		else if(5 - rasCount > 1){
			System.out.println(5-rasCount+" rasberries need to be replenished");
		}
		//if no rasberries need to be replenished
		else {
			System.out.println("No rasberries need to be replenished");
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
			if(name == "rasberries") {
				System.out.println("The number of rasberries: "+rasCount);
			}
			if(name == "Downy") {
				System.out.println("The number of Downy: "+soapCount);
			}
			if(name == "Tropicana") {
				System.out.println("The number of Tropicana: "+juiceCount);
			}
		}
	}
	public void displayProductCount() {
		//prints if there are no products
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}else {
			System.out.println("The number of each product:");
			System.out.println("rasberries: "+rasCount);
			System.out.println("Downy: "+soapCount);
			System.out.println("Tropicana: "+juiceCount);
		}
	}
	public void displayProductsExpiryDate(String ID){
		String name=validateID(ID);
		if( name == null) {
			System.out.println("Productname/ProductID not found");
		}
		if(name != null) {
			//checks if ID belongs to raspberries
			if(name == "rasberries") {
				printExpiry(ID, rasberries,rasCount);
			}
			
			//checks if ID belongs to Downy
			if(name == "Downy") {
				printExpiry(ID, Downy,soapCount);
			}
			//checks if ID belongs to Tropicana
			if(name == "Tropicana") {
				printExpiry(ID, Tropicana,juiceCount);
			}
		}
	}
	//prints out the expiration date of the item
	public void printExpiry(String ID, Items[] array, int count) {
		for(int i= 0;i< count;i++) {
			if(ID == array[i].ProductID) {
				System.out.println("The Expiry date of "+ID+" is "+array[i].ExpiryDate);
				break;
			}
		}
		
	}
	public void displayProductsExpiryDate(){
		//if there are no products
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}
		else {
			//prints expiration date of raspberries items
				for(int i= 0;i< rasCount;i++) {
					System.out.println("The Expiry date of "+rasberries[i].ProductID+" is "+rasberries[i].ExpiryDate);
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
		
	}
	public void displayExpiredProducts(){
		Boolean status=false;
		//if there are no products
		if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
			System.out.println("Sorry we don't have any products");
		}else {
			//checks if any raspberries are expired
			status=printExpired(rasberries,rasCount);
			
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
			status=printInMarkdown(rasberries, rasCount);
			
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
			status=printForMarkdown(rasberries, rasCount);
			
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
		
		Store l1 = new Store();
		l1.createProduct();
		//l1.createProduct("N56U","Tropicana");
		//l1.createProduct("J49L","Downy",LocalDate.parse("2022-10-29"),7);
		//l1.createProduct("N89O","rasberries",LocalDate.parse("2022-10-29"),7);
		//l1.createProduct("W35O","rasberries");
		//l1.createProduct("Wjhk","rasberries");
		//l1.createProduct("A31L","Tropicana",LocalDate.parse("2022-10-29"),7);
		l1.createProduct("K56U","Tropicana");
		l1.createProduct("K56U","Downy");
		l1.createProduct("1244","Downy",LocalDate.parse("2022-10-29"),7);
		//l1.createProduct("bnjl","Downy");
		//l1.createProduct("K56U","Downy");
		//l1.createProduct("K25S","Downy", LocalDate.now(),2);
		l1.createProduct("Kkkf","Tropicana");
		l1.createProduct("Wlpp","rasberries");
		//l1.createProduct("Wlsp","rasberries");
		l1.createProduct("Wsgh","rasberries",LocalDate.parse("2023-05-03"),7);
		l1.createProduct("bnjl","rasberries",LocalDate.parse("2022-10-29"),7);
		l1.createProduct("oooO","rasberries");
		l1.createProduct("oooO","rasberries");
		//l1.createProduct("Kkkk","Tropicana");
		//l1.createProduct("Kkkp","Tropicana");
		l1.displayProductToRefill("uuuu");
		l1.displayProductToRefill("1244");
		
		//l1.displayProductsForMarkDown();

		
		
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
