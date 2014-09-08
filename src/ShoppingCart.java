import java.util.ArrayList;


public class ShoppingCart {
	private ArrayList<Item> items;
	
	public ShoppingCart(){
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item it){
		items.add(it);
	}
	
	public int totalItems(){
		return this.items.size();
	}
	
	public Item pickItem(int index) throws IndexOutOfCartException{
		Item returnItem = null;
	
		if(index>=0 && index < this.totalItems()) {
			returnItem = this.items.get(index);
		} else {
			throw new IndexOutOfCartException();
		}
		return returnItem;
	}
	
	public void removeItem(int index){
		this.items.remove(index);
	}
	
	public Double totalPrice(){
		Double totalPrice = 0.0;
		for (Item item : items) {
			totalPrice+=item.getPrice();
		}
		return totalPrice;
	}
	
}
