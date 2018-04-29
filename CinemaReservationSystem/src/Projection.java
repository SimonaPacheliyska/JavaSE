import java.time.LocalDateTime;

public class Projection {

	private Movie movie;
	private Hall hall;
	private LocalDateTime date;
	
	public Projection(Movie movie, Hall hall, LocalDateTime date) {
		this.movie = movie;
		this.hall = hall;
		this.date = date;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public LocalDateTime getData() {
		return date;
	}

	public void setData(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hall == null) ? 0 : hall.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projection other = (Projection) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hall == null) {
			if (other.hall != null)
				return false;
		} else if (!hall.equals(other.hall))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		return true;
	}
	
}
