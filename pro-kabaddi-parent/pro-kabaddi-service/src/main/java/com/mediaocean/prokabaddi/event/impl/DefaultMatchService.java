package com.mediaocean.prokabaddi.event.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import com.mediaocean.prokabaddi.domain.common.Team;
import com.mediaocean.prokabaddi.domain.common.TeamRepository;
import com.mediaocean.prokabaddi.domain.event.Match;
import com.mediaocean.prokabaddi.domain.event.MatchScheduler;
import com.mediaocean.prokabaddi.event.MatchService;

public class DefaultMatchService implements MatchService {
	
	private final TeamRepository teamRepository;
	private final MatchScheduler matchScheduler;
	
	public DefaultMatchService(TeamRepository teamRepository, MatchScheduler matchScheduler) {
		this.teamRepository = teamRepository;
		this.matchScheduler = matchScheduler;
	}

	@Override
	public List<Match> generateSchedule(String teamIds, String startDate) {
		// Validation of query parameter
		Assert.notNull(teamIds, "teamIds Query Parameter is missing");
		Assert.notNull(startDate, "startDate Query Parameter is missing");
		
		// Split teamIds using comma
		String[] teamIdArray = StringUtils.split(teamIds, ",");
		
		// Format start date
		Date scheduleStartDate = parseDate(startDate);
		
		// Prepare temId list
		List<Team> teams = new ArrayList<Team>();
		for (String teamId : teamIdArray) {
			
			if (StringUtils.isNumeric(teamId)) {
				teams.add(teamRepository.fetch(Integer.valueOf(teamId)));
			} else {
				throw new RuntimeException("Team Id should be numeric");
			}
		}
		
		return matchScheduler.generate(teams, scheduleStartDate);
	}
	
	private Date parseDate(String startDate) {
		DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return dateFormatter.parse(startDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
