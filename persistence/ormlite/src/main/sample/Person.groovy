package sample

import com.j256.ormlite.table.DatabaseTable
import com.j256.ormlite.field.DatabaseField

@DatabaseTable(tableName = 'people')
class Person {
    @DatabaseField(id = true) int id
    @DatabaseField String name
    @DatabaseField String lastname
}
