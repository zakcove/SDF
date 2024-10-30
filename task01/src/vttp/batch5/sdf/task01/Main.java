package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "day.csv";
        List<String[]> rows = new ArrayList<>();
        List<String> header = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String headerLine = br.readLine();
        if (headerLine != null) {
            header = Arrays.asList(headerLine.split(","));
        }

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            rows.add(values);
        }

        List<Map.Entry<String[], Integer>> cyclistTotal = rows.stream().map(row -> {
            int casual = Integer.parseInt(row[8].trim());
            int registered = Integer.parseInt(row[9].trim());
            int total = casual + registered;
            return new AbstractMap.SimpleEntry<>(row, total);
        }).collect(Collectors.toList());

        cyclistTotal.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        for (int i = 0; i < 5; i++) {
            Map.Entry<String[], Integer> entry = cyclistTotal.get(i);
            String[] col = entry.getKey();
            int total = entry.getValue();

            String season = Utilities.toSeason(Integer.parseInt(col[0]));;
            String month = Utilities.toMonth(Integer.parseInt(col[1]));
            String holiday = ExtraUtilities.toHoliday(Integer.parseInt(col[2]));
            String weekday = Utilities.toWeekday(Integer.parseInt(col[3]));
            String weather = ExtraUtilities.toWeather(Integer.parseInt(col[4]));
            
            System.out.println("The " + ExtraUtilities.toPosition(i+1) + " recorded number of cyclists was in " + season + ", on a " + weekday + " in the month of " + month + ".\nThere were a total of " + total + " cyclist. The weather was " + weather + ". " + weekday + " was " + holiday + ".\n");

                    
        }
    }
}
