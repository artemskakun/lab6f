package com.labs.lab6.Server.Utils;

import com.labs.lab6.common.Data.StudyGroup;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * Class of main repository
 */

public class Repository {

    private Map<Integer, StudyGroup> repository;
    private Date initializationDate;

    public Repository() {
    }

    public Repository(Map<Integer, StudyGroup> listType) {
        repository = listType;
        initializationDate = new Date();
    }

    /**
     * @return Current list example of repository
     */
    public Map<Integer, StudyGroup> get() {
        return repository;
    }

    /**
     * @return size of repository
     */
    public int size() {
        return repository.size();
    }


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        Repository other = (Repository) otherObject;
        return repository.equals(other.repository) && initializationDate.equals(other.initializationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository, initializationDate);
    }

    @Override
    public String toString() {
        return "'Repository info'" +
                "\nType: " + repository.getClass().getName() +
                "\nSize: " + this.size() +
                "\nInitialization Date: " + initializationDate;
    }
}