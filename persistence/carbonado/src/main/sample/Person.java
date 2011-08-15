package sample;

import com.amazon.carbonado.PrimaryKey;
import com.amazon.carbonado.Storable;

@PrimaryKey("id")
public abstract class Person implements Storable {
    public abstract int getId();
    public abstract void setId(int id);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getLastName();
    public abstract void setLastName(String lastName);
}
