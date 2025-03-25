package com.valtech.training.registerservice.vos;
 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
 
import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
 
public record SubscriptionVO(long id,int amount,String subscriptionStart,String subscriptionEnd,List<Long> userIds) {
 
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from(Subscription s) {
		List<Long> userIds = s.getUsers().stream().map(u -> u.getId()).collect(Collectors.toList());
		
		return new SubscriptionVO(s.getId(), s.getAmount(),
				s.getSubscriptionStart().format(FORMATTER), s.getSubscriptionEnd().format(FORMATTER),userIds);
	}
	
	public Subscription to(List<User> u) {
		LocalDate start= LocalDate.parse(subscriptionStart, FORMATTER);
		LocalDate end= LocalDate.parse(subscriptionEnd, FORMATTER);
		Subscription sc = new Subscription(id,amount, start, end);
		sc.setUsers(u);
		return sc;
	}
}
 
 