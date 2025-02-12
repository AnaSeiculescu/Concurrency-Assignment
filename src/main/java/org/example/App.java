package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();

        for (int i = 0; i <= 10; i++) {
            gate.receiveAttendee();
        }

        System.out.println(gate.getTickets());
    }
}
