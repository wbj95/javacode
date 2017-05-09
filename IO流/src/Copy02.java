import java.io.*;

//文件复制，只能复制纯文本文件
public class Copy02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		FileWriter fw=null;
		try {
			 fr=new FileReader("D:/javachengxu/IO流/src/Copy02.java");
			fw=new FileWriter("D:/javachengxu/IO流/test");
		
			char[] cg=new char[512];//1kb

			int temp=0;
			while((temp=fr.read(cg))!=-1){
				fw.write(cg,0,temp);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr!=null){try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
