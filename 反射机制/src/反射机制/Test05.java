package 反射机制;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//java.lang.reflect.method;
public class Test05 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
			//获取类，
	
			//Class c=Class.forName("反射机制.Employee");
			Class c=Class.forName("java.lang.String");
			//获取所有的方法
			Method[] mt=c.getDeclaredMethods();
			
			/*for(Method m:mt){
				//修饰符
				System.out.println(Modifier.toString(m.getModifiers()));
				
				//返回值类型，Class<?> getReturnType() 
		          //返回一个 Class 对象，该对象描述了此 Method 对象所表示的方法的正式返回类型。 
				Class returntype=m.getReturnType();
				System.out.println(returntype.getSimpleName());
				//方法名
				System.out.println(m.getName());
				
				//参数列表, Class<?>[] getParameterTypes() 
		          //按照声明顺序返回 Class 对象的数组，这些对象描述了此 Method 对象所表示的方法的形参类型。 
				Class [] ParamaterTypes=m.getParameterTypes();
				for(Class ParamaterType:ParamaterTypes)
				{
					System.out.println(ParamaterType.getSimpleName());
				}
			}*/
			//反编译
			StringBuffer sb=new StringBuffer();
			
			sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+"{\n");
			
			for(int i=0;i<mt.length;i++)
			{
				sb.append("\t"+Modifier.toString(mt[i].getModifiers())+" ");
				sb.append(mt[i].getReturnType().getSimpleName()+" ");
				sb.append(mt[i].getName()+"(");
			//形参
				Class [] ParamaterTypes=mt[i].getParameterTypes();
				for(int j=0;j<ParamaterTypes.length;j++)
				{
					if(j==ParamaterTypes.length-1)
					{
						sb.append(ParamaterTypes[j].getSimpleName());
					}else
					{
						sb.append(ParamaterTypes[j].getSimpleName()+",");
					}
					
				}
				
					
					sb.append("){}\n");
			}
			sb.append("}");
			System.out.println(sb);
			
	}

}
