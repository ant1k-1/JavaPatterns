package task8.visitor;

public class ProjectTests implements ProjectElement{
    @Override
    public void accept(Developer developer) {
        developer.visit(this);
    }
}
