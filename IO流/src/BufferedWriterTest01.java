import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedWriter bw=null;	
		
		try {
				 bw=new BufferedWriter(new FileWriter("D:/javachengxu/IO��/test"));
			bw.write("���˻�");
			
			bw.newLine();//����
		
			bw.write("һ�㶼û��˼������");
			
			bw.flush();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(bw!=null){
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}

}
