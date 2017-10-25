package ssy.io.decorator;


//具体构建角色 (FileOutputStream   节点流)
//定义一个将要接收附加责任的类
public class ConcreteComponent implements Component {

    @Override
    public void doSomethig() {
        System.out.println("功能A");
    }
}
