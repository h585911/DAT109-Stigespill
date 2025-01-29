package no.hvl.dat109.utils;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InputListener implements DocumentListener {
	
	private Runnable onChange;

	public InputListener(Runnable onChange) {
		this.onChange = onChange;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		onChange.run();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		onChange.run();
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		onChange.run();
	}
}