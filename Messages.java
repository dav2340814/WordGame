import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Messages {

	public JTextArea textArea = new JTextArea();
	public boolean saveMessages = true;
	public JPanel imgPanel = new JPanel();
	private JLabel imgLabel = null;

	public Messages() {
		textArea.setEditable(false);
	}

	public void setMessage(String msg) {
		if (saveMessages) {
			textArea.setText(textArea.getText() + "\n" + msg);
		} else {
			textArea.setText(msg + "\n");
		}
	}

	public void setMessage(String msg, ImageIcon img) {
		if (saveMessages) {
			textArea.setText(textArea.getText() + "\n" + msg);
		} else {
			textArea.setText(msg + "\n");
		}
		imgLabel = new JLabel();
		imgLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		imgPanel.removeAll();
		imgPanel.add(imgLabel);
	}

	public void reset() {
		textArea.setText(null);
	}
}
