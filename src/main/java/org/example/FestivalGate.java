package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

@Getter
@Setter
public class FestivalGate {
	private Queue<TicketType> tickets = new ConcurrentLinkedDeque<>();
	private Map<TicketType, Integer> ticketCounts = new HashMap<>();
	private int numberOfAttendees;

	public void receiveAttendee() {
		FestivalAttendeeThread attendee = new FestivalAttendeeThread(this);
		attendee.start();
		try {
			attendee.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public TicketType getRandomTicket() {
		int randomNumber = new Random().nextInt(TicketType.values().length);
		return TicketType.values()[randomNumber];
	}

	public void addTicket(TicketType ticketType) {
		tickets.add(ticketType);
		if (ticketCounts.containsKey(ticketType)) {
			ticketCounts.put(ticketType, ticketCounts.get(ticketType) + 1);
		} else {
			ticketCounts.put(ticketType, 1);
		}
//		System.out.println("Ticket validated: " + ticketType);
	}
}
