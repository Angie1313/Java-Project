import java.time.LocalDate;  


public class Store { 
	Items[] rasberries= new Items[10];
	int rasCount=0;
	Items[] Downy= new Items[5];
	int soapCount=0;
	Items[] tropicana= new Items[7];
	int juiceCount=0;
	
	public void createProduct(String product, String name, LocalDate date, int time) {
		if(name == "rasberries") {
			if(rasCount == 10) {
				System.out.println("product has reached its maximum");
			}else{
				Boolean status= false;
				for(int i =0; i< rasCount; i++) {
					if(product == rasberries[i].ProductID) {
						System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
						status=true;
					}
				}
				if(status == false) {//add this status to the other items and other same method
					Items fruit = new Items();
					fruit.ProductName= name;
					fruit.ProductID = product;
					fruit.ExpiryDate = date;
					fruit.MarkdownDate = fruit.ExpiryDate.minusDays(time);
					rasberries[rasCount]=fruit;
					rasCount++;
					System.out.println("product: "+name+" was added to array");
					System.out.println("ProductID: "+fruit.ProductID);
					System.out.println("ProductName: "+fruit.ProductName);
					System.out.println("ExpiryDate: "+fruit.ExpiryDate);
					System.out.println("MarkdownDate: "+fruit.MarkdownDate);
				}
			}
		}
		if(name == "Downy") {
			if(soapCount == 5) {
				System.out.println("The store is full");
			}else {
				Items soap = new Items();
				soap.ProductName= name;
				soap.ProductID = product;
				soap.ExpiryDate = date;
				soap.MarkdownDate = soap.ExpiryDate.minusDays(time);
				soapCount++;
				Downy[soapCount]=soap;
				System.out.println("product: "+name+" was added to array");
				System.out.println("ProductID: "+soap.ProductID);
				System.out.println("ProductName: "+soap.ProductName);
				System.out.println("ExpiryDate: "+soap.ExpiryDate);
				System.out.println("MarkdownDate: "+soap.MarkdownDate);
			}
		}
		
		if(name == "Tropicana") {
			if(juiceCount == 7) {
				System.out.println("The store is full");
			}else{
				Items juice = new Items();
				juice.ProductName= name;
				juice.ProductID = product;
				juice.ExpiryDate = date;
				juice.MarkdownDate = juice.ExpiryDate.minusDays(time);
				juiceCount++;
				tropicana[juiceCount]=juice;
				System.out.println("product: "+name+" was added to array");
				System.out.println("ProductID: "+juice.ProductID);
				System.out.println("ProductName: "+juice.ProductName);
				System.out.println("ExpiryDate: "+juice.ExpiryDate);
				System.out.println("MarkdownDate: "+juice.MarkdownDate);
			}
		}
		
	}
	public void createProduct(String product, String name) {
		if(name == "rasberries") {
			if(rasCount == 10) {
				System.out.println("The store is full");
			}else{
				Items fruit = new Items();
				fruit.ProductName= name;
				fruit.ProductID = product;
				rasberries[rasCount]=fruit;
				rasCount++;
				System.out.println("product: "+name+" was added to array");
				System.out.println("ProductID: "+fruit.ProductID);
				System.out.println("ProductName: "+fruit.ProductName);
				System.out.println("ExpiryDate: "+fruit.ExpiryDate);
				System.out.println("MarkdownDate: "+fruit.MarkdownDate);
				
			}
		}
		if(name == "Downy") {
			if(soapCount == 5) {
				System.out.println("The store is full");
			}else {
				Items soap = new Items();
				soap.ProductName= name;
				soap.ProductID = product;
				soapCount++;
				Downy[soapCount]=soap;
				System.out.println("product: "+name+" was added to array");
				System.out.println("ProductID: "+soap.ProductID);
				System.out.println("ProductName: "+soap.ProductName);
				System.out.println("ExpiryDate: "+soap.ExpiryDate);
				System.out.println("MarkdownDate: "+soap.MarkdownDate);
			}
		}
		
		if(name == "Tropicana") {
			if(juiceCount == 7) {
				System.out.println("The store is full");
			}else{
				Items juice = new Items();
				juice.ProductName= name;
				juice.ProductID = product;
				juiceCount++;
				tropicana[juiceCount]=juice;
				System.out.println("product: "+name+" was added to array");
				System.out.println("ProductID: "+juice.ProductID);
				System.out.println("ProductName: "+juice.ProductName);
				System.out.println("ExpiryDate: "+juice.ExpiryDate);
				System.out.println("MarkdownDate: "+juice.MarkdownDate);
			}
		}
		
	}
	public void printstate(){
		System.out.println("product ID printed    "+rasberries[0].ProductID);
		System.out.println("product ID printed    "+rasberries[1].ProductID);
	}	

	
	
	public void createProduct() {
		System.out.println("Please enter ProductID and ProductName");
	}
	
	public static void main(String[] args) {
		//System.out.println(LocalDate.now().plusMonths(6));
		Store l1 = new Store();
		l1.createProduct();
		l1.createProduct("N56U","Tropicana");
		l1.createProduct("J49L","rasberries",LocalDate.now(),4);
		l1.createProduct("K25S","Downy");
		l1.createProduct("N89O","rasberries",LocalDate.now(),4);
		l1.createProduct("J49L","rasberries",LocalDate.now(),6);
		//l1.printstate();

	}
	public class Items{
		String ProductID;
		String ProductName;
		LocalDate ExpiryDate= LocalDate.now().plusMonths(3);//default value is 3 months
		LocalDate MarkdownDate= ExpiryDate.minusDays(6);// default value is 6 days
		
	}

}
