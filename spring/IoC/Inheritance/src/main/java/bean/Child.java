package bean;

public class Child extends Person {
    private Adult parent;

    Child(){

    }

    public Adult getParent() {
        return parent;
    }

    public void setParent(Adult parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Child{" +
                "parent=" + parent +
                '}';
    }
}
