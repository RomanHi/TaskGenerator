package ru.rikabc.generate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rikabc.generate.dao.EventDao;
import ru.rikabc.generate.model.Event;
import ru.rikabc.generate.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Roman Khayrullin on 11.09.2018
 * @version 1.0
 */
@Service
public class TaskService {

    @Autowired
    EventDao dao;

    private static final String EASY = "easy";
    private static final String HARD = "hard";
    private static final String MEDIUM = "medium";

    public List<Task> getTasks(String level) {
        List<Task> tasks = new ArrayList<>(12);
        switch (level) {
            case EASY: {
                int randomFirstCentury = ThreadLocalRandom.current().nextInt(13, 14 + 1);
                List<Event> first = dao.getFiveTasksByCentury(randomFirstCentury);

                int randomSecondCentury = ThreadLocalRandom.current().nextInt(15, 17 + 1);
                List<Event> second = dao.getFiveTasksByCentury(randomSecondCentury);

                int randomThirdCentury = ThreadLocalRandom.current().nextInt(18, 20 + 1);
                List<Event> third = dao.getFiveTasksByCentury(randomThirdCentury);

                Collections.shuffle(first);
                Collections.shuffle(second);
                Collections.shuffle(third);

                for (int i = 0; i < first.size(); i++) {
                    Task task = new Task();
                    List<Event> events = new ArrayList<>(3);
                    StringBuilder builder = new StringBuilder();

                    Event f = first.get(i);
                    Event s = second.get(i);
                    Event th = third.get(i);

                    events.add(f);
                    events.add(s);
                    events.add(th);

                    Collections.shuffle(events);
                    int i1 = events.indexOf(f) + 1;
                    int i2 = events.indexOf(s) + 1;
                    int i3 = events.indexOf(th) + 1;

                    for (int j = 0; j < 3; j++) {
                        builder.append(j + 1)
                                .append(") ")
                                .append(events.get(j).getName())
                                .append("<br>");
                    }
                    task.setTask(builder.toString());
                    task.setResult(Integer.toString(i1) + Integer.toString(i2) + Integer.toString(i3));
                    task.setId(i);
                    tasks.add(task);
                }
                break;
            }
            case MEDIUM: {
                int randomFirstCentury = ThreadLocalRandom.current().nextInt(14, 19 + 1);
                List<Event> middle = dao.getMediumTasks(randomFirstCentury);

                List<Event> upper = dao.getMediumTasks(randomFirstCentury + 1);

                List<Event> lower = dao.getMediumTasks(randomFirstCentury - 1);

                Collections.shuffle(middle);
                Collections.shuffle(upper);
                Collections.shuffle(lower);

                for (int i = 0; i < lower.size(); i++) {
                    Task task = new Task();
                    List<Event> events = new ArrayList<>(3);
                    StringBuilder builder = new StringBuilder();

                    Event f = lower.get(i);
                    Event s = middle.get(i);
                    Event th = upper.get(i);

                    events.add(f);
                    events.add(s);
                    events.add(th);

                    Collections.shuffle(events);
                    int i1 = events.indexOf(f) + 1;
                    int i2 = events.indexOf(s) + 1;
                    int i3 = events.indexOf(th) + 1;

                    for (int j = 0; j < 3; j++) {
                        builder.append(j + 1)
                                .append(") ")
                                .append(events.get(j).getName())
                                .append("<br>");
                    }
                    task.setTask(builder.toString());
                    task.setResult(Integer.toString(i1) + Integer.toString(i2) + Integer.toString(i3));
                    task.setId(i);
                    tasks.add(task);
                }
                break;
            }
            case HARD: {
                int randomFirstCentury = ThreadLocalRandom.current().nextInt(19, 20 + 1);
                List<Event> hard = dao.getHardTasks(randomFirstCentury);
                List<Event> first;
                List<Event> second;
                List<Event> third;
                Collections.shuffle(hard);
                first = new ArrayList<>(hard.subList(0, 11));
                second = new ArrayList<>(hard.subList(12, 23));
                third = new ArrayList<>(hard.subList(24, 36));

                for (int i = 0; i < first.size(); i++) {
                    Task task = new Task();
                    List<Event> events = new ArrayList<>(3);
                    StringBuilder builder = new StringBuilder();

                    Event f = first.get(i);
                    Event s = second.get(i);
                    Event th = third.get(i);

                    events.add(f);
                    events.add(s);
                    events.add(th);

                    Collections.shuffle(events);
                    int i1 = events.indexOf(f) + 1;
                    int i2 = events.indexOf(s) + 1;
                    int i3 = events.indexOf(th) + 1;

                    for (int j = 0; j < 3; j++) {
                        builder.append(j + 1)
                                .append(") ")
                                .append(events.get(j).getName())
                                .append("<br>");
                    }
                    task.setTask(builder.toString());
                    task.setResult(Integer.toString(i1) + Integer.toString(i2) + Integer.toString(i3));
                    task.setId(i);
                    tasks.add(task);
                }
                break;
            }
        }

        return tasks;
    }

    public String checkResult(List<String> answer, List<String> result) {
        int counter = 0;
        for (int i = 0; i < result.size(); i++) {
            if (answer.get(i).equals(result.get(i))) {
                counter++;
            }
        }
        return "you result: " + counter + "/" + result.size();
    }
}
