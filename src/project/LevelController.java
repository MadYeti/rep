package project;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LevelController {
	
	private Scanner sc = null;
	
	private int[][] map = new int[10][10];
	private int[][] restartMap = new int[10][10];
	private int[] temp = new int[10];
	private String mapRow = null;
	private InputStream levelsURL = LevelController.class.getResourceAsStream("/levels.txt");
	
	public LevelController() {

	}
	
	// method to get connect to file
	public void getFileConnection() {
		
		sc = new Scanner(levelsURL);
		
	}
	
	/* method to get level map by levelNumber from a file located in "resources/levels"
	 * and transform it from String array to int array using method parseMapRow(String)
	 * next to this method
	 */
	public int[][] getLevelMap(int levelNumber) {
		mapRow = sc.nextLine();
		for(int i = 0; i < 10; i++) {
			mapRow = sc.nextLine();
			parseMapRow(mapRow);
			for(int j = 0; j < map.length; j++) {
				for(int k = i; k < map[j].length; k++) {
					map[k][j] = temp[j];
				}
			}
		}
		return map;
	}
	
	// method to parse mapRow from String to int array
	public void parseMapRow(String row) {
		for(int i = 1; i < 11; i++) {
			int number = Integer.parseInt(row.substring(3*i - 1, 3*i));
			temp[i - 1] = number;
		}
	}
	
	public int[][] getRestartMap(int[][] map){
		restartMap = Arrays.copyOf(map, 10);
		return restartMap;
	}

	
}
