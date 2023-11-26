package BL.DataSources;
import BL.Components.CustomPoint;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class CSV extends DataSource{
	private String fileName;
	private ArrayList<CustomPoint> csvData;
	private String []legends;
	public CSV(String fileName){
		this.fileName = fileName;
		csvData = new ArrayList<>();
	}
	public ArrayList<CustomPoint> getCSVData(){
		return csvData;
	}
	public String [] getLegends(){return legends;}
	public void load(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String temp = "";
			boolean flag = false;
			while((temp = reader.readLine())!=null){
				if(!flag){
					flag = true;

					continue;
				}
				String[] values = temp.split(",");
				values[0] = values[0].trim();
				values[1] = values[1].trim();
				CustomPoint point = new CustomPoint(Double.parseDouble(values[0]),Double.parseDouble(values[1]));
				csvData.add(point);
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}

		try{
			BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
			String temp = reader1.readLine();
			legends = temp.split(",");
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
}