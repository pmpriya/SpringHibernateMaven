package org.main.dao;

import org.main.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addTeam(Team team) {
        getCurrentSession().save(team);
    }

    public void updateTeam(Team team) {
        Team teamToUpdate = getTeam(team.getId());
        teamToUpdate.setName(team.getName());
        teamToUpdate.setRating(team.getRating());
        getCurrentSession().update(teamToUpdate);
    }

    public Team getTeam(int id) {
        return getCurrentSession().get(Team.class, id);
    }

    public void deleteTeam(int id) {
        Team team = getTeam(id);
        if (team != null) {
            getCurrentSession().delete(team);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Team> getTeams() {
        return getCurrentSession().createQuery("from Team").list();
    }
}
