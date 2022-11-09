package cn.tedu.boot01.entity;

public class Emp {
    private String name;
    private Integer salary;
    private String job;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
