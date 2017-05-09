package com.weibaojun.dmtest.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//DOM��ʽ����xml
public class DOMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//����һ��DocumentBuilder����
		try {
			//����DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			//ͨ��DocumentBuilder�����parse��������books.xml�ļ�����ǰ��Ŀ��
			
			Document document=	db.parse("books.xml");
			//��ȡ����book�ڵ㼯��
			NodeList bookList=document.getElementsByTagName("book");//��ȡbook�ڵ㼯��
			//��ȡbookList�ĳ���
			System.out.println("һ���У�"+bookList.getLength()+"����");
			//����ÿһ��book�ڵ�
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("===========���濪ʼ������"+(i+1)+"���������=============");
				//ͨ��item(i)������ȡһ����book�ڵ㣬,����ֵ��0��ʼ
				Node book=bookList.item(i);
				//��ȡbook�ڵ���������Եļ���
				NamedNodeMap attrs=book.getAttributes();
				System.out.println("��"+(i+1)+"���鹲��"+attrs.getLength()+"������");
				//����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					//��ȡbook�ڵ��ĳ������
					Node attr=attrs.item(j);
					//��ȡ������
					System.out.print("��������"+attr.getNodeName());
					//��ȡ����ֵ
					System.out.println("--����ֵ:"+attr.getNodeValue());
				}
				//ǰ�᣺�Ѿ�֪��book�ڵ�����ֻ����1��id����
//				//��book�ڵ����ǿ������ת����ת����Element����
//				Element book = (Element) bookList.item(i);
//				//ͨ��getAttribute("id")������ȡ����ֵ
//				String attrValue = book.getAttribute("id");
//				System.out.println("id���Ե�����ֵΪ" + attrValue);
				//����book�ڵ���ӽڵ�
				NodeList childNodes=book.getChildNodes();
				//����childNodes��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ
				System.out.println("��"+(i+1)+"���鹲��"+childNodes.getLength()+"���ӽڵ�");
				for (int k = 0; k < childNodes.getLength(); k++) {
					//����test���͵�node�Լ�element���͵�node
					if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE){
						//��ȡ��element���ͽڵ�Ľڵ���
						System.out.print("��" + (k + 1) + "���ڵ�Ľڵ�����" 
								+ childNodes.item(k).getNodeName());
						//��ȡ��element���ͽڵ�Ľڵ�ֵ
						System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getFirstChild().getNodeValue());
//						System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getTextContent());
					}
					
				}
				System.out.println("===========����������"+(i+1)+"���������=============");
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
