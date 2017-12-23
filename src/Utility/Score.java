package Utility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Score implements Comparable<Score>{
	public String content;
	private String nm;
	private int sc;
	
	public Score(String name,int score){
		this.nm = name;
		this.sc = score;		
	}
	
	
	
	public static void add(String name,int score) {		//don't know the future
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("score.dat", true))) {
			wr.write(name + "~~" + score + "\n");
			wr.flush();
		} catch (IOException e) {
			Platform.runLater(() -> {
				Alert alert = new Alert(AlertType.ERROR, "Cannot write score to a file.", ButtonType.OK);
				alert.setHeaderText(null);
				alert.setTitle("Error ?");
			});
		}
	}
	
	
	
	
	public static void read() {
		PriorityQueue<Score> pq = new PriorityQueue<>();
		try (BufferedReader in = new BufferedReader(new FileReader("score.dat"))) {
			for (String x = in.readLine(); x != null; x = in.readLine())
            {
				String[] rd = x.split("~~");
				Score c = new Score(rd[0], Integer.parseInt(rd[1]));
				pq.add(c);
            }
			String content = "Top ten ranking :\n\n";
			for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
				Score s = pq.poll();
				content += "\t"+(i + 1) + ".  Chief   " + s.getNm() + "          Score:  " + s.getSc() + "\n";
			}
			Alert alert = new Alert(AlertType.INFORMATION, content, ButtonType.OK);
			alert.setHeaderText("Scoreboard");
			alert.setTitle("Scoreboard");
			alert.showAndWait();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.INFORMATION, "No score record file found.", ButtonType.OK);
			alert.setHeaderText("Scoreboard");
			alert.setTitle("Scoreboard");
			alert.showAndWait();
		}
		
		
		
	}

	
	
	public String getNm() {
		return nm;
	}



	public int getSc() {
		return sc;
	}



	@Override
	public int compareTo(Score o) {
		// TODO Auto-generated method stub	
		return Integer.compare(getSc(), o.getSc());
	}

	
	
	
	
	
	
	
}
