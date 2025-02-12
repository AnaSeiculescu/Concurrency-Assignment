package org.example;

import java.util.Map;

public class FestivalStatisticsThread extends Thread {
	FestivalGate gate;

	public FestivalStatisticsThread (FestivalGate gate) {
		this.gate = gate;
	}

	@Override
	public void run() {
		while (gate.getTickets().size() < gate.getNumberOfAttendees()) {
			if (!gate.getTickets().isEmpty()) {
				System.out.println(gate.getTickets().size() + " people entered");

				for (Map.Entry<TicketType, Integer> entry : gate.getTicketCounts().entrySet()) {
					System.out.println(entry.getValue() + " people have " + entry.getKey() + " tickets");
				}

				try {
					sleep(5000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
