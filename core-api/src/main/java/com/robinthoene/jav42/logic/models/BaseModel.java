package com.robinthoene.jav42.logic.models;

/**
 * Base model for database models.
 */
public abstract class BaseModel {

    /**
     * Retrieve the unique database identifier of the entity.
     *
     * @return The unique identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of the entities unique identifier.
     *
     * @param id The new value for the unique identifier.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * The unique identifier of the model in the database.
     */
    private long id;
}
