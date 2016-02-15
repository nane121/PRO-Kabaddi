package com.mediaocean.prokabaddi.domain.event;

import java.util.Date;

import com.mediaocean.prokabaddi.domain.common.Team;

public class Match {

	private final Team teamA;
	private final Team teamB;
	private String location;
	private Date date;

	public Match(Team teamA, Team teamB) {
		this.teamA = teamA;
		this.teamB = teamB;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Team getTeamA() {
		return teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [teamA=");
		builder.append(teamA);
		builder.append(", teamB=");
		builder.append(teamB);
		builder.append(", location=");
		builder.append(location);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

}
