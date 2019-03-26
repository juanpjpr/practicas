
public class Item {
	int id;
	@Override
	public String toString() {
		return "Items [id=" + id + ", desc=" + desc + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Item(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}
	
	public String intToString(){
		return ""+id;
	}
	String desc;
	
	
}
