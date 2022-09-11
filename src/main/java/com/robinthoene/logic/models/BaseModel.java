package com.robinthoene.logic.models;

/**
 * Base model for database models.
 */
public abstract class BaseModel {

    /**
     * Default constructor.
     *
     * @param id The initial value of the models unique database identifier.
     */
    public BaseModel(long id) {
        this.id = id;
    }

    /**
     * Retrieve the current value of the database identifier.
     *
     * @return The unique identifier of the model.
     */
    public long getId() {
        return id;
    }

    /**
     * The unique identifier of the model in the database.
     */
    private long id;
}
