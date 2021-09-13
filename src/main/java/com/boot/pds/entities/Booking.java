package com.boot.pds.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bookings database table.
 * 
 */
@Entity
@Table(name="bookings")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="id_movies")
	private Movie movie;

	//bi-directional many-to-one association to Showtime
	@ManyToOne
	@JoinColumn(name="id_showtimes")
	private Showtime showtime;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_users")
	private User user;

	public Booking() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Showtime getShowtime() {
		return this.showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}