package ru.rikabc.generate.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.rikabc.generate.model.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Roman Khayrullin on 20.09.2018
 * @version 1.0
 */
public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();

        event.setCentury(rs.getInt("century"));
        event.setName(rs.getString("name"));
        event.setYear(rs.getInt("year"));

        return event;
    }
}
