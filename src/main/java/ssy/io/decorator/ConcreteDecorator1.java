package ssy.io.decorator;

//具体装饰角色(FilterInputStream等子类)
//负责给构建对象(Component) "贴上" 附加的责任体
public class ConcreteDecorator1 extends Decorator {


    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomethig() {
        super.doSomethig();

        this.doAnotherThing();
    }

    private void doAnotherThing(){
        System.out.println("功能B");
    }
}
