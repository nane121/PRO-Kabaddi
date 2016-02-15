package com.mediaocean.prokabaddi.domain.common.impl;

import org.springframework.util.Assert;

import com.mediaocean.prokabaddi.domain.common.Team;
import com.mediaocean.prokabaddi.domain.common.TeamRepository;
import com.mediaocean.prokabaddi.domain.common.dal.TeamDao;

public class DefaultTeamRepository implements TeamRepository {
	
	private final TeamDao teamDao;
	
	public DefaultTeamRepository(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public Team fetch(int id) {
		// Fetch Team information from DAO
		Team team = teamDao.get(id);
		Assert.notNull(team, "Team does not exist for id -> "+id);
		
		return team;
	}

}
