package sample;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PersonMapper.class)
public interface PersonDAO {
    @SqlQuery("select * from people")
    List<Person> list();

    @SqlQuery("select id, name, lastname from people where id = :id")
    Person findById(@Bind("id") int id);

    @SqlUpdate("insert into people (id, name, lastname) values (:id, :name, :lastname)")
    void create(@Bind("id") int id, @Bind("name") String name, @Bind("lastname") String lastname);

    void close();
}