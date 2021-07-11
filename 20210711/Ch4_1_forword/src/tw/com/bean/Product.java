package tw.com.bean;

import java.util.HashMap;
import java.util.Map;

public class Product {
	private String name;
	private int price;
	private int count;
    private int sales;
    private static final Map<String,String> nameMap = new HashMap();
    static {
    	nameMap.put("0", "Âû»L");
    	nameMap.put("1", "½Þ±Æ");
    	nameMap.put("2", "³½±Æ");
    }
	public Product(String name, String price, String count, String sales) {
		this(name,Integer.parseInt(price),
				Integer.parseInt(count),
				Integer.parseInt(sales));
	}
    
	public Product(String name, int price, int count, int sales) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
		this.sales = sales;
	}
	public String getName() {
		return nameMap.get(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Product [name=" + getName() + ", price=" + price + ", count=" + count + ", sales=" + sales + "]";
	}
    
	
	
}
