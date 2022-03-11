package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;
    private static final String DESCRPTION = "Test: Learn Hibernate";

    @Test
    void testTaskDaoSave() {
        Task task = new Task(DESCRPTION, 7);
        taskDao.save(task);
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());

        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration() {
        Task task = new Task(DESCRPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();
        List<Task> readTasks = taskDao.findByDuration(duration);
        Assertions.assertEquals(4, readTasks.size());
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }
}