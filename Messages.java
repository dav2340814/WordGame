import javax.swing.JTextArea;

public class Messages {

	public JTextArea textArea = new JTextArea();
	public boolean saveMessages = true;

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

	public void reset() {
		textArea.setText(null);
	}
}
