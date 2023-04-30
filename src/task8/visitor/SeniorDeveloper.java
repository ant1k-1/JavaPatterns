package task8.visitor;

public class SeniorDeveloper implements Developer{
    @Override
    public void visit(ProjectClass projectClass) {
        System.out.println("Сеньор оптимизировал класс");
    }

    @Override
    public void visit(Database database) {
        System.out.println("Сеньор поднял базу данных");
    }

    @Override
    public void visit(ProjectTests projectTests) {
        System.out.println("Сеньор написал тесты с 100% покрытием");
    }
}
