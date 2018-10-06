package ru.rikabc.generate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rikabc.generate.mappers.EventMapper;
import ru.rikabc.generate.model.Event;
import ru.rikabc.generate.util.PropertyReader;

import java.util.List;

/**
 * @author Roman Khayrullin on 14.09.2018
 * @version 1.0
 */
@Component
public class EventDao {

    @Autowired
    private JdbcTemplate template;

    public EventDao() {
    }

    public void testConnect() {
        String s = template.queryForObject("SELECT name FROM event LIMIT 1", String.class);
        System.out.println(s);
    }

    public List<Event> getFiveTasksByCentury(Integer century) {
        String query = PropertyReader.getQuery("sql.select.easy");
        List<Event> tasks = template.query(query, new Object[]{century}, new EventMapper());
        return tasks;
    }

    public List<Event > getMediumTasks(Integer century) {
        String query = PropertyReader.getQuery("sql.select.medium");
        List<Event> tasks = template.query(query, new Object[]{century}, new EventMapper());
        return tasks;
    }

    public List<Event > getHardTasks(Integer century) {
        String query = PropertyReader.getQuery("sql.select.hard");
        List<Event> tasks = template.query(query, new Object[]{century}, new EventMapper());
        return tasks;
    }
}
