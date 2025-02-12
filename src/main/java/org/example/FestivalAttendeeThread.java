package org.example;

import lombok.Getter;

@Getter
public class FestivalAttendeeThread extends Thread {
	private TicketType ticketType;
	private FestivalGate gate;

	public FestivalAttendeeThread(FestivalGate gate) {
		this.ticketType = gate.getRandomTicket();
		this.gate = gate;
	}

	@Override
	public void run() {
		gate.addTicket(ticketType);
		try {
			sleep(200);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
