package task8.visitor;

public class Database implements ProjectElement{
    @Override
    public void accept(Developer developer) {
        developer.visit(this);
    }
}
