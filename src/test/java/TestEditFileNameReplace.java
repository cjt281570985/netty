import java.io.File;

public class TestEditFileNameReplace
{

    public static void main(String[] args)
    {
        //查找win文件
        File file = new File("H:\\study\\汪文君java\\汪文君Google Guava");
        //String newPath = "D:\\study\\李兴华Oracle";
        String delStr = "汪文君Google Guava ";
        editName(file, delStr, file.getAbsolutePath());

        String addName = "chenjt";
        // addFileName(file, ".avi", addName, newPath);
    }

    private static void editName(File file, String delStr, String newPath)
    {
        String name = file.getName();
        if(name.indexOf(delStr)!=-1)
        {
            //String newName = name.substring(regex.length());//截取_后面的String
            String newName=name.replace(delStr,"");
            file.renameTo(new File(newPath + "\\" + newName));
        }
        //检查子目录
        if(file.isDirectory())
        {
            for(File child : file.listFiles())
            {
                editName(child, delStr, newPath);
            }
        }
    }

    private static void addFileName(File file, String regex, String addName, String path)
    {
        String name = file.getName();
        if(name.endsWith(regex))
        {
            file.renameTo(new File(path + "\\" + addName + name));
        }
        //检查子目录
        if(file.isDirectory())
        {
            for(File child : file.listFiles())
            {
                addFileName(child, regex, addName, path);
            }
        }
    }
}
