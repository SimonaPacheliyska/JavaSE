package uni.sofia.fmi.mjt.lambdas;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TableFormatter {
	
	public static final int ROW_WIDTH = 50;
    public static final int NAME_WIDTH = 20;
    public static final int HEIGHT_WIDTH = 10;

    private static final String PIPE = "|";
    private static final String CR = "\n";
	
	public static Stream<String> dashGen(){
		String dashes = new String("-");
		return Stream.generate(dashes::toString);
	}
	
	public static String dashRow() {
		return new String(dashGen().limit(ROW_WIDTH).collect(Collectors.joining()));
	}

	public static String titleRow() {
        return Stream.of(PIPE + " " + String.format("%-20s", "Name") + PIPE, String.format("%10s", "Height") + PIPE,
                String.format("%15s", "Prominence")+ PIPE).collect(Collectors.joining());
}
	
	public static Stream<String> tableHeader(){
		String header = new String(dashRow() + CR + titleRow() + CR + dashRow() + CR);
		return Stream.generate(header::toString);
	}
	
	public static String bodyRow(Peak peak) {
		return new String(PIPE + " " + String.format("%-20s",peak.getName()) + PIPE + 
				String.format("%10s", peak.getHeight()) + PIPE + String.format("%15s",peak.getProminence()) + PIPE +"\n");
	}

}
