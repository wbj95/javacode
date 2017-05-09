package ������������ģʽ;

public class Producer extends Thread  
{  
    // ÿ�������Ĳ�Ʒ����  
    private int num;  
  
    // ���ڷ��õĲֿ�  
    private Storage storage;  
  
    // ���캯�������òֿ�  
    public Producer(Storage storage)  
    {  
        this.storage = storage;  
    }  
  
    // �߳�run����  
    public void run()  
    {  
        produce(num);  
    }  
  
    // ���òֿ�Storage����������  
    public void produce(int num)  
    {  
        storage.produce(num);  
    }  
  
    // get/set����  
    public int getNum()  
    {  
        return num;  
    }  
  
    public void setNum(int num)  
    {  
        this.num = num;  
    }  
  
    public Storage getStorage()  
    {  
        return storage;  
    }  
  
    public void setStorage(Storage storage)  
    {  
        this.storage = storage;  
    }  
}  
