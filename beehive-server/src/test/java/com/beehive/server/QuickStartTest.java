package com.beehive.server;


import com.beehive.model.entity.ProjectTask;
import com.beehive.model.mapper.ProjectTaskMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@MapperScan("com.beehive.model.mapper")
public class QuickStartTest {

    @Autowired
    private ProjectTaskMapper projectTaskMapper;
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void testSelect() {
        System.out.println(applicationContext.containsBean("sqlSessionFactory"));
        System.out.println(("----- selectAll method test ------"));
        ProjectTask task=new ProjectTask();
        task.setTaskName("555");
        projectTaskMapper.insert(task);
//        IPage page=new Page(2,5);
//        IPage<ProjectTask> projectTasks = projectTaskMapper.selectPage(page,Wrappers.query());
//        System.out.println(projectTasks.getRecords());
    }
}
