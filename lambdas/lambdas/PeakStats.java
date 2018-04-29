package uni.sofia.fmi.mjt.lambdas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeakStats {
	
	private List<Peak> peaks;
	
	public PeakStats(String datasetPath) {
		
		peaks = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(datasetPath))){
			String line = null;

			while((line = reader.readLine()) != null) {
				peaks.add(Peak.createPeak(line));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Returns the shortest peak by height which have not been climbed yet
	 */
	public double shortestNotAscended() {
		double shortest = peaks.stream()
				.filter(peak -> peak.getClimbs()== 0)
				.map(p -> p.getHeight())
				.reduce(Double::min).orElse(0.0);
		return shortest;
	}
	
	
	/*
	 * Returns the average count of climbs of the peaks in top N
	 */
	public double avgAscentsTopN(int n) {
		double averageClimbs = peaks.subList(0, n).stream()
					.map(peak -> peak.getClimbs())
					.reduce(Integer::sum).get();
		return averageClimbs/(double) n;
	}

	/*
	 * Returns the index of the peak in the dataset which prominence is equal to a given one
	 */
	
	public long getPositionByProminence(double prominence) {
		long indx = peaks.stream()
					.map(peak -> peak.getProminence())
					.collect(Collectors.toList()).
					indexOf(prominence);	
		return indx;
	}
	
	
	/*
	 * 	Returns the highest peak climbed in a given year.
	 *  If there is no such peak, it throws IllegalArgumentException
	 */
	public Peak getHighestAscentPerYear(int year) throws IllegalArgumentException{
		Double theHighestInYear = peaks.stream()
								   .filter(peak -> peak.getYear() == year)
								   .map(peak -> peak.getHeight())
								   .filter(Objects::nonNull)
								   .reduce((p1,p2) -> Double.max(p1, p2))
								   .orElseThrow(() -> new IllegalArgumentException());
		return peaks.stream()
					.filter(peak -> peak.getHeight() == theHighestInYear)
					.findFirst()
					.get();
					
	}
	
	/*
	 * Returns names of the non Himalayan peaks sorted by prominence
	 */
	
	public List<String> getNonHimalayaNamesByProminence(){
		return peaks.stream()
				.filter(peak -> !peak.getMountChain().contains("Himalaya"))
				.map(peak -> peak.getName())
				.collect(Collectors.toList());
	}
	
	/*
	 * Returns the name of the mountain chain that has the most peaks in top N
	 */
	
	public String getRangeWithMostPeaks(int topN) {
		return peaks
				.subList(0, topN)
				.stream()
				.map(peak -> peak.getMountChain())
				.reduce(BinaryOperator.maxBy((chain1, chain2) -> Collections.frequency(peaks, chain1) -
                        Collections.frequency(peaks, chain2))).get();
	}
	
	public String listPeaks(int from, int to) {
	return new String (
			 Stream.concat(Stream.concat(
			  TableFormatter.tableHeader().limit(1),
			  peaks.stream().map(peak -> TableFormatter.bodyRow(peak)).limit(to))
					 ,Stream.of(TableFormatter.dashRow()).limit(1))
			 	.reduce("",String::concat));
	}
	
	@Override
	public String toString() {
		return "PeakStats [" + peaks + "]";
	}

	public static void main(String[] args) {
		PeakStats ststs = new PeakStats("/home/simona/Desktop/dataSet");
		System.out.println(ststs.listPeaks(0, 2));
	}
}
