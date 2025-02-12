package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        gate.setNumberOfAttendees(100);

        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();

		for (int i = 0; i < gate.getNumberOfAttendees(); i++) {
            gate.receiveAttendee();
        }

    }
}
