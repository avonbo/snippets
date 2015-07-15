package avonbo.snippets.java.ruleengine.simplerules;

public class Person {

    int age;

    String name;

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [age=" + this.age + ", name=" + this.name + "]";
    }

}
