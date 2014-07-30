package per.kayu.test;
//java读取txt文件内容。可以作如下理解：
//1.
//首先获得一个文件句柄。File file = new File(); file即为文件句柄。两人之间连通电话网络了。接下来可以开始打电话了。
//
//2.
//通过这条线路读取甲方的信息：new FileInputStream(file) 目前这个信息已经读进来内存当中了。接下来需要解读成乙方可以理解的东西
//
//3.
//既然你使用了FileInputStream()。那么对应的需要使用InputStreamReader()这个方法进行解读刚才装进来内存当中的数据
//
//4.
//解读完成后要输出呀。那当然要转换成IO可以识别的数据呀。那就需要调用字节码读取的方法BufferedReader()。同时使用bufferedReader()的readline(）方法读取txt文件中的每一行数据哈。



import java.io.BufferedReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.InputStreamReader;

public class readTXTFile {

	/**
	 * 
	 * 功能：Java读取txt文件的内容
	 * 
	 * 步骤：1：先获得文件句柄
	 * 
	 * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 
	 * 3：读取到输入流后，需要读取生成字节流
	 * 
	 * 4：一行一行的输出。readline()。
	 * 
	 * 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 */

	public static void readTxtFile(String filePath) {

		try {

			String encoding = "UTF-8";

			File file = new File(filePath);

			if (file.isFile() && file.exists()) { // 判断文件是否存在

				InputStreamReader read = new InputStreamReader(

				new FileInputStream(file), encoding);// 考虑到编码格式

				BufferedReader bufferedReader = new BufferedReader(read);

				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {

					String str2 = updateFormat(lineTxt);
					System.out.println(str2);

				}

				read.close();

			} else {

				System.out.println("找不到指定的文件");

			}

		} catch (Exception e) {

			System.out.println("读取文件内容出错");

			e.printStackTrace();

		}

	}

	public static void main(String argv[]) {

		//String filePath = "L:\\Apache\\htdocs\\res\\20121012.txt";
		for(int i =25;i<=48;i++){
			String filePath = "E:\\share\\日语资料\\新标日默单词用\\mei\\"+Integer.toString(i)+".txt";
		
		
		
		// "res/";

		readTxtFile(filePath);
		}

	}
	
	/**
	 * 去掉日文部分，并在有汉字的词语前加上·
	 * 
	 * @param str
	 * @return
	 */
	public static String updateFormat(String str){
		int end_little = str.indexOf("）");
		int front_medial = str.indexOf("［");
		if(front_medial==-1){
			front_medial = str.indexOf("[");
		}
		if(end_little!=-1&&front_medial!=-1){
			//查到了小括号和中括号
			str = str.substring(front_medial);
			str =  "·" +str;
			return str;
		}else if(end_little!=-1&&front_medial==-1){
			//查到了小括号，却没有查到中括号
			str = str.substring(end_little+1);
			str =  "·" +str;
			return str;
		}else if(end_little==-1&&front_medial!=-1){
			//查到了中括号，却没有查到小括号
			str = str.substring(front_medial);
			return str;
		}else{
			return str;
		}
	}

}
