package au.com.parcelpoint.coding_challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Robot {

	public static final char CMD_MOVE_FORWARD = 'F';
	public static final char CMD_LOAD_DROP = 'D';
	public static final char CMD_GO_BACK_TO_DEF = 'R';
	public static char CMD_LOAD_START = '{';
	public static char CMD_LOAD_FINISH = '}';

	// A, B, C, D, E
	private List<ParcelColumn> parcelColumns;

	// To track the current position of the robotic arm
	private int currentArmPos = setDefaultCurrentArmPos();

	// column wise capacity
	private Map<String, List<String>> parcelBoxes = new HashMap<String, List<String>>();

	public Robot(List<ParcelColumn> parcelColumns) {
		this.parcelColumns = parcelColumns;
	}

	public Map<String, List<String>> simulateArm(final String input) {
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			
			switch (charAt) {
			case CMD_MOVE_FORWARD:
				moveForward();
				break;

			case CMD_LOAD_DROP:
				i = dropLoad(i, input);
				break;

			case CMD_GO_BACK_TO_DEF:
				setDefaultCurrentArmPos();
				break;
			}
		}

		for (ParcelColumn parcelColumn : parcelColumns) {
			parcelBoxes.put(parcelColumn.getColName(), parcelColumn.getColBoxes());
		}

		return parcelBoxes;
	}

	private int setDefaultCurrentArmPos() {
		return currentArmPos = -1;

	}

	/**
	 * move the robotic arm forward 
	 */
	private void moveForward() {
		++currentArmPos;
	}

	/**
	 * @param strPos - current position
	 * @param input - input string
	 * @return current string position after droping the load
	 */
	private int dropLoad(int strPos, String input) {
		StringBuffer load = new StringBuffer();
		char charAt = input.charAt(++strPos);
		if (charAt == CMD_LOAD_START) {
			while (input.charAt(++strPos) != CMD_LOAD_FINISH) {
				load.append(input.charAt(strPos));
			}
		}

		if (currentArmPos <= parcelColumns.size() - 1) {
			parcelColumns.get(currentArmPos).dropLoadToCol(load.toString());
			moveForward();
		}
		return strPos;
	}

}
