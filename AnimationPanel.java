import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
	private Image image;
	private float scale;

	public AnimationPanel(Image image) {
		this.image = image;
		this.scale = 1.0f;
	}

	public void setScale(float scale) {
		this.scale = scale;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();
		int imgW = image.getWidth(this);
		int imgH = image.getHeight(this);
		int x = (w - (int) (imgW * scale)) / 2;
		int y = (h - (int) (imgH * scale)) / 2;
		g2d.drawImage(image, x, y, (int) (imgW * scale), (int) (imgH * scale), this);
	}
}
