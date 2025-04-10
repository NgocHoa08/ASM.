
package ASM;

public class Student {
    private int id;
    private String name;
    private Double mark;
    
    public Student(int id, String name, double mark) {
        this.id = id; 
        this.name = name; 
        this.mark = mark;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public String getRanks() {
        if (mark < 5.0) return "Fail"; 
        else if (mark < 6.5) return "Medium"; 
        else if (mark < 7.5) return "Good"; 
        else if (mark < 9.0) return "Very Good"; 
        else return "Excellent"; 
    }


    public String toString() {
        return "Student{" + "ID:" + id + ", Name:" + name + ", Mark:" + mark + ", Rank:" + getRanks() + '}';
    } 
}
