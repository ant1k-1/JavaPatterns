package task8.visitor;

public class ProjectClass implements ProjectElement{

    @Override
    public void accept(Developer developer) {
        developer.visit(this);
    }
}
