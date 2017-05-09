package com.wei.stat.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.wei.stat.harder.SAXParseHandler;

public class SAXTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取一个SAXParserFactory的实例
		SAXParserFactory factory =SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			SAXParseHandler handler = new SAXParseHandler();
				parser.parse("books.xml", handler);
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
