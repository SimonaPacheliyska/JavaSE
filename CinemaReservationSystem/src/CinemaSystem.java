import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CinemaSystem implements CinemaReservationSystem {

	private Map<Movie, List<Projection>> cinemaProgram;
	private Map<Projection,List<Ticket>> ticketList;
	
	public CinemaSystem(Map<Movie, List<Projection>> cinemaProgram) {
		this.cinemaProgram = cinemaProgram;
	}
	
	@Override
	public void bookTicket(Ticket ticket) throws AlreadyReservedException, ProjectionNotFoundException,
			InvalidSeatException, ExpiredProjectionException {
		for(Map.Entry<Movie, List<Projection>> pr : cinemaProgram.entrySet()){
			if(pr.getValue().contains(ticket.getProjection())) {
				if(!ticketList.containsKey(ticket.getProjection())){
						throw new ProjectionNotFoundException();
					}
					for(Map.Entry<Projection, List<Ticket>> list : ticketList.entrySet()) {
						if(list.getKey().equals(ticket.getProjection())){
							if(!list.getKey().getData().isAfter(LocalDateTime.now())){
								throw new ExpiredProjectionException();
							}
							if(list.getValue().contains(ticket)) {
								throw new AlreadyReservedException();
							}
							if(!list.getKey().getHall().getRowSeats().containsKey(ticket.getSeat())) {
								throw new InvalidSeatException();
							}
							if(list.getKey().getHall().getRowSeats().get(ticket.getSeat())) {
								list.getValue().add(ticket);
								return;
							}
						}
					}
			}
		}
	}

	@Override
	public void cancelTicket(Ticket ticket) throws ReservationNotFoundException, ProjectionNotFoundException {
		for(Map.Entry<Movie, List<Projection>> entry : cinemaProgram.entrySet()) {
			if(entry.getValue().contains(ticket.getProjection())) {
				if(!ticketList.containsKey(ticket.getProjection())) {
					throw new ProjectionNotFoundException();
				}
				for(Ticket t : ticketList.get(ticket.getProjection())) {
					if(t.equals(ticket)) {
						ticketList.remove(ticket.getProjection(), ticket);
						return;
					}
				}
			}
		}
		throw new ReservationNotFoundException();
	}

	@Override
	public int getFreeSeats(Projection projection) throws ProjectionNotFoundException {
		for(Map.Entry<Movie, List<Projection>> entry : cinemaProgram.entrySet()) {
			if(entry.getValue().contains(projection)) {
				for(Projection p : entry.getValue()) {
					if(p.equals(projection)) {
						int free = 0;
						for(Map.Entry<Seat, Boolean> e : p.getHall().getRowSeats().entrySet()) {
							if(e.getValue()==true) {
								free++;
							}
						}
						return free;
					}
				}
			}
		}
		throw new ProjectionNotFoundException();
	}

	@Override
	public Collection<Movie> getSortedMoviesByGenre() {
		List<Movie> mov = new LinkedList<>(this.cinemaProgram.keySet());
		mov.sort(new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getGenre().compareTo(o2.getGenre());
			}
		});
		return mov;
	}
	
	
}
