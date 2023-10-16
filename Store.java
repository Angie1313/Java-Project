import java.util.ArrayList;
import java.time.LocalDate;

public class StoreManagement {
	//array of the different stores created
	ArrayList<Store> stores = new ArrayList<Store>(); 
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<String> admins = new ArrayList<String>();//contains all the IDs of the those who are admins
	ArrayList<String> managers = new ArrayList<String>();//contains all the IDs of the those who are managers
	ArrayList<String> staff = new ArrayList<String>();//contains all the IDs of the those who are staff

	
	
		//can create a store
		public void storeCreation(String ID,String name, String location, String info,String type, LocalDate date) {
			String role = validateID(ID);
			if(role == "Admin"){
				System.out.println("passed through here");
				Store store = new Store();
				store.storeName = name;
				store.location = location;
				store.contactInfo = info;
				store.storeType = type;
				store.opening = date;
				//adds the store that was created to the array of stores
				stores.add(store);	
			}
			if(role != "Admin"){
				System.out.println("You don't have permission to complete this action");
			}
			
			
		}

	//assigns role and ID to the correct user role array
	public void assignID(String role, String ID) {
		String status = validateID(ID);
		if(status != null) {
			System.out.println("Your ID is not unique. Please try again.");
		}
		if(status == null) {
			if(role == "Admin") {
				admins.add(ID);
			}
			else if(role == "Manager") {
				managers.add(ID);
			}
			else if(role == "Staff") {
				staff.add(ID);
			}
			else {
				System.out.println("Your input is invalid");
			}
		}
		
	}
	//validates ID to make sure it's not a duplicate
	public String validateID(String ID) {
		String status=null;
		for(int i =0;i< admins.size();i++) {
			if(ID == admins.get(i)) {
				status = "Admin";
			}
		}
		for(int i =0;i< managers.size();i++) {
			if(ID == managers.get(i)) {
				status = "Manager";
			}
		}
		for(int i =0;i< staff.size();i++) {
			if(ID == staff.get(i)) {
				status = "Staff";
			}
		}
		return status;
	}

	
	//search by location
	public int searchStoreLocation(String location) {
		int index =0;
		for(int i =0;i< stores.size();i++) {
			if(location == stores.get(i).location) {
				System.out.println("Here is the store information");
				System.out.println("Store Name: "+stores.get(i).storeName);
				System.out.println("Store Type: "+stores.get(i).storeType);
				System.out.println("Store Information: "+stores.get(i).contactInfo);
				System.out.println("Store Opening Date: "+stores.get(i).opening);
				index= i;
				//since each store has a different address
				break;
			}
		}
		return index;
	}
	//search by type
	public void searchStoreType(String type) {
		for(int i =0;i< stores.size();i++) {
			if(type == stores.get(i).storeType) {
				System.out.println("Here is the store information");
				System.out.println("Store Name: "+stores.get(i).storeName);
				System.out.println("Store Location: "+stores.get(i).location);
				System.out.println("Store Information: "+stores.get(i).contactInfo);
				System.out.println("Store Opening Date: "+stores.get(i).opening);
			}
		}
	}
	//search by opening date
	public void searchStoreDate(LocalDate date) {
		for(int i =0;i< stores.size();i++) {
			if(date.equals(stores.get(i).opening)) {
				System.out.println("Here is the store information");
				System.out.println("Store Name: "+stores.get(i).storeName);
				System.out.println("Store Location: "+stores.get(i).location);
				System.out.println("Store Type: "+stores.get(i).storeType);
				System.out.println("Store Information: "+stores.get(i).contactInfo);
				
			}
		}
	}
	//search by name
	public int searchStoreName(String name) {
		int index =0;
		for(int i =0;i< stores.size();i++) {
			if(name == stores.get(i).storeName) {
				System.out.println("Here is the store information");
				System.out.println("Store Location: "+stores.get(i).location);
				System.out.println("Store Type: "+stores.get(i).storeType);
				System.out.println("Store Information: "+stores.get(i).contactInfo);
				System.out.println("Store Opening Date: "+stores.get(i).opening);
				index = i;
				//since each store has a different name
				break;
			}
		}
		return index;
	}
	
