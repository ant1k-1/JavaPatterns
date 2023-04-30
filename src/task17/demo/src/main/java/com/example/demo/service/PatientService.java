package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PatientService{
    @PersistenceContext
    private EntityManager entityManager;
    private Session session = null;

    @Autowired
    DoctorService doctorService;
    @Transactional
    public void create(Patient patient) {
        session = entityManager.unwrap(Session.class);
        session.persist(patient);
    }

    public List<Patient> readAll() {
        session = entityManager.unwrap(Session.class);
        List<Patient> patients = session.createQuery("select i from Patient i", Patient.class).getResultList();
        session.close();
        return patients;
    }

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
    public Boolean delete(Long id) {
        session = entityManager.unwrap(Session.class);
        Patient patient = session.get(Patient.class, id);
        session.remove(patient);
        return true;
    }

    public <T> List<Patient> getPatientsFilteredBy(String attribute, T value){
        session = entityManager.unwrap(Session.class);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Patient> query = cb.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);
        Predicate predicate = cb.equal(root.get(attribute), value);

        query.select(root).where(predicate);

        return session.createQuery(query).getResultList();
    }
}
