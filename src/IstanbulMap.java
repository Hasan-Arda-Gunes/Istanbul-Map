import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This code finds the path between a station and a destination by trying every route with a recursive method and makes an animation with StdDraw
 * @author Hasan Arda Gunes, Student ID: 2021400003
 * @since Date: 20.03.2023
 */
public class IstanbulMap {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("coordinates.txt");
        Scanner coordinatesScan = new Scanner(file);

        int[] lengths = new int[10];

        // Reading the lines up to the breakpoints
        // The coordinates go into the corresponding arrays
        // The stations go into the corresponding arrays
        // The rgb values go into the corresponding arrays
        int[] rgbB1 = findRGB(coordinatesScan.nextLine());
        String[] line2 = coordinatesScan.nextLine().split(" ");
        String[] B1Stations = findStations(line2);
        int[][] B1Coordinates = findCoordinates(line2);
        lengths[0] = B1Stations.length;

        int[] rgbM1A = findRGB(coordinatesScan.nextLine());
        String[] line4 = coordinatesScan.nextLine().split(" ");
        String[] M1AStations = findStations(line4);
        int[][] M1ACoordinates = findCoordinates(line4);
        lengths[1] = M1AStations.length;

        int[] rgbM1B = findRGB(coordinatesScan.nextLine());
        String[] line6 = coordinatesScan.nextLine().split(" ");
        String[] M1BStations = findStations(line6);
        int[][] M1BCoordinates = findCoordinates(line6);
        lengths[2] = M1BStations.length;

        int[] rgbM2 = findRGB(coordinatesScan.nextLine());
        String[] line8 = coordinatesScan.nextLine().split(" ");
        String[] M2Stations = findStations(line8);
        int[][] M2Coordinates = findCoordinates(line8);
        lengths[3] = M2Stations.length;

        int[] rgbM4 = findRGB(coordinatesScan.nextLine());
        String[] line10 = coordinatesScan.nextLine().split(" ");
        String[] M4Stations = findStations(line10);
        int[][] M4Coordinates = findCoordinates(line10);
        lengths[4] = M4Stations.length;

        int[] rgbM5 = findRGB(coordinatesScan.nextLine());
        String[] line12 = coordinatesScan.nextLine().split(" ");
        String[] M5Stations = findStations(line12);
        int[][] M5Coordinates = findCoordinates(line12);
        lengths[5] = M5Stations.length;

        int[] rgbM6 = findRGB(coordinatesScan.nextLine());
        String[] line14 = coordinatesScan.nextLine().split(" ");
        String[] M6Stations = findStations(line14);
        int[][] M6Coordinates = findCoordinates(line14);
        lengths[6] = M6Stations.length;

        int[] rgbM7 = findRGB(coordinatesScan.nextLine());
        String[] line16 = coordinatesScan.nextLine().split(" ");
        String[] M7Stations = findStations(line16);
        int[][] M7Coordinates = findCoordinates(line16);
        lengths[7] = M7Stations.length;

        int[] rgbM9 = findRGB(coordinatesScan.nextLine());
        String[] line18 = coordinatesScan.nextLine().split(" ");
        String[] M9Stations = findStations(line18);
        int[][] M9Coordinates = findCoordinates(line18);
        lengths[8] = M9Stations.length;

        int[] rgbM11 = findRGB(coordinatesScan.nextLine());
        String[] line20 = coordinatesScan.nextLine().split(" ");
        String[] M11Stations = findStations(line20);
        int[][] M11Coordinates = findCoordinates(line20);
        lengths[9] = M11Stations.length;

        // The rest in the txt file are breakpoints read them and put them in breakpoints array
        String[] breakpoints = new String[7];
        for (int i = 0; i < 7; i++) {
            breakpoints[i] = coordinatesScan.next();
            coordinatesScan.nextLine();
        }

        // find the length of the longest metro line
        int max = 0;
        for (int i = 0; i<lengths.length;i++){
            if (lengths[i] > max)
                max = lengths[i];
        }

        // put all the X Coordinates in a single array
        // put all the Y coordinates in a single array
        int[][] allXCoordinates = new int[10][max];
        int[][] allYCoordinates = new int[10][max];
        allXCoordinates[0] = B1Coordinates[0];
        allXCoordinates[1] = M1ACoordinates[0];
        allXCoordinates[2] = M1BCoordinates[0];
        allXCoordinates[3] = M2Coordinates[0];
        allXCoordinates[4] = M4Coordinates[0];
        allXCoordinates[5] = M5Coordinates[0];
        allXCoordinates[6] = M6Coordinates[0];
        allXCoordinates[7] = M7Coordinates[0];
        allXCoordinates[8] = M9Coordinates[0];
        allXCoordinates[9] = M11Coordinates[0];

