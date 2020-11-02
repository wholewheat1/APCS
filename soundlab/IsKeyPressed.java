package soundlab;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class IsKeyPressed extends JFrame {

	IsKeyPressed() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				System.out.println(keyCode);
			}
		});
	}

	public static void main(String[] args) {

	}
}