package �Ƶ����ϵͳ;

public class Hotel {
	Room[][] room;
	
		Hotel(){
			room=new Room[5][10];//��㣬ÿ��10�䣬��1��2���׼�䣬3��4��˫�˼䣬5�������
			
			//��ֵ
			for(int i=0;i<room.length;i++){
				for(int j=0;j<room[i].length;j++){
					if(i==0||i==1) room[i][j]=new Room((i+1)*100+j+1+"","��׼��",false);
					if(i==2||i==3) room[i][j]=new Room((i+1)*100+j+1+"","˫�˼�",false);
					if(i==4) room[i][j]=new Room((i+1)*100+j+1+"","������",false);
				}
			}
		}
	public void print(){
		for(int i=0;i<room.length;i++){
			for(int j=0;j<room[i].length;j++){
				System.out.print(room[i][j]);
			}
			System.out.println();
		}	
	}
	public void order(String no){
		for(int i=0;i<room.length;i++){
			for(int j=0;j<room[i].length;j++){
				if(room[i][j].getNo().equals(no)) {
					room[i][j].setUse(true);
				     return;
				}
			}
		}	
	}
	public void tuifang(String ss){
		for(int i=0;i<room.length;i++){
			for(int j=0;j<room[i].length;j++){
				if(room[i][j].getNo().equals(ss)) {
					room[i][j].setUse(false);
				     return;
				}
			}
		}	
	}
	
}
