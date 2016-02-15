package com.mediaocean.prokabaddi.domain.common.dal.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mediaocean.prokabaddi.domain.common.Team;
import com.mediaocean.prokabaddi.domain.common.dal.TeamDao;

public class DefaultTeamDao implements TeamDao {
	
	private Map<Integer, Team> teamMap = new ConcurrentHashMap<Integer, Team>();
	
	public DefaultTeamDao() {
		initializeTeam();
	}
	
	// TODO : As soon as DB supports get added below method should get removed
	private void initializeTeam() {
		teamMap.put(1, prepareTeam(1, "Pune - Warrior", "Pune - Warrior - Description", "Pune"));
		teamMap.put(2, prepareTeam(2, "Mumbai - Maratha", "Mumbai - Maratha - Description", "Mumbai"));
		teamMap.put(3, prepareTeam(3, "Delhi - Devill", "Delhi - Devill - Description", "Delhi"));
		teamMap.put(4, prepareTeam(4, "Chandigadh - King", "Chandigadh - King - Description", "Chandigadh"));
		teamMap.put(5, prepareTeam(5, "Patna - Bihari", "Patna - Bihari - Description", "Patna"));
	}
	
	private Team prepareTeam(int id, String name, String description, String city) {
		Team team = new Team(id);
		team.setName(name);
		team.setDescription(description);
		team.setCity(city);
		
		return team;
	}

	@Override
	public Team get(int id) {
		// TODO : As soon as DB supports get added team information should get fetched from DB i.e. TEAM
		return teamMap.get(id);
	}

}
