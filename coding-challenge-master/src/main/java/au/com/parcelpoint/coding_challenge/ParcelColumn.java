package au.com.parcelpoint.coding_challenge;

import java.util.ArrayList;
import java.util.List;

public class ParcelColumn {

	private static final int MAX_ALLOWED_BOXES = 10;
	private String colName;
	private List<String> colBoxes = new ArrayList<>();

	public ParcelColumn(String colName) {
		this.colName = colName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public List<String> getColBoxes() {
		return colBoxes;
	}

	public void setColBoxes(List<String> colBoxes) {
		this.colBoxes = colBoxes;
	}

	public void dropLoadToCol(String load) {
		if(!load.isEmpty() && colBoxes.size()<MAX_ALLOWED_BOXES) {
		colBoxes.add(load);
		}

	}


}
