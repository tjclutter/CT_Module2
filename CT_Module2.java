import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;


public class CT_Module2 extends JFrame implements ActionListener{
	
	
	//Declare and set to null variables for fields, labels, panel, and button
	private JLabel birthDateLabel = null;
	private JLabel ageLabel = null;
	private JTextField birthDateField = null;
	private JTextField ageField = null;
	private JButton button = null;
	private JPanel panel;
	
	//declare method that counts the number of leap days since input year
	public static int LeapYearCalc(int year) {
		//declare variable count to track leap days and set to 0
		int count = 0;
		
		//run for loop from input year to current year
		for (int i = year; i<2024; i++) {
			//if i is evenly divisible by 4 and not by 100 its a leap year
			if(i%4 == 0) {
				if(i%100 != 0) {
					count++;
				//if i is evenly divisible by four 100 and 400 its a leap year
				}else if (i%400 == 0) {
					count++;
				}
				
			}
		}
	//return count holding number of leap years
	return count;
	}
	
	CT_Module2(){
		
		//add panel object to jFrame and set size
		add(panel = new JPanel());
		panel.setSize(200, 200);
		
		
		//declare variable of GridBagConstraints and set to null
		GridBagConstraints constraint = null;
		
		//create two labels for the later declared fields
		birthDateLabel = new JLabel("Enter Birthdate (month/day/year): ");
		ageLabel = new JLabel("Your age in years is: ");
		
		//customize field for birthdate
		birthDateField = new JTextField(15);
		birthDateField.setEditable(true);
		birthDateField.setText("00/00/0000");
		birthDateField.addActionListener(this);
		
		//customize field for age
		ageField = new JTextField(15);
		ageField.setEditable(false);
		ageField.setText("0");
		
		//customize JButton object and assign to variable button
		button = new JButton("Calculate Age");
		button.addActionListener(this);
		
		//declare panel to be organized using GridBagConstraints
		panel.setLayout(new GridBagLayout());
		
		//set GridBagConstraint variable constraint to new GridBag object
		constraint = new GridBagConstraints();
		
		//customize constraint and add to panel
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.insets = new Insets(10, 10, 10, 10);
		panel.add(birthDateLabel, constraint);
		
		//customize constraint for birthdate field and add to panel
		constraint.gridx = 1;
		constraint.gridy = 0;
		constraint.insets = new Insets(10, 10, 10, 10);
		panel.add(birthDateField, constraint);
		
		//customize constraint for age Label and add to panel
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.insets = new Insets(10, 10, 10, 10);
		panel.add(ageLabel, constraint);
		
		//customize constraint for age field and add to panel
		constraint.gridx = 1;
		constraint.gridy = 1;
		constraint.insets = new Insets(10, 10, 10, 10);
		panel.add(ageField, constraint);
		
		//customize button and add to panel
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.insets = new Insets(10, 10, 10, 10);
		panel.add(button, constraint);
		
	}
			
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//declare input to hold users birthday
		String input;
		
		//declare string to hold substrings of user input
		String strMonth;
		String strDay;
		String strYear;
		
		//declare int variables to hold birth day, month, and year
		int birthMonth;
		int birthDay;
		int birthYear;
		//declare days to hold the amount of days a birthday is from January first
		int birthDays;
		
		
		//get current date and assign current date variables with numbers
		LocalDateTime localDate = LocalDateTime.now();
		int currentMonth = localDate.getMonthValue();
		int currentYear = localDate.getYear();
		int currentDay = localDate.getDayOfMonth();
		int currentDays;
		
		//declare and set month variables containing days sense new year
		int Jan = 0;
		int Feb = 31;
		int Mar = 59;
		int Apr = 90;
		int May = 120;
		int Jun = 151;
		int Jul = 181;
		int Aug = 212;
		int Sep = 243;
		int Oct = 273;
		int Nov = 304;
		int Dec = 334;
		
		//convert current month and day to days since January first
		if (currentMonth == 1) {
			currentDays = Jan + currentDay;
		}else if (currentMonth == 2) {
			currentDays = Feb + currentDay;
		}else if (currentMonth == 3) {
			currentDays = Mar + currentDay;
		}else if (currentMonth == 4) {
			currentDays = Apr + currentDay;
		}else if (currentMonth == 5) {
			currentDays = May + currentDay;
		}else if (currentMonth == 6) {
			currentDays = Jun + currentDay;
		}else if (currentMonth == 7) {
			currentDays = Jul + currentDay;
		}else if (currentMonth == 8) {
			currentDays = Aug + currentDay;
		}else if (currentMonth == 9) {
			currentDays = Sep + currentDay;
		}else if (currentMonth == 10){
			currentDays = Oct + currentDay;
		}else if (currentMonth == 11) {
			currentDays = Nov + currentDay;
		}else {
			currentDays = Dec + currentDay;
		}
		
		//declare variables to hold users age in years and days
		int ageYears;
		int ageDays;
		
		//get user input from birthdate field and store in input variable
		input = birthDateField.getText();
		strMonth = input.substring(0,2);
		strDay = input.substring(3,5);
		strYear = input.substring(6);
		
		//convert string variables to int variables
		birthMonth = Integer.parseInt(strMonth);
		birthDay = Integer.parseInt(strDay);
		birthYear = Integer.parseInt(strYear);
		
		
		
		//determine number of days a birthday is from the start of the year
		//and store in variable days
		if (birthMonth == 1) {
			birthDays = Jan + birthDay;
		}else if (birthMonth == 2) {
			birthDays = Feb + birthDay;
		}else if (birthMonth == 3) {
			birthDays = Mar + birthDay;
		}else if (birthMonth == 4) {
			birthDays = Apr + birthDay;
		}else if (birthMonth == 5) {
			birthDays = May + birthDay;
		}else if (birthMonth == 6) {
			birthDays = Jun + birthDay;
		}else if (birthMonth == 7) {
			birthDays = Jul + birthDay;
		}else if (birthMonth == 8) {
			birthDays = Aug + birthDay;
		}else if (birthMonth == 9) {
			birthDays = Sep + birthDay;
		}else if (birthMonth == 10){
			birthDays = Oct + birthDay;
		}else if (birthMonth == 11) {
			birthDays = Nov + birthDay;
		}else {
			birthDays = Dec + birthDay;
		}
		
			//calculate the age of user in days and years
			
			ageYears = currentYear - birthYear;
			ageDays = currentDays - birthDays;
			
			
			//calculate leapDays using method and add to ageDays
			int leapDays;
			if(birthMonth >  2) {
				leapDays = LeapYearCalc(birthYear + 1);
			}else {
				leapDays = LeapYearCalc(birthYear);
			}
			ageDays = ageDays + leapDays;
		
			//convert age and days to decimal years 
			//and set text of ageField to the value
			double age = ageYears + ((double)ageDays/365.0);
			ageField.setText(Double.toString(age));
		
	}

	public static void main(String[] args) {
				
		//create new frame using constructor of CT_Module2
		CT_Module2 newFrame = new CT_Module2();
		
		//set frame to exit program when closed
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//compacts frame
		newFrame.pack();
		//makes frame visible to user
		newFrame.setVisible(true);
	}

	

}
