package task8.visitor;

public class Main {
    public static void main(String[] args) {
        Project project = new Project();

        Developer junior = new JuniorDeveloper();
        Developer senior = new SeniorDeveloper();

        System.out.println("Джун в работе (посещает проект)");
        project.accept(junior);
        System.out.println("===============================");
        System.out.println("Сеньор в работе (посещает проект)");
        project.accept(senior);
    }
}
