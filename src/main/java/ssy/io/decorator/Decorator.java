package ssy.io.decorator;

//装饰角色 (FilterInputStream,  FilterOutputStream)
//实现某接口并持有该接口的引用
//持有一个构建对象(Component)的引用, 并定义一个与抽象构建接口一致的接口
public class Decorator implements Component {


    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomethig() {
        component.doSomethig();
    }
}
