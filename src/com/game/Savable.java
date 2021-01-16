package com.game;
import java.util.List;

public interface Savable {
	List<String> save();
	void load( List<String> l );
}
