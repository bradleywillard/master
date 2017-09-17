package net.bwillard.practice.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupStuff extends JPanel {

	public static void main(String[] args) {
		List<String> groupSets = new ArrayList<>(Arrays.asList("group1",
				"group2"));

		GroupStuff gs = new GroupStuff();
		gs.setGroups(0, 1, groupSets);
	}

	public void setGroups(int groupA, int groupB, List<String> groups) {
		// Do whatever you do here...
	}

	 
	public void paintComponent() {
		List<JTextField[]> textField = new ArrayList<>();

		for (int i = 0; i < textField.size(); i++) {
			JTextField[] jtfArray = textField.get(i);
			for (int j = 0; j < jtfArray.length; j++) {
				add(jtfArray[i]);
			}
		}
	}

}
