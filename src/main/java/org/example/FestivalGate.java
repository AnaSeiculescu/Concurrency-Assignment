package org.example;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

@Getter
public class FestivalGate {
	private Queue<TicketType> tickets = new ConcurrentLinkedDeque<>();

	public void receiveAttendee() {
		FestivalAttendeeThread attendee = new FestivalAttendeeThread(this);
		attendee.start();
	}

	public TicketType getRandomTicket() {
		int randomNumber = new Random().nextInt(TicketType.values().length);
		return TicketType.values()[randomNumber];
	}

	public void addTicket(TicketType ticketType) {
		tickets.add(ticketType);
		System.out.println("Ticket validated: " + ticketType);
	}
}
