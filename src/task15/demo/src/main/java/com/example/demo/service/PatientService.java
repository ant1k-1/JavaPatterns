package com.example.demo.service;

import com.example.demo.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PatientService implements TableService<Patient>{
    @PersistenceContext
    private EntityManager entityManager;
    private Session session = null;
    @Transactional
    @Override
    public void create(Patient patient) {
        session = entityManager.unwrap(Session.class);
        session.persist(patient);
    }

    @Override
    public List<Patient> readAll() {
        session = entityManager.unwrap(Session.class);
        List<Patient> patients = session.createQuery("select i from Patient i", Patient.class).getResultList();
        session.close();
        return patients;
    }

    @Override
    public Patient read(Long id) {
        session = entityManager.unwrap(Session.class);
        Patient patient = session.createQuery(
                        "from Patient where id = :id", Patient.class)
                .setParameter("id", id)
                .getSingleResult();
        session.close();
        return patient;
    }

    @Transactional
    @Override
    public Boolean update(Patient patient, Long id) {
        session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Patient set firstName=:fn, lastName=:ln where id=:id")
                .setParameter("id", id)
                .setParameter("fn", patient.getFirstName())
                .setParameter("ln", patient.getLastName());
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return true;
    }
    @Transactional
    @Override
    public Boolean delete(Long id) {
        session = entityManager.unwrap(Session.class);
        Patient patient = session.get(Patient.class, id);
        session.remove(patient);
        return true;
    }
}