        allYCoordinates[0] = B1Coordinates[1];
        allYCoordinates[1] = M1ACoordinates[1];
        allYCoordinates[2] = M1BCoordinates[1];
        allYCoordinates[3] = M2Coordinates[1];
        allYCoordinates[4] = M4Coordinates[1];
        allYCoordinates[5] = M5Coordinates[1];
        allYCoordinates[6] = M6Coordinates[1];
        allYCoordinates[7] = M7Coordinates[1];
        allYCoordinates[8] = M9Coordinates[1];
        allYCoordinates[9] = M11Coordinates[1];

        // put all the rgb values in a single array
        int[][] allRgb = new int[10][3];
        allRgb[0] = rgbB1;
        allRgb[1] = rgbM1A;
        allRgb[2] = rgbM1B;
        allRgb[3] = rgbM2;
        allRgb[4] = rgbM4;
        allRgb[5] = rgbM5;
        allRgb[6] = rgbM6;
        allRgb[7] = rgbM7;
        allRgb[8] = rgbM9;
        allRgb[9] = rgbM11;

        //put all the Station names in a single array
        String[][] allStations = new String[10][max];
        System.arraycopy(B1Stations, 0, allStations[0], 0, B1Stations.length);
        System.arraycopy(M1AStations, 0, allStations[1], 0, M1AStations.length);
        System.arraycopy(M1BStations, 0, allStations[2], 0, M1BStations.length);
        System.arraycopy(M2Stations, 0, allStations[3], 0, M2Stations.length);
        System.arraycopy(M4Stations, 0, allStations[4], 0, M4Stations.length);
        System.arraycopy(M5Stations, 0, allStations[5], 0, M5Stations.length);
        System.arraycopy(M6Stations, 0, allStations[6], 0, M6Stations.length);
        System.arraycopy(M7Stations, 0, allStations[7], 0, M7Stations.length);
        System.arraycopy(M9Stations, 0, allStations[8], 0, M9Stations.length);
        System.arraycopy(M11Stations, 0, allStations[9], 0, M11Stations.length);

        //Take the station inputs
        Scanner input = new Scanner(System.in);
        String startingPoint = input.next();
        String destination = input.next();
        boolean startingPointExist = false;
        boolean destinationExists = false;

        // Check if the stations exist
        for (int i = 0; i < allStations.length; i++) {
            for (int j = 0; j < allStations[0].length; j++) {
                if (allStations[i][j] == null)
                    continue;
                if ((allStations[i][j].equals(startingPoint)) || (allStations[i][j].substring(1).equals(startingPoint))) {
                    startingPointExist = true;
                }
                if (allStations[i][j].equals(destination) || allStations[i][j].substring(1).equals(destination)) {
                    destinationExists = true;
                }
            }
        }

