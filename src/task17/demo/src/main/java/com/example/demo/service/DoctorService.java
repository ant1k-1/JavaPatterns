package com.example.demo.service;

import com.example.demo.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService{
    @PersistenceContext
    private EntityManager entityManager;
    private Session session;

    @Transactional
    public void create(Doctor doctor) {
        session = entityManager.unwrap(Session.class);
        session.persist(doctor);
        session.close();
    }

    public List<Doctor> readAll() {
        session = entityManager.unwrap(Session.class);
        List<Doctor> doctors = session.createQuery("select i from Doctor i", Doctor.class)
                .getResultList();
        session.close();
        return doctors;
    }

    public Doctor read(Long id) {
        session = entityManager.unwrap(Session.class);
        Doctor doctor = session.createQuery(
                "from Doctor where id = :id", Doctor.class)
                .setParameter("id", id)
                .getSingleResult();
        session.close();
        return doctor;
    }

    @Transactional
    public Boolean update(Doctor o, Long id) {
        session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Doctor set firstName=:fn, lastName=:ln, position=:p where id=:id")
                .setParameter("id", id)
                .setParameter("fn", o.getFirstName())
                .setParameter("ln", o.getLastName())
                .setParameter("p", o.getPosition());
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Transactional
    public Boolean delete(Long id) {
        session = entityManager.unwrap(Session.class);
        Doctor doctor = session.get(Doctor.class, id);
        session.remove(doctor);
        session.close();
        return true;
    }
    public <T> List<Doctor> getDoctorsFilteredBy(String attribute, T value){
        session = entityManager.unwrap(Session.class);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = cb.createQuery(Doctor.class);
        Root<Doctor> root = query.from(Doctor.class);
        Predicate predicate = cb.equal(root.get(attribute), value);

        query.select(root).where(predicate);

        return session.createQuery(query).getResultList();
    }
}
