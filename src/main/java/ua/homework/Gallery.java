package ua.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gallery extends JFrame {

	public Gallery() {
		super("Gallery");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {
		setSize(700, 700);
		setVisible(true);
		JPanel jPanel = new JPanel();
		jPanel.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/Pudge.jpg"))));
		jPanel.add(new JLabel("Pudge info: " + readTextInternalFiles("/1.txt")));
		add(jPanel);
	}

	private String readTextInternalFiles(String fileURL) {
		StringBuilder sb = new StringBuilder();
		InputStream is = getClass().getResourceAsStream(fileURL);
		if (Objects.nonNull(is)) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
				String l;
				while ((l = br.readLine()) != null) {
					sb.append(l);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
