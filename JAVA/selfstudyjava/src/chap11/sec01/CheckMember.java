package chap11.sec01;

//연습문제4
public class CheckMember {
    private String id;
    private String name;

    public CheckMember(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
