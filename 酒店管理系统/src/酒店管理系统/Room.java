package �Ƶ����ϵͳ;

public class Room {
	private String no;//���䷿��
	private String type;//�������� ��׼�䣬˫�˼䣬������
	private boolean isUse;//�Ƿ�ռ��
	
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
		return "[" + no + ", " + type + ", " + (isUse?"ռ��":"����")+" ]";
	}
	
	
}
