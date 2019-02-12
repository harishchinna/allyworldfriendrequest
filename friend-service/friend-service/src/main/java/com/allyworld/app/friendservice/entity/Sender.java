package com.allyworld.app.friendservice.entity;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitMessagingTemplate template;

	public void send(int senderId, int receiverId ,String actionType) {
		System.out.println(senderId + " " + receiverId);
		template.convertAndSend("mruduQ", new Object[] { senderId, receiverId ,actionType });
	}

	public void getAllFriendsByProfileId(int profileId) {
		template.convertAndSend("mruduQ", profileId);

	}

	public void acceptingFriendRequest(int senderId, int receiverId ,String actionType) {
		System.out.println(senderId + " " + receiverId);
		template.convertAndSend("mruduQ", new Object[] { senderId, receiverId, actionType});
	}

}