        if ((!(destinationExists)) || (!(startingPointExist))) {
            System.out.println("No such station names on this map");
        }
        else {
            // add the starting point to an arrayList and send it to the method that finds the path
            ArrayList<String> pathIncomplete = new ArrayList<>();
            pathIncomplete.add(startingPoint);
            ArrayList<String> completePath = findPath(pathIncomplete,allStations,destination,startingPoint);

            // If the recursive method can not reach the destination they are not connected
            if (completePath.isEmpty()){
                System.out.println("These two stations are not connected");
            }

            else {
                // setting the canvas
                StdDraw.setCanvasSize(1024,482);
                StdDraw.setXscale(0,1024);
                StdDraw.setYscale(0,482);
                StdDraw.enableDoubleBuffering();
                for (int i = 0; i< completePath.size();i++)
                    System.out.println(completePath.get(i));

                // animation
                // draw the map, draw the points and clear as you advance through the path
                for (int i = 0; i< completePath.size(); i++){
                    StdDraw.clear();
                    drawMap(allStations,allXCoordinates,allYCoordinates,allRgb);
                    StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);

                    // this for loop makes the previous Stations orange
                    for (int j = 0; j<i;j++){
                        String currentPoint = completePath.get(j);
                        int currentPointLineIndex = 0;
                        int currentPointStationIndex = 0;
                        boolean found = false;

                        // finds which station is the currentPoint station
                        for (int k = 0; k< allStations.length;k++){
                            for (int l = 0; l<allStations[0].length;l++){
                                if (allStations[k][l] == null)
                                    continue;
                                if (allStations[k][l].equals(currentPoint)|| allStations[k][l].substring(1).equals(currentPoint)){
                                    currentPointLineIndex = k;
                                    currentPointStationIndex = l;
                                    found = true;
                                    break;
                                }
                            }
                            if (found)
                                break;
                        }
                        // Take the coordinates of the currentPoint Station and draw an orange point there
                        int XCoordinate = allXCoordinates[currentPointLineIndex][currentPointStationIndex];
                        int YCoordinate = allYCoordinates[currentPointLineIndex][currentPointStationIndex];
                        StdDraw.setPenRadius(0.01);
                        StdDraw.point(XCoordinate,YCoordinate);
                    }
                    // The rest is for making a larger orange point at the current Station
                    StdDraw.setPenRadius(0.02);
                    String currentPoint = completePath.get(i);
                    boolean found = false;
                    int currentPointLineIndex = 0;
                    int currentPointStationIndex = 0;

                    // This for loop finds the current Station
                    for (int k = 0; k< allStations.length;k++){
                        for (int l = 0; l<allStations[0].length;l++){
                            if (allStations[k][l] == null)
                                continue;
                            if (allStations[k][l].equals(currentPoint)|| allStations[k][l].substring(1).equals(currentPoint)){
                                currentPointLineIndex = k;
                                currentPointStationIndex = l;
                                found = true;
                                break;
                            }
                        }
                        if (found)
                            break;
                    }
                    // Take the coordinates and draw a large point
                    int XCoordinate = allXCoordinates[currentPointLineIndex][currentPointStationIndex];
                    int YCoordinate = allYCoordinates[currentPointLineIndex][currentPointStationIndex];
                    StdDraw.point(XCoordinate,YCoordinate);
                    StdDraw.show();
                    StdDraw.pause(300);
                }
            }
        }
    }

    /**
     * This method finds the Station names for a given line in the text
     * @param line A line that contains both the Station names and the coordinates
     * @return The names of the stations in the line in an array
     */
    private static String[] findStations(String[] line) {
        // in the text the lines are given in the order one Station name and one coordinate so the even indexes are the Stations
        String[] returnArray = new String[line.length / 2];
        for (int i = 0; i < line.length; i++) {
            if (i % 2 == 0)
                returnArray[i / 2] = line[i];
        }
        return returnArray;
    }


    /**
     * This method finds the coordinates od the stations for a given line in the text
     * @param line A line that contains both the Station names and the coordinates
     * @return The X and Y coordinates of the stations in 2d array
     */
    private static int[][] findCoordinates(String[] line) {
        // in the text the lines are given in the order one Station name and one coordinate so the odd indexes are the Stations
        int[][] returnArray = new int[2][line.length / 2];
        String[] coordinates = new String[line.length / 2];
        for (int i = 0; i < line.length; i++) {
            if (i % 2 != 0) {
                coordinates[i / 2] = line[i];
            }

        }
        // 2d array [0] is the X coordinate [1] is the Y coordinate
        for (int i = 0; i < coordinates.length; i++) {
            String[] tempArray = coordinates[i].split(",");
            returnArray[0][i] = Integer.parseInt(tempArray[0]);
            returnArray[1][i] = Integer.parseInt(tempArray[1]);
        }
        return returnArray;

    }

    /**
     * This method finds the rgb values for a given line
     * @param line A line that contains the name of a metro line and the RGB values
     * @return RGB values as integers in an array
     */
    private static int[] findRGB(String line) {
        int[] returnArray = new int[3];
        String[] tempArray = line.split(" ")[1].split(",");
        returnArray[0] = Integer.parseInt(tempArray[0]);
        returnArray[1] = Integer.parseInt(tempArray[1]);
        returnArray[2] = Integer.parseInt(tempArray[2]);
        return returnArray;
    }

    /**
     * This method draws lines between the stations of a metro line
     * @param coordinates The coordinates of a metro line
     */
    private static void drawLines(int[][] coordinates) {
        for (int i = 0; i < coordinates[0].length - 1; i++) {
            StdDraw.line(coordinates[0][i], coordinates[1][i], coordinates[0][i + 1], coordinates[1][i + 1]);
        }
    }

    /**
     * This method draws white points on the map representing the stations
     * @param coordinates THe coordinates of a metro line
     */
    private static void whiteCircles(int[][] coordinates) {
        for (int i = 0; i < coordinates[0].length; i++) {
            StdDraw.setPenRadius(0.01);
            StdDraw.point(coordinates[0][i], coordinates[1][i]);
        }
    }

    /**
     * This method writes the station names above the white points for the stations starting with "*"
     * @param stations The names of stations of a metro line
     * @param coordinates The coordinates of stations of a metro line
     */
    private static void writeNames(String[] stations, int[][] coordinates) {
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] == null)
                continue;
            if (stations[i].startsWith("*")) {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.setFont(new Font("Helvetica", Font.BOLD, 8));
                StdDraw.text(coordinates[0][i], coordinates[1][i] + 5, stations[i].substring(1));
            }
        }
    }

    /**
     * This method draws the map
     * @param allStations Station names of every line
     * @param allX X coordinates of every line
     * @param allY Y coordinates of every line
     * @param allRgb Rgb values of every line
     */
    private static void drawMap(String[][] allStations, int[][] allX, int[][] allY, int[][] allRgb) {
        for (int i = 0; i<allStations.length; i++){
            int[][] tempCoordinateArray = new int[2][allStations[0].length];
            tempCoordinateArray[0] = allX[i];
            tempCoordinateArray[1] = allY[i];
            StdDraw.setPenRadius(0.012);
            StdDraw.setPenColor(allRgb[i][0],allRgb[i][1],allRgb[i][2]);
            drawLines(tempCoordinateArray);
            StdDraw.setPenColor(Color.white);
            whiteCircles(tempCoordinateArray);
            writeNames(allStations[i],tempCoordinateArray);
        }
    }

    /**
     * This method finds the route between the starting point and the destination
     * @param path The path the metro travels to reach the destination
     * @param allStations The names of every station in an 2d array
     * @param destination The name of the last station
     * @param startingPoint The name of the first station
     * @return The correct route between the starting point and the destination
     */
    private static ArrayList<String> findPath(ArrayList<String> path, String[][] allStations, String destination, String startingPoint) {
        // If the path reaches the destination return the path
        String currentLocation = path.get(path.size() - 1);
        if (path.get(path.size()-1).equals(destination))
            return path;
        ArrayList<Integer> possibleIndexes = new ArrayList<>();
        // Check which metro lines the current station can reach
        for (int i = 0; i < allStations.length; i++) {
            for (int j = 0; j < allStations[0].length; j++) {
                if (allStations[i][j] == null)
                    continue;
                if (allStations[i][j].equals(currentLocation) || allStations[i][j].substring(1).equals(currentLocation))
                    possibleIndexes.add(i);
            }
        }
        ArrayList<String> possibleStations = new ArrayList<>();
        // try moving forward and backwards in the lines from the possibleIndex to see which stations you can go from here
        // If it is the end of a line you can't go forward or if it is the other end you can't go backwards
        // If the path already contains that station do not add it
        for (int i = 0; i < possibleIndexes.size(); i++) {
            for (int j = 0; j < allStations[0].length; j++) {
                if (allStations[possibleIndexes.get(i)][j] == null)
                    continue;
                if (allStations[possibleIndexes.get(i)][j].equals(currentLocation) || allStations[possibleIndexes.get(i)][j].substring(1).equals(currentLocation)){
                    if (j != 0 && allStations[possibleIndexes.get(i)][j-1] != null) {
                        if (!(path.contains(allStations[possibleIndexes.get(i)][j - 1]) || path.contains(allStations[possibleIndexes.get(i)][j - 1].substring(1)))) {
                            if (allStations[possibleIndexes.get(i)][j - 1].startsWith("*"))
                                possibleStations.add(allStations[possibleIndexes.get(i)][j - 1].substring(1));
                            else
                                possibleStations.add(allStations[possibleIndexes.get(i)][j - 1]);
                        }
                    }
                    if (j!= allStations[0].length-1) {
                        if (allStations[possibleIndexes.get(i)][j + 1] != null && (!(path.contains(allStations[possibleIndexes.get(i)][j + 1]) || path.contains(allStations[possibleIndexes.get(i)][j + 1].substring(1))))) {
                            if (allStations[possibleIndexes.get(i)][j + 1].startsWith("*"))
                                possibleStations.add(allStations[possibleIndexes.get(i)][j + 1].substring(1));
                            else
                                possibleStations.add(allStations[possibleIndexes.get(i)][j + 1]);
                        }
                    }
                }

            }
        }
        // try moving to other stations from the possibleStations arrayList
        // After adding the station if the path isn't the right one remove what you added and continue the loop
        // If the metro reaches the end of lines return an empty arrayList
        // If the arrayList is not empty that means the metro reached the destinations and the method returns that path
        for (int i = 0; i< possibleStations.size();i++){
            path.add(possibleStations.get(i));
            if (!findPath(path,allStations,destination,startingPoint).isEmpty())
                return path;
            path.remove(path.size()-1);
        }
        if (possibleStations.isEmpty()){
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}