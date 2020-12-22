package core;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUI implements ActionListener {

	JButton encryptButton;
	JButton decryptButton;
	JTextArea uldTextArea;
	JTextArea urdTextArea;
	JLabel uluLabel;
	JLabel uruLabel;
	JScrollPane uldScroll;
	JScrollPane urdScroll;

	public void addComponentToPane(Container pane) {

		JPanel u = new JPanel();
		JPanel d = new JPanel();
		JPanel ul = new JPanel(new BorderLayout());
		JPanel ur = new JPanel(new BorderLayout());

		uluLabel = new JLabel("plaintext:");
		uruLabel = new JLabel("ciphertext:");

		uldTextArea = new JTextArea("", 15, 25);
		urdTextArea = new JTextArea("", 15, 25);

		uldTextArea.setLineWrap(true);
		urdTextArea.setLineWrap(true);

		uldTextArea.getDocument().addDocumentListener(new MyDocumentListener());
		urdTextArea.getDocument().addDocumentListener(new MyDocumentListener());

		uldScroll = new JScrollPane(uldTextArea); 
		urdScroll = new JScrollPane(urdTextArea); 

		uldScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		urdScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		ul.add(uluLabel, BorderLayout.PAGE_START);
		ur.add(uruLabel, BorderLayout.PAGE_START);
		ul.add(uldScroll, BorderLayout.PAGE_END);
		ur.add(urdScroll, BorderLayout.PAGE_END);

		u.add(ul);
		u.add(ur);

		encryptButton = new JButton("Encrypt");
		decryptButton = new JButton("Decrypt");
		encryptButton.setActionCommand("encrypt");
		decryptButton.setActionCommand("decrypt");
		encryptButton.setEnabled(false);
		decryptButton.setEnabled(false);
		encryptButton.addActionListener(this);
		decryptButton.addActionListener(this);

		d.add(encryptButton);
		d.add(decryptButton);

		pane.add(u, BorderLayout.PAGE_START);
		pane.add(d, BorderLayout.PAGE_END);


	}

	public void actionPerformed(ActionEvent e) {
		if ( "encrypt".equals(e.getActionCommand()) )
		{
			urdTextArea.setText(Functions.encrypt(uldTextArea.getText()));
		}
		if ( "decrypt".equals(e.getActionCommand()) ) 
		{
			uldTextArea.setText(Functions.decrypt(urdTextArea.getText()));
		}
	} 


	class MyDocumentListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e)
		{
			if ( uldTextArea.getText().isEmpty() )
			{ encryptButton.setEnabled(false); }
			else
			{ encryptButton.setEnabled(true); }
			
			if ( urdTextArea.getText().isEmpty() )
			{ decryptButton.setEnabled(false); }
			else
			{ decryptButton.setEnabled(true); }
		}
		public void removeUpdate(DocumentEvent e)
		{
			insertUpdate(e);
		}
		public void changedUpdate(DocumentEvent e) {}
		public void updateLog(DocumentEvent e, String action) {}
	}



}