package org.main.service;

import org.main.dao.TeamDAO;
import org.main.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamServiceImpl {

    @Autowired
    private TeamDAO teamDAO;

    public void addTeam(Team team) {
        teamDAO.addTeam(team);
    }

    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);
    }

    public Team getTeam(int id) {
        return teamDAO.getTeam(id);
    }

    public void deleteTeam(int id) {
        teamDAO.deleteTeam(id);
    }

    public List<Team> getTeams() {
        return teamDAO.getTeams();
    }

}