	//for my own purposes
	public void display() {
		for(int i =0; i< stores.size();i++) {
			System.out.println(stores.get(i).storeName);
			System.out.println(stores.get(i).location);
			System.out.println(stores.get(i).contactInfo);
			System.out.println(stores.get(i).opening);
		}
	}
	//create items and adds it to the store they indicate
	public void itemCreation(String ID,String name, String description, String category, Double price, int quantity) {
			//checks if the person requesting to create the item is authorized
			String role = validateID(ID);
			if(role == "Admin") {
				Item newItem = new Item();
				newItem.itemName = name;
				newItem.description = description;
				newItem.category = category;
				newItem.price  = price;
				newItem.initialQuantity = quantity;
				//adds newly created item to item array
				items.add(newItem);
				System.out.println("it was added");
				
				//add output asking which store they want to add it to
				//System.out.println("What store do you want to add this item to? please provide the location
				//since the one thing that is unique for sure, we will as for location
				//int index=searchLocation(location);
				//adds item to the store that was given
				//stores.get(index).addItems(newItem);
				
				
		}

		
	}
	public int searchItemName(String name) {
		int index=0;
		for(int i =0; i< items.size(); i++) {
			if(name == items.get(i).itemName) {
				System.out.println("Description: "+ items.get(i).description);
				System.out.println("Category: "+ items.get(i).category);
				System.out.println("Price: "+ items.get(i).price);
				index=i;
				//since each item should be named uniquely
				break;
				}
		}
		return index;
	}
	public void searchItemCategory(String category) {
		for(int i =0; i< items.size(); i++) {
			if(category == items.get(i).category) {
				System.out.println("Name: "+ items.get(i).itemName);
				System.out.println("Description: "+ items.get(i).description);
				System.out.println("Price: "+ items.get(i).price);
				}
		}
		
	}
	public void searchItemRange(double bottom, double top) {
		for(int i =0; i< items.size(); i++) {
			if(items.get(i).price >= bottom && items.get(i).price <= top) {
				System.out.println("Name: "+ items.get(i).itemName);
				System.out.println("Description: "+ items.get(i).description);
				System.out.println("Category: "+ items.get(i).category);
				System.out.println("Price: "+ items.get(i).price);
				}
		}
		
	}
	public void addItemToStore(String store, String item, int quantity) {
		int storeIndex=searchStoreName(store);
		int itemIndex=searchItemName(item);
		Item newItem = new Item();
		newItem=items.get(itemIndex);
		newItem.initialQuantity = quantity;
		stores.get(storeIndex).addItems(newItem);
		
		
	}
	
	public static void main(String[] args) {
		StoreManagement l2 = new StoreManagement();
		l2.assignID("Admin","345");
		
		l2.storeCreation("345","Maggie's", "Nybe, NY", "347-346-4567","retail", LocalDate.now());
		l2.storeCreation("345","Yuppie's", "Bronx, NY", "777-777-7777","warehouse", LocalDate.parse("2023-05-03"));
		l2.storeCreation("345","Mark", "NY, NY", "777-888-7777","retail",LocalDate.now());
		//l1.searchLocation("Bronx, NY");
		//l1.searchType("warehouse");
		//l1.searchName("Mark");
		//l2.display();
		l2.itemCreation("345","Shampoo", "to wash", "produce",2.99, 4);
		l2.itemCreation("345","chicken", "breast", "produce",6.99, 10);
		l2.itemCreation("345","TP", "to wipe", "other",5.99, 7);
		l2.searchItemName("chicken");
		l2.searchItemCategory("other");
		l2.searchItemRange(1, 6);
		
	}
	public class Store{
		String storeName;
		String location;
		String contactInfo;
		String storeType;
		LocalDate opening;
		ArrayList<Item> storeItems = new ArrayList<Item>(); //all the items in the store
		
		public void addItems(Item items) {
			//the limit of items for each store is 20 items
			if(storeItems.size() == 20) {
				System.out.println("the store has reahed capicity. More items can not be added");
			}
			else {
				this.storeItems.add(items);
				//for my own purposes
				for(int i=0;i<storeItems.size();i++) {
					System.out.println("the items inside are "+ storeItems.get(i).itemName);
				}
			}
		}
		
	}
	public class Item{
		String itemName;
		String description;
		String category;
		Double price;
		int initialQuantity;
		//should I add limit for amount of initial quantity?

		
	}


}
