package org.object.xml.main.wish;

import org.object.xml.wish.Wish;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class MainApp {
     /*
      * Here in this MainApp class we are creating Object for our IOC container to read config file
      * and create object and manages the object of our classes and dependencies.
      */
	public static void main(String[] args) {
		
		Resource resource=null;
		BeanFactory factory=null;
		/*
		 * Locates and load the Spring bean Configuration file from the specified location of the file 
		 * System and keep it in ready State.
		 */
		resource=new FileSystemResource("src/main/java/org/object/xml/config/wish/applicationContext.xml");
		/*
		 * XmlBeanFactory is implementation class of BeanFactory(i) which is deprecated 
		 * once the resource object assign to Container .The Container reads the file and checks
		 * weather the given file properly well-form and valid or not
		 * 
		 *    1.Is it satisfied with spring given syntaxes then it is well formed
		 *    1.IF its satisfied with XSD and DTD the it is valid
		 *    
		 *    The load the class and crate the object for classes that specified in Spring Configuration File
		 */
		factory=new XmlBeanFactory(resource);
		
		/*
		 * Here getBean(-) return's the object 
		 */
		Wish wish=factory.getBean("wish",Wish.class);
	          System.out.println(wish +"Hello");
	

	}

}
