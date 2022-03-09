package hello.core.member;

//회원 엔티티
public class Member {
    //필드
    private Long id;
    private String name;
    private Grade grade;

    //생성자
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter, setter  -->이걸 통해 private 필드에 값을 세팅한다
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
