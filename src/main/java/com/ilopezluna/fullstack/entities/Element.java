package com.ilopezluna.fullstack.entities;

import java.util.HashSet;
import java.util.Set;

public class Element extends Basic
{
	public static final String COLLECTION_NAME = "elements";

	private int rank;
	private double price;
	private int demanded;
	private Set<User> voters = new HashSet<User>();

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDemanded() {
		return demanded;
	}

	public void setDemanded(int demanded) {
		this.demanded = demanded;
	}

	public Set<User> getVoters() {
		return voters;
	}

	public void addVoter(User user)
	{
		voters.add(user);
	}

	public boolean hasVoted(User user) {
		return voters.contains(user);
	}

	public int getVotes() {
		return voters.size();
	}
}
