import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GraphicInterface {

	private JFrame frame;
	private JButton fiveButton;
	private JButton tenButton;
	private JButton caffeTenButton;
	private JButton caffeFiftyButton;
	
	private JLabel currentStateLabel;
	private JLabel actionPerformedLabel;
	private Device device;

	
	public GraphicInterface(Device theCaffeMachine) {
		this.device = theCaffeMachine;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		fiveButton = new JButton(" Five $");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(device.getCurrentState().equalsIgnoreCase("TWENTY")) {
					JOptionPane.showMessageDialog(null, "Machine limit is 20 $!", "Warning",

							JOptionPane.WARNING_MESSAGE);
				}else {
					device.takeOrder(Action.FIVE);
					currentStateLabel.setText(device.getCurrentState());
					actionPerformedLabel.setText("Your insert 5 $!");
					buttonStatus();
				}
				
			}
		});
		fiveButton.setBounds(64, 104, 97, 25);
		frame.getContentPane().add(fiveButton);
		
		tenButton = new JButton("Ten $");
		tenButton.setBounds(64, 159, 97, 25);
		frame.getContentPane().add(tenButton);
		tenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(device.getCurrentState().equalsIgnoreCase("FIFTEEN") || device.getCurrentState().equalsIgnoreCase("TWENTY")) {
					JOptionPane.showMessageDialog(null, "Machine limit is 20 $!", "Warning",

							JOptionPane.WARNING_MESSAGE);
				}else {
					device.takeOrder(Action.TEN);
					currentStateLabel.setText(device.getCurrentState());
					actionPerformedLabel.setText("Your insert 10 $!");
					buttonStatus();
				}
			}
		});
		
		caffeTenButton = new JButton("Caffe at 10 $");
		caffeTenButton.setBounds(236, 104, 130, 25);
		caffeTenButton.setEnabled(false);
		frame.getContentPane().add(caffeTenButton);
		
		caffeTenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				device.takeOrder(Action.CAFFE_TEN);
				currentStateLabel.setText(device.getCurrentState());
				actionPerformedLabel.setText("Your 10 $ caffe is ready!");
				buttonStatus();
			}
		});
		
		caffeFiftyButton = new JButton("Caffe at 15 $");
		caffeFiftyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				device.takeOrder(Action.CAFFE_FIFTEEN);
				currentStateLabel.setText(device.getCurrentState());
				actionPerformedLabel.setText("Your 15 $ caffe is ready!");
				buttonStatus();
			}
		});
		caffeFiftyButton.setBounds(236, 159, 130, 25);
		caffeFiftyButton.setEnabled(false);
		frame.getContentPane().add(caffeFiftyButton);
		
		currentStateLabel = new JLabel("");
		currentStateLabel.setBounds(89, 31, 210, 16);
		frame.getContentPane().add(currentStateLabel);
		currentStateLabel.setText(device.getCurrentState());
		
		
		actionPerformedLabel = new JLabel("");
		actionPerformedLabel.setBounds(89, 71, 210, 16);
		frame.getContentPane().add(actionPerformedLabel);
	}
	
	public void buttonStatus() {
		if(device.getCurrentState().equalsIgnoreCase("ZERO") || device.getCurrentState().equalsIgnoreCase("FIVE") ) {
			caffeTenButton.setEnabled(false);
			caffeFiftyButton.setEnabled(false);
		}else if(device.getCurrentState().equalsIgnoreCase("TEN")) {
			caffeTenButton.setEnabled(true);
			caffeFiftyButton.setEnabled(false);
		}else {
			caffeTenButton.setEnabled(true);
			caffeFiftyButton.setEnabled(true);
		}
	}
	
}
