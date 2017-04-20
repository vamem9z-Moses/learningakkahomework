package com.learningakka.homework.ch1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;

public class LastStringRepoTest {
	ActorSystem system = ActorSystem.create();

	@Test
	public void itShouldStoreTheMessageSent() {
		TestActorRef<LastStringRepo> actorRef = TestActorRef.create(system, Props.create(LastStringRepo.class));
		actorRef.tell(new SaveString("This is my message"), ActorRef.noSender());

		LastStringRepo repo = actorRef.underlyingActor();
		assertEquals(repo.lastValue, "This is my message");
	}

	@Test
	public void itShouldStoreTheLastMessageSent() {
		TestActorRef<LastStringRepo> actorRef = TestActorRef.create(system, Props.create(LastStringRepo.class));
		actorRef.tell(new SaveString("This is my message"), ActorRef.noSender());
		actorRef.tell(new SaveString("This is my second message"), ActorRef.noSender());

		LastStringRepo repo = actorRef.underlyingActor();
		assertEquals(repo.lastValue, "This is my second message");
	}
}
