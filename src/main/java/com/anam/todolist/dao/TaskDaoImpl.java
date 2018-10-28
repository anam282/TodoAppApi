package com.anam.todolist.dao;

import com.anam.todolist.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao{

    private SessionFactory sessionFactory;

    @Autowired
    public TaskDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int save(Task task) {
        sessionFactory.getCurrentSession().save(task);
        return task.getId();
    }

    @Override
    public Task get(int id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public List<Task> list() {
        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Task> cq = cb.createQuery(Task.class);
//        Root<Task> root = cq.from(Task.class);
//        cq.select(root);
//        Query<Task> query = session.createQuery(cq);
        Query<Task> query = session.createNativeQuery("SELECT * FROM tasks", Task.class);
        return query.getResultList();
    }

    @Override
    public void update(int id, Task updatedTask) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.byId(Task.class).load(id);
        task.setDescription(updatedTask.getDescription());
        session.flush();
    }

    @Override
    public  void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.byId(Task.class).load(id);
        session.delete(task);
    }


}
