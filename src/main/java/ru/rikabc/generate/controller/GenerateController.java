package ru.rikabc.generate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rikabc.generate.model.Result;
import ru.rikabc.generate.model.Task;
import ru.rikabc.generate.service.TaskService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Khayrullin on 11.09.2018
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class GenerateController {

    private List<String> res = new ArrayList<>(12);

    @Autowired
    private TaskService service;

    @RequestMapping("/index")
    public String initGenerator() {
        return "index";
    }

    @GetMapping(value = "/task")
    public String tasks(@RequestParam String level, Model model) {
        List<Task> tasks = service.getTasks(level);
        for (Task task : tasks) {
            res.add(task.getResult());
        }
        model.addAttribute("tasks",tasks);
        return "task";
    }

    @PostMapping("/result")
    public String result(@RequestParam("param") List<String> result,Model model) {
        System.out.println(result);
        String finalResult = service.checkResult(res,result);
        model.addAttribute("result", finalResult);
        res.clear();
        return "result";
    }
}
