package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100000, name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private Date dateOfStart;

    @Column(length = 100000, name = "image")
    private String image;

    @ManyToMany
    private List<Course> courses;

    public void addCourse(Course course){
        if (courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
    }

    @OneToMany(cascade = {ALL}, fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Student> students;

    public void addStudent(Student student){
        if (students==null){
            students=new ArrayList<>();
        }
        students.add(student);
    }

    @ManyToOne(cascade = {MERGE, PERSIST, DETACH, REFRESH}, fetch = FetchType.EAGER)
    private Company company;
}
