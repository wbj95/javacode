package 酒店管理系统;

public class Room {
	private String no;//房间房号
	private String type;//房间类型 标准间，双人间，豪华间
	private boolean isUse;//是否被占用
	
	Room(){
		super();
	}
	Room(String no,String type,boolean isUser){
		super();
		this.no=no;
		this.type=type;
		this.isUse=isUse;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isUse() {
		return isUse;
	}
	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
	@Override
	public String toString() {
		return "[" + no + ", " + type + ", " + (isUse?"占用":"空闲")+" ]";
	}
	
	
}
