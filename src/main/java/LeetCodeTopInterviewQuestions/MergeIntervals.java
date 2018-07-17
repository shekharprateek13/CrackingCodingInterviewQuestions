package LeetCodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shekh
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]. 
 */
public class MergeIntervals {

	static class Interval{
		int start;
		int end;
		Interval() { 
			start = 0; 
			end = 0; 
		}
		Interval(int s, int e) { 
			start = s; 
			end = e; 
		}
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> returnList = new LinkedList<Interval>();
		if(intervals.isEmpty()) return returnList; 
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start){
					return -1;
				}else if(o1.start > o2.start){
					return 1;
				}else{
					return 0;
				}
			}
		});
		
		for(Interval interval:intervals){
			System.out.println(interval);
		}

//		returnList.add(intervals.get(0));
//		Interval temp = null;
//		Interval last = null;
//		for(int i = 1; i < intervals.size(); i++){
//			temp = intervals.get(i);
//			last = returnList.getLast();
//			if(last.end >= temp.start){
//				if(last.end < temp.end){
//					returnList.removeLast();
//					returnList.add(new Interval(last.start,temp.end));
//				}
//			}else{
//				returnList.add(temp);
//			}
//		}
		return returnList;
	}

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(362,367));
		list.add(new Interval(314,315));
		list.add(new Interval(133,138));
		list.add(new Interval(434,443));
		list.add(new Interval(202,203));
		list.add(new Interval(144,145));
		list.add(new Interval(229,235));
		list.add(new Interval(205,212));
		list.add(new Interval(314,323));
		list.add(new Interval(128,129));
		list.add(new Interval(413,414));
		list.add(new Interval(342,345));
		list.add(new Interval(43,49));
		list.add(new Interval(333,342));
		list.add(new Interval(173,178));
		list.add(new Interval(386,391));
		list.add(new Interval(131,133));
		list.add(new Interval(157,163));
		list.add(new Interval(187,190));
		list.add(new Interval(186,186));
		list.add(new Interval(17,19));
		list.add(new Interval(63,69));
		list.add(new Interval(70,79));
		list.add(new Interval(386,391));
		list.add(new Interval(98,102));
		list.add(new Interval(236,239));
		list.add(new Interval(195,195));
		list.add(new Interval(338,338));
		list.add(new Interval(169,170));
		list.add(new Interval(151,153));
		list.add(new Interval(409,416));
		list.add(new Interval(377,377));
		list.add(new Interval(90,96));
		list.add(new Interval(156,165));
		list.add(new Interval(182,186));
		list.add(new Interval(371,372));
		list.add(new Interval(228,233));
		list.add(new Interval(297,306));
		list.add(new Interval(56,61));
		list.add(new Interval(184,190));
		list.add(new Interval(401,403));
		list.add(new Interval(221,228));
		list.add(new Interval(203,212));
		list.add(new Interval(39,43));
		list.add(new Interval(83,84));
		list.add(new Interval(66,68));
		list.add(new Interval(80,83));
		list.add(new Interval(32,32));
		list.add(new Interval(182,182));
		list.add(new Interval(300,306));
		list.add(new Interval(235,238));
		list.add(new Interval(267,272));
		list.add(new Interval(458,464));
		list.add(new Interval(114,120));
		list.add(new Interval(452,452));
		list.add(new Interval(372,375));
		list.add(new Interval(275,280));
		list.add(new Interval(302,302));
		list.add(new Interval(5,9));
		list.add(new Interval(54,62));
		list.add(new Interval(237,237));
		list.add(new Interval(432,439));
		list.add(new Interval(415,421));
		list.add(new Interval(340,347));
		list.add(new Interval(356,358));
		list.add(new Interval(165,168));
		list.add(new Interval(15,17));
		list.add(new Interval(259,265));
		list.add(new Interval(201,204));
		list.add(new Interval(192,197));
		list.add(new Interval(376,383));
		list.add(new Interval(210,211));
		list.add(new Interval(362,367));
		list.add(new Interval(481,488));
		list.add(new Interval(59,64));
		list.add(new Interval(307,315));
		list.add(new Interval(155,164));
		list.add(new Interval(465,467));
		list.add(new Interval(55,60));
		list.add(new Interval(20,24));
		list.add(new Interval(297,304));
		list.add(new Interval(207,210));
		list.add(new Interval(322,328));
		list.add(new Interval(139,142));
		list.add(new Interval(192,195));
		list.add(new Interval(28,36));
		list.add(new Interval(100,108));
		list.add(new Interval(71,76));
		list.add(new Interval(103,105));
		list.add(new Interval(34,38));
		list.add(new Interval(439,441));
		list.add(new Interval(162,168));
		list.add(new Interval(433,433));
		list.add(new Interval(368,369));
		list.add(new Interval(137,137));
		list.add(new Interval(105,112));
		list.add(new Interval(278,280));
		list.add(new Interval(452,452));
		list.add(new Interval(131,132));
		list.add(new Interval(475,480));
		list.add(new Interval(126,129));
		list.add(new Interval(95,104));
		list.add(new Interval(93,99));
		list.add(new Interval(394,403));
		list.add(new Interval(70,78));
		merge(list);
		
	}
} 