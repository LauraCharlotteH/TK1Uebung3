package com.group20.clientSOAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.group20.ws.*;

import hallsetup.Seat;
import hallsetup.Seat.Status;
import hallsetup.Seat.TypeOfSeat;
import database.DataBase;

public class ticketClientSOAP extends JFrame implements ActionListener {

	private JPanel background = new JPanel();
	private JTextArea welcome = new JTextArea();
	private JPanel selection = new JPanel(new GridLayout(1, 0));
	ButtonGroup days = new ButtonGroup();
	ButtonGroup times = new ButtonGroup();
	ButtonGroup movies = new ButtonGroup();
	static ServiceEndpointInterface sei;
	Seat[][] seats;
	String movie;
	String day;
	String time;
	JButton goOn;

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8090/ws/tickets?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.group20.com/",
				"ServiceEndpointImplService");

		Service service = Service.create(url, qname);

		sei = service.getPort(ServiceEndpointInterface.class);

		System.out.println(sei.getBigHallDescr());
		new ticketClientSOAP();

	}

	public ticketClientSOAP() {
		this.setLocationRelativeTo(null);
		this.setTitle("Group 20 ticket system"); // Set Title of Main Window
		setSize(775, 480); // Set frame to [x,y] pixels
		setResizable(false); // fix frame size
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));

		welcome.setText("Welcome to our ticket booking system. Please select a day time and the movie you would like to watch below and klick ok. You will then be enabld to choose and reserve seats");
		setTextAreaToLabelstyle(welcome);
		background.add(welcome);

		makeSelections();

		goOn = new JButton("continue");
		goOn.addActionListener(new ContinueListener());
		background.add(goOn);
		background.setVisible(true);

		this.getContentPane().add(background);
		this.setVisible(true);
	}

	// on click to continue button
	// has to be in here to access all the stuff
	class ContinueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			day = getSelectedButtonText(days);
			movie = getSelectedButtonText(movies);
			time = getSelectedButtonText(times);

			System.out.println("Day: " + day + " Time: " + time + "Movie: "
					+ movie);
			seats = sei.getHall(day, time, movie);
			System.out.println(seats);
			makeSeatSelection();
		}
	}

	private void makeSeatSelection() {
		welcome.setText("Please select the seats you want to reserve "
				+ "\ngray Seat boxes are available, green ones selected and red ones already reserved."
				+ "\n\nThe dark gray seats are our super comfy lounge chairs and cost a little more.");

		// remove unneeded stuff
		background.remove(selection);
		background.remove(goOn);

		//show where the screen is:
		JLabel screen = new JLabel("Screen is here");
		background.add(screen);
		// add seats
		makeSeats();
		JButton reserve = new JButton("reserve selected seats");
		reserve.addActionListener(new ReserveListener());
		background.add(reserve);
		invalidate();
		repaint();

	}

	// has to be in here to access all the stuff
	class ReserveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	// generating the seats
	private void makeSeats() {
		JPanel seatDisplay = new JPanel(new GridLayout(0,seats[0].length));//(seats.length - 1,seats[0].length - 1));
		JCheckBox check;
		for (int row = 0; row < seats.length; row++) {
			for (int seatNr = 0; seatNr < seats[0].length; seatNr++) {
				// generate seat checkbox
				check = new JCheckBox("row" + row + " seatNr" + seatNr);
				// colour according to status:
				Status stat = seats[row][seatNr].getStatus();
				TypeOfSeat type = seats[row][seatNr].getType();
				switch (stat) {
				case RESERVED:
					check.setBackground(Color.red);
					check.setEnabled(false);
				case BROKEN:
					check.setBackground(Color.red);
					check.setText("broken");
					check.setEnabled(false);
				case FREE:
					switch (type) {
					case NORMAL:
						check.setBackground(Color.gray);
					case LOUNGE:
						check.setBackground(Color.darkGray);
					}
				}
				seatDisplay.add(check);
			}
		}
		background.add(seatDisplay);
	}

	// generating the radio Button area
	private void makeSelections() {
		makeRadioButtonsForDay();
		makeRadioButtonsForTime();
		makeRadioButtonsForMovie();
		background.add(selection);

	}

	// generating daySelection
	private void makeRadioButtonsForDay() {
		JRadioButton monButton = new JRadioButton("monday");
		monButton.setSelected(true);
		// make buttons
		JRadioButton tueButton = new JRadioButton("tuesday");
		JRadioButton wedButton = new JRadioButton("wednesday");
		JRadioButton thurButton = new JRadioButton("thursday");
		JRadioButton friButton = new JRadioButton("friday");
		JRadioButton satButton = new JRadioButton("saturday");
		JRadioButton sunButton = new JRadioButton("sunday");
		// group them so they work together
		days.add(monButton);
		days.add(tueButton);
		days.add(wedButton);
		days.add(thurButton);
		days.add(friButton);
		days.add(satButton);
		days.add(sunButton);
		// make description label:
		JLabel dayDescr = new JLabel("select a day below: ");
		// //Put the radio buttons in a column in a panel.
		JPanel dayRadioPanel = new JPanel(new GridLayout(0, 1));
		dayRadioPanel.add(dayDescr);
		dayRadioPanel.add(monButton);
		dayRadioPanel.add(tueButton);
		dayRadioPanel.add(wedButton);
		dayRadioPanel.add(thurButton);
		dayRadioPanel.add(friButton);
		dayRadioPanel.add(satButton);
		dayRadioPanel.add(sunButton);

		add(dayRadioPanel, BorderLayout.LINE_START);
		selection.add(dayRadioPanel);

	}

	// generating time selection
	private void makeRadioButtonsForTime() {
		JRadioButton twelveButton = new JRadioButton("12:00");
		twelveButton.setSelected(true);
		// make buttons
		JRadioButton fourButton = new JRadioButton("16:00");
		JRadioButton eightButton = new JRadioButton("20:00");
		// group them so they work together
		times.add(twelveButton);
		times.add(fourButton);
		times.add(eightButton);
		// make description label:
		JLabel timeDescr = new JLabel("select a time below: ");
		// //Put the radio buttons in a column in a panel.
		JPanel timeRadioPanel = new JPanel(new GridLayout(0, 1));
		timeRadioPanel.add(timeDescr);
		timeRadioPanel.add(twelveButton);
		timeRadioPanel.add(fourButton);
		timeRadioPanel.add(eightButton);

		add(timeRadioPanel, BorderLayout.LINE_START);
		selection.add(timeRadioPanel);
	}

	// generating movie selection
	private void makeRadioButtonsForMovie() {
		JRadioButton matrixButton = new JRadioButton("Matrix");
		matrixButton.setSelected(true);
		// make buttons
		JRadioButton guideButton = new JRadioButton(
				"Hitchiker's Guide to the Galaxy");
		JRadioButton twentythreeButton = new JRadioButton("23");
		// group them so they work together
		movies.add(matrixButton);
		movies.add(twentythreeButton);
		movies.add(guideButton);
		// make description label:
		JLabel movieDescr = new JLabel("select a movie below: ");
		// //Put the radio buttons in a column in a panel.
		JPanel movieRadioPanel = new JPanel(new GridLayout(0, 1));
		movieRadioPanel.add(movieDescr);
		movieRadioPanel.add(matrixButton);
		movieRadioPanel.add(twentythreeButton);
		movieRadioPanel.add(guideButton);

		add(movieRadioPanel, BorderLayout.LINE_START);
		selection.add(movieRadioPanel);
	}

	private void setTextAreaToLabelstyle(JTextArea area) {
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		area.setOpaque(true);
		area.setEditable(false);
		area.setFocusable(false);
		area.setBackground(UIManager.getColor("Label.background"));
		area.setFont(UIManager.getFont("Label.font"));
		area.setBorder(UIManager.getBorder("Label.border"));
	}

	// courtesy of
	// https://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}