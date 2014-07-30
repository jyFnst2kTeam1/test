package per.kayu.test;

import java.io.File;

public class ReadFile {
    public static void main(String args[]) {
        File allFile = new File("C:\\Users\\jy_zhoudf\\Desktop\\case");
//        allFile.getName();
//        if (allFile.getName().compareTo("066") > 0 && allFile.getName().compareTo("100") < 0) {
//            File newFile = new File(allFile.getAbsolutePath());
//            newFile.renameTo(new File("0" + String.valueOf(Integer.parseInt(newFile.getName()) + 1)));
//        }
        File[] fs = allFile.listFiles();
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i].getAbsolutePath());
            if (fs[i].isDirectory()) {
                if (fs[i].getName().compareTo("066") > 0 && fs[i].getName().compareTo("100") < 0) {
                    File[] fs2 = fs[i].listFiles();
                    fs2[0].getAbsolutePath();
                    File newFile = new File(fs2[0].getAbsolutePath());
                  fs2[0].renameTo(new File("0" + String.valueOf(Integer.parseInt(newFile.getName().substring(0,3)) + 1)+".xlsx"));
              }
            }
        }
    }

}
