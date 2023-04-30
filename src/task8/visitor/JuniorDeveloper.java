package task8.visitor;

public class JuniorDeveloper implements Developer{
    @Override
    public void visit(ProjectClass projectClass) {
        System.out.println("Джун написал класс");
    }

    @Override
    public void visit(Database database) {
        System.out.println("Джун уронил базу данных");
    }

    @Override
    public void visit(ProjectTests projectTests) {
        System.out.println("Джун написал тесты");
    }
}
