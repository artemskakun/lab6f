package com.labs.lab6.common.Data;

import java.io.Serializable;
import java.util.Date;

public class StudyGroup implements Comparable<StudyGroup>, Serializable {

    private static long counter = 0;

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final long studentsCount; //Значение поля должно быть больше 0
    private final Integer expelledStudents; //Значение поля должно быть больше 0, Поле не может быть null
    private final FormOfEducation formOfEducation; //Поле не может быть null
    private final Semester semesterEnum; //Поле может быть null
    private final Person groupAdmin; //Поле не может быть null

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private Integer key = null;

    public StudyGroup(String name, Coordinates coordinates, long studentsCount,
                      Integer expelledStudents, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.id = ++counter;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.studentsCount = studentsCount;
        this.expelledStudents = expelledStudents;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;

    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long x) {
        counter = x;
    }

    /**
     * @return ID of the group.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name of the group.
     */
    public String getName() {
        return name;
    }

    /**
     * @return coordinates of the group.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return creation date of the group.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @return quantity students of the group.
     */
    public long getStudentsCount() {
        return studentsCount;
    }

    /**
     * @return quantity expelled students of the group.
     */
    public Integer getExpelledStudents() {
        return expelledStudents;
    }

    /**
     * @return form of education of the group.
     */
    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    /**
     * @return semester of the group.
     */
    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    /**
     * @return group admid.
     */
    public Person getGroupAdmin() {
        return groupAdmin;
    }

    // Compare by name
    @Override
    public int compareTo(StudyGroup studyGroupObj) {
        return name.compareTo(studyGroupObj.getName());
    }

    @Override
    public String toString() {
        return "StudyGroup | key=" + key + " {\n" +
                " id=" + id + '\n' +
                " name=" + name + '\n' +
                " coordinates=" + coordinates + '\n' +
                " creationDate=" + creationDate + '\n' +
                " studentsCount=" + studentsCount + '\n' +
                " expelledStudents=" + expelledStudents + '\n' +
                " formOfEducation=" + formOfEducation + '\n' +
                " semesterEnum=" + semesterEnum + '\n' +
                " groupAdmin=" + groupAdmin + '\n' +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode() + coordinates.hashCode() + groupAdmin.hashCode() + semesterEnum.hashCode() +
                formOfEducation.hashCode() + expelledStudents.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof StudyGroup) {
            StudyGroup studyGroupObj = (StudyGroup) obj;
            return false;
        }
        return false;
    }

}
