import java.io.File;
import java.util.Arrays;

public class TestDeleteCompareFile {

  public static void main(String[] args) {
    //查找win文件
    File file1Main = new File("E:\\MP3\\qqmusic\\201805");
    File file2Del = new File("H:\\QQ音乐");

    remove(file1Main, file2Del);
  }

  private static void remove(File file1, File file2) {
    File[] list1 = file1.listFiles();
    File[] list2 = file2.listFiles();

    int count = 0;
    for (File f2 : list2) {
      boolean match = Arrays.stream(list1).allMatch(f1 -> !f1.getName().equals(f2.getName()));
      if (match) {
        System.out.println("删除: " + f2.getName());
        f2.delete();
        count++;
      }
    }
    System.out.println("共删除 " + count + " 个文件!");
  }

}
