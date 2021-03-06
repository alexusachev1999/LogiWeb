package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.entity.City;
import ru.usachev.LogiWebProject.entity.Waypoint;

import javax.persistence.Query;
import java.util.List;

@Repository
public class WaypointDAOImpl implements WaypointDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Waypoint> getAllWaypoints() {
        Session session = sessionFactory.getCurrentSession();
        List<Waypoint> waypoints = session.createQuery("from Waypoint").getResultList();
        return waypoints;
    }

    @Override
    public void saveWaypoint(Waypoint waypoint) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Cargo where name=:cargoName");
        query.setParameter("cargoName", waypoint.getCargo().getName());
        Cargo cargo = (Cargo) query.getSingleResult();
        cargo.addWaypointToWaypoints(waypoint);


        Query query2 = session.createQuery("from City where name=:cityName ");
        query2.setParameter("cityName", waypoint.getCity().getName());
        City city = (City) query2.getSingleResult();
        city.addWaypointToWaypointList(waypoint);

        session.saveOrUpdate(waypoint);
    }

    @Override
    public Waypoint getWaypoint(int id) {
        Session session = sessionFactory.getCurrentSession();
        Waypoint waypoint = session.get(Waypoint.class, id);
        return waypoint;
    }

    @Override
    public void deleteWaypoint(int id) {
        Session session = sessionFactory.getCurrentSession();
        Waypoint waypoint = session.get(Waypoint.class, id);
        session.delete(waypoint);
    }
}
