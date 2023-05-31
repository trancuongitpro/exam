package manager;

public class Student {
    private String name;
    private int id;
    private double score;
    private String grade;

    public Student(int id, String name, double score, String grade) {
        super();
        this.id = id;
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
