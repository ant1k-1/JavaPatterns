package task8.visitor;

public interface Developer {
    void visit(ProjectClass projectClass);
    void visit(Database database);
    void visit(ProjectTests projectTests);
}
