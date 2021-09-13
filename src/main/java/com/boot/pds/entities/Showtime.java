package com.boot.pds.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the showtimes database table.
 * 
 */
@Entity
@Table(name="showtimes")
@NamedQuery(name="Showtime.findAll", query="SELECT s FROM Showtime s")
public class Showtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="showtime")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="id_movies")
	private Movie movie;

	public Showtime() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setShowtime(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setShowtime(null);

		return booking;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}