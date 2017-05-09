import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedWriter bw=null;	
		
		try {
				 bw=new BufferedWriter(new FileWriter("D:/javachengxu/IO流/test"));
			bw.write("奥运会");
			
			bw.newLine();//换行
		
			bw.write("一点都没意思！！！");
			
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
