package sample;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements ResultSetMapper<Person> {
    public Person map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Person p = new Person();
        p.setId(r.getInt("id"));
        p.setName(r.getString("name"));
        p.setLastname(r.getString("lastname"));
        return p;
    }
}