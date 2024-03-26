package com.example.raj.cool;

import org.springframework.stereotype.Component;

@Component
public class Engine {

public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
private String engine ="va";
private int cc=2000;
}

