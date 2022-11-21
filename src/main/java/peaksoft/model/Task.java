package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100000, name = "task_name")
    private String taskName;

    @Column(length = 100000, name = "task_text")
    private String taskText;

    @Column(name = "dead_line")
    private Date deadLine;

    @ManyToOne(cascade = {MERGE,DETACH,REFRESH,PERSIST}, fetch = FetchType.EAGER)
    private Lesson lesson;
}
