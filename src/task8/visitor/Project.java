package task8.visitor;

public class Project implements ProjectElement{
    ProjectElement[] projectElements;

    public Project(){
        this.projectElements = new ProjectElement[]{
                new ProjectClass(),
                new Database(),
                new ProjectTests(),
        };
    }
    @Override
    public void accept(Developer developer) {
        for (ProjectElement projectElement : projectElements){
            projectElement.accept(developer);
        }
    }
}
