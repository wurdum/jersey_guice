package org.wurdum.models;

import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Property;
import com.github.jmkgreen.morphia.annotations.Version;
import org.bson.types.ObjectId;

public abstract class AbstractEntity {

    @Id
    @Property("id")
    private ObjectId id;

    @Version
    @Property("version")
    private Long version;

    public ObjectId getId() {
        return this.id;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
