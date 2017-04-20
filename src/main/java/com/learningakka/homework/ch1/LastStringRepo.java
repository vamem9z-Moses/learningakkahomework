package com.learningakka.homework.ch1;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by mmiles on 4/19/17.
 */
public class LastStringRepo extends AbstractActor {
	protected String lastValue;

	private LastStringRepo() {
		receive(ReceiveBuilder.match(SaveString.class, message -> this.lastValue = message.Value()).build());
	}

	public void SetLastValue(String value) {
		this.lastValue = value;
	}
}