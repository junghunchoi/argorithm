package java.study;

import java.util.*;

public class leet332 {

	Map<String, PriorityQueue<String>> targets = new HashMap<>();
	List<String> route = new LinkedList<>();

	public static void main(String[] args) {
		leet332 con = new leet332();

//		con.findItinerary()
	}

	public List<String> findItinerary(List<List<String>> tickets) {

		for (List<String> ticket : tickets) {
			targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
		}

		visit("JFK");

		return route;
	}

	private void visit(String airport) {
		while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
			visit(targets.get(airport).poll());
		}
		route.add(0, airport);
	}

}
