package lyons.exp;

import org.apache.log4j.Logger;


/*** 
* <p>Title标题:异常</p>
* <p>Description描述: 测试log4j</p>
* <p>Company公司: scorpio_cc</p> 
* @author 
* @date 
*/
public class Exp {
	private static Logger logger= Logger.getLogger(Exp.class);
	
	public static void main(String[] args) {
		System.out.println("This is println message.");
		String a = new String("ASC123scs");
		String b = a.toLowerCase(); //全转小写   toUpperCase 大写
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.error("This is error message");
	}
	
	
}
