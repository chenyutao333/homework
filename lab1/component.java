
public class component implements CPU,RAM,hardDisk,mainBoard{
    private String name;
    private String brand;
    private String attribute;
    private double price;
    public component(String Name,String Brand,String Attribute,double Price) {
    	name = Name;
    	brand = Brand;
    	attribute = Attribute;
    	price = Price;
    }
    public String getName() {
    	return name;
    }
    public String getBrand() {
    	return brand;
    }
    public double getPrice() {
    	return price;
    }
	@Override
	public String getmainBoardAttribute() {
		// TODO Auto-generated method stub
		return "speed: "+attribute;
	}
	@Override
	public String gethardDiskAttribute() {
		// TODO Auto-generated method stub
		return "volume: "+attribute;
	}
	@Override
	public String getRAMAttribute() {
		// TODO Auto-generated method stub
		return "volume: "+attribute;
	}
	@Override
	public String getCPUAttribute() {
		// TODO Auto-generated method stub
		return "coreNum: "+attribute;
	}
    
}
